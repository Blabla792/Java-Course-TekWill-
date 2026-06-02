import java.util.Random;

public class FiftyFiftyLifeline {
    private final Random random = new Random();
    private boolean isUsed = false;

    public boolean hasBeenUsed() {
        return isUsed;
    }

    public void markAsUsed() {
        this.isUsed = true;
    }

    public String[] getFiftyFiftyAnswers(Answer currectAnswer) {
        String[] questionAnswers = currectAnswer.options();
        char questionCorrectAnswer = currectAnswer.correctAnswer();

        int correctIndex = questionCorrectAnswer - 'A';

        int randomIncorrectIndex;
        do {
            randomIncorrectIndex = random.nextInt(questionAnswers.length);
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
