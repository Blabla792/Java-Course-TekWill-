package game.service;

import game.entity.Question;
import game.lifeline.AskTheAudience;
import game.lifeline.FiftyFifty;
import game.lifeline.PhoneAFriend;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
@RequiredArgsConstructor
public class TriviaGameService {
    @Getter
    private final GameService gameService;
    @Getter
    private final PrizeManagerService prizeManager;
    @Getter
    private final FiftyFifty fiftyFifty;
    @Getter
    private final PhoneAFriend phoneAFriend;
    @Getter
    private final AskTheAudience askTheAudience;

    private List<Question> selectedQuestions;
    @Getter
    private int currentRound;
    @Getter
    private boolean isGameOver;
    @Getter
    private boolean isGameWon;

    public void startGame() {
        selectedQuestions = gameService.generateGameSession();
        currentRound = 1;
        isGameOver = false;
        isGameWon = false;

        // Reset the trackers
        prizeManager.reset();
        fiftyFifty.reset();
        phoneAFriend.reset();
        askTheAudience.reset();
    }

    public Question getCurrentQuestion() {
        if (isGameOver || isGameWon || currentRound > selectedQuestions.size()) {
            return null;
        }
        return selectedQuestions.get(currentRound - 1);
    }

    public boolean processAnswer(char selectedAnswer) {
        Question currentQuestion = getCurrentQuestion();

        if (currentQuestion == null) return false;

        char correctAnswer = currentQuestion.getAnswers().getCorrectAnswer();

        if (selectedAnswer == correctAnswer) {
            prizeManager.recordCorrectAnswer(currentRound);

            if (currentRound == 15) {
                isGameWon = true;
                isGameOver = true;
            } else {
                currentRound++;
            }
            return true;
        } else {
            return false;
        }
    }

    public Map<Character, String> useFiftyFifty() {
        if (fiftyFifty.hasBeenUsed()) return null;

        Question q = getCurrentQuestion();
        Map<Character, String> result = fiftyFifty.getFiftyFiftyAnswers(q.getAnswers());
        fiftyFifty.markAsUsed();
        return result;
    }

    public Character usePhoneAFriend() {
        if (phoneAFriend.hasBeenUsed()) return null;

        Question q = getCurrentQuestion();
        char suggestedAnswer = phoneAFriend.getPhoneAFriendAnswer(q.getAnswers());
        phoneAFriend.markAsUsed();
        return suggestedAnswer;
    }

    public Map<Character, Integer> useAskTheAudience() {
        if (askTheAudience.hasBeenUsed()) return null;

        Question q = getCurrentQuestion();
        Map<Character, Integer> audienceResults = askTheAudience.getAskTheAudience(q);
        askTheAudience.markAsUsed();
        return audienceResults;
    }
}
