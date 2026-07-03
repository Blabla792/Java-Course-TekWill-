package game.lifeline;

import game.model.Answer;

import java.util.*;

public class FiftyFifty extends Lifeline {

    public Map<Character, String> getFiftyFiftyAnswers(Answer answer) {
        List<String> options = answer.options();
        int numberOptions = options.size();
        char correctAnswer = answer.correctAnswer();
        List<Character> incorrectOptions = getIncorrectOptions(correctAnswer, numberOptions);

        Collections.shuffle(incorrectOptions);
        char randomIncorrectLetter = incorrectOptions.getFirst();

        Map<Character, String> remainingOptions = new LinkedHashMap<>();

        for (int i = 0; i < numberOptions; i++) {
            char currentOption = (char) ('A' + i);

            if (currentOption == correctAnswer || currentOption == randomIncorrectLetter) {
                remainingOptions.put(currentOption, options.get(i));
            } else {
                remainingOptions.put(currentOption, "     ");
            }
        }

        return remainingOptions;
    }

    private static List<Character> getIncorrectOptions(char correctAnswer, int numberOptions) {
        int correctIndex = correctAnswer - 'A';

        if (correctIndex < 0 || correctIndex >= numberOptions) {
            throw new IllegalArgumentException("Correct answer index out of bounds.");
        }
        if (numberOptions < 2) {
            throw new IllegalStateException("Not enough options to use 50:50.");
        }

        List<Character> incorrectOptions = new ArrayList<>();
        for (int i = 0; i < numberOptions; i++) {
            if (i != correctIndex) {
                incorrectOptions.add((char) ('A' + i));
            }
        }
        return incorrectOptions;
    }
}
