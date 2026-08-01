package game.service;

import game.entity.Question;
import game.repository.QuestionRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class GameService {
    private final QuestionRepository questionRepository;

    public List<Question> generateGameSession() {
        List<Question> sessionQuestions= new ArrayList<>();

        for (int level = 1; level <= 5; level++) {
            List<Question> randomThreeQuestions =
                    questionRepository.findRandomQuestionsByDifficultyLevel(level);
            sessionQuestions.addAll(randomThreeQuestions);
        }
        return sessionQuestions;
    }
}
