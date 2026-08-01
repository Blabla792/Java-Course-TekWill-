package game.controller;

import game.service.TriviaGameService;
import game.entity.Question;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Map;


@Component
@RequiredArgsConstructor
public class GameController {
    private final TriviaGameService triviaGame;

    @FXML
    private Label prizeLabel;
    @FXML
    private Label questionLabel;
    @FXML
    private Button btnA;
    @FXML
    private Button btnB;
    @FXML
    private Button btnC;
    @FXML
    private Button btnD;
    @FXML
    private Button btn5050;
    @FXML
    private Button btnPhone;
    @FXML
    private Button btnAudience;
    @FXML
    private Label messageLabel;
    @FXML
    private Button btnPlayAgain;

    private Button[] optionButtons;

    @FXML
    private void initialize() {
        optionButtons = new Button[]{btnA, btnB, btnC, btnD};

        triviaGame.startGame();
        updateUI();
    }

    private void updateUI() {
        Question currentQuestion = triviaGame.getCurrentQuestion();

        if (currentQuestion == null) {
            return;
        }
        // Hide the monitor when a new round starts
        messageLabel.setVisible(false);

        // 1. Update text labels and check for SAFE HAVEN
        int currentRound = triviaGame.getCurrentRound();
        int currentPrize = triviaGame.getPrizeManager().getQuestionValue(
                triviaGame.getCurrentRound()
        );

        if (currentRound == 5 || currentRound == 10) {
            prizeLabel.setText(String.format("Prize: $%,d   [SAFE HAVEN]", currentPrize));
            // Change color to cyan to highlight safety
            prizeLabel.setStyle("-fx-text-fill: #00ffcc; -fx-effect: dropshadow(gaussian, rgba(0,255,204,0.6), 10, 0, 0, 0);");
        } else {
            prizeLabel.setText(String.format("Prize: $%,d", currentPrize));
            // Default gold
            prizeLabel.setStyle("-fx-text-fill: #ffd700; -fx-effect: dropshadow(gaussian, rgba(255,215,0,0.5), 10, 0, 0, 0);");
        }

        questionLabel.setText(currentQuestion.getQuestionText());

        // 2. Populate and enable answer buttons
        List<String> options = currentQuestion.getAnswers().getOptions();
        for (int i = 0; i < optionButtons.length; i++) {
            optionButtons[i].setDisable(false);
            optionButtons[i].setText((char) ('A' + i) + ": " + options.get(i));
        }

        // 3. Ensure used lifelines remain disabled across rounds
        btn5050.setDisable(triviaGame.getFiftyFifty().hasBeenUsed());
        btnPhone.setDisable(triviaGame.getPhoneAFriend().hasBeenUsed());
        btnAudience.setDisable(triviaGame.getAskTheAudience().hasBeenUsed());
    }

    // --- Action Handlers for Answer Submissions ---

    @FXML
    public void handleAnswerA() {
        submitAnswer('A');
    }

    @FXML
    public void handleAnswerB() {
        submitAnswer('B');
    }

    @FXML
    public void handleAnswerC() {
        submitAnswer('C');
    }

    @FXML
    public void handleAnswerD() {
        submitAnswer('D');
    }

    private void submitAnswer(char answer) {
        boolean isCorrect = triviaGame.processAnswer(answer);

        if (triviaGame.isGameWon()) {
            // --- WIN STATE ---
            questionLabel.setText("🎉 MILLIONAIRE! 🎉");

            messageLabel.setText("CONGRATULATIONS!\nYou have answered all 15 questions correctly and won $1,000,000!");
            // Override the cyan CSS with a bright gold theme for winning
            messageLabel.setStyle("-fx-text-fill: #ffd700; -fx-border-color: #ffd700;" +
                    "-fx-background-color: rgba(50, 40, 0, 0.9); -fx-effect: dropshadow(gaussian, rgba(255,215,0,0.6), 15, 0, 0, 0);");
            messageLabel.setVisible(true);

            endGameLocks();

        } else if (!isCorrect) {
            // --- LOSE STATE ---
            int guaranteed = triviaGame.getPrizeManager().getMoneyOnLoss();

            // Retrieve the correct answer to show the user what they missed
            Question currentQuestion = triviaGame.getCurrentQuestion();
            char correctChar = currentQuestion.getAnswers().getCorrectAnswer();
            int correctIndex = correctChar - 'A';
            String correctText = currentQuestion.getAnswers().getOptions().get(correctIndex);

            questionLabel.setText("GAME OVER");

            messageLabel.setText(String.format("Incorrect! The right answer was %c: %s.\n\nYou are leaving with $%,d.",
                    correctChar, correctText, guaranteed));
            // Override the cyan CSS with a harsh red theme for losing
            messageLabel.setStyle("-fx-text-fill: #ff3333; -fx-border-color: #ff3333; -fx-background-color: rgba(50, 0, 0, 0.9);" +
                    "-fx-effect: dropshadow(gaussian, rgba(255,51,51,0.6), 15, 0, 0, 0);");
            messageLabel.setVisible(true);

            endGameLocks();
        } else {
            // --- CORRECT ANSWER (NEXT ROUND) ---
            // Reset the studio monitor style back to default cyan in case it was modified
            messageLabel.setStyle("");
            updateUI();
        }
    }

    private void endGameLocks() {
        // Disable all answer choices
        for (Button btn : optionButtons) {
            btn.setDisable(true);
        }

        btn5050.setDisable(true);
        btnPhone.setDisable(true);
        btnAudience.setDisable(true);

        btnPlayAgain.setVisible(true);
    }

    @FXML
    public void handlePlayAgain() {
        btnPlayAgain.setVisible(false);
        messageLabel.setVisible(false);

        messageLabel.setStyle("");

        triviaGame.startGame();

        updateUI();
    }

    // --- Action Handlers for Lifelines ---

    @FXML
    public void handle5050() {
        Map<Character, String> remainingOptions = triviaGame.useFiftyFifty();

        if (remainingOptions != null) {
            for (int i = 0; i < optionButtons.length; i++) {
                char optionLetter = (char) ('A' + i);
                String optionText = remainingOptions.get(optionLetter);

                if (optionText.trim().isEmpty()) {
                    optionButtons[i].setText("");
                    optionButtons[i].setDisable(true);
                }
            }
            btn5050.setDisable(true);
        }
    }

    @FXML
    public void handlePhoneFriend() {
        Character suggestion = triviaGame.usePhoneAFriend();

        if (suggestion != null) {
            messageLabel.setText("📞 Ringing your friend...\nFriend: \"Let me think... I'm pretty sure the answer is "
                    + suggestion + "!\"");
            messageLabel.setVisible(true);
            btnPhone.setDisable(true);
        }
    }

    @FXML
    public void handleAskAudience() {
        Map<Character, Integer> results = triviaGame.useAskTheAudience();
        if (results != null) {
            StringBuilder sb = new StringBuilder("👥 The Audience Votes:\n");
            results.forEach((key, value) ->
                    sb.append(key).append(": ").append(value).append("%  |  "));

            sb.setLength(sb.length() - 5);

            messageLabel.setText(sb.toString());
            messageLabel.setVisible(true);
            btnAudience.setDisable(true);
        }
    }
}
