package game.lifeline;

import game.model.Answer;
import game.utils.GlobalUtils;

public class FiftyFifty extends Lifeline {

    public String[] getFiftyFiftyAnswers(Answer currectAnswer) {
        String[] questionAnswers = currectAnswer.options();
        char questionCorrectAnswer = currectAnswer.correctAnswer();

        int correctIndex = questionCorrectAnswer - 'A';

        int randomIncorrectIndex;
        do {
            randomIncorrectIndex = GlobalUtils.RANDOM.nextInt(questionAnswers.length);
        } while (randomIncorrectIndex == correctIndex);

        String[] result = new String[questionAnswers.length];

        for (int i = 0; i < result.length; i++) {
            if (i == correctIndex || i == randomIncorrectIndex) {
                result[i] = questionAnswers[i];
            } else {
                result[i] = "    ";
            }
        }

        return result;
    }
}
