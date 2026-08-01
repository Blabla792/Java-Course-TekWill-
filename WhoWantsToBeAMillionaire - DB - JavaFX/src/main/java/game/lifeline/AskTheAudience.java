package game.lifeline;

import game.entity.Question;
import game.utils.GlobalUtils;
import org.springframework.stereotype.Component;

import java.util.*;

@Component
public class AskTheAudience extends Lifeline {
    private final Random random = GlobalUtils.RANDOM;

    public Map<Character, Integer> getAskTheAudience(Question question) {
        int numOptions = question.getAnswers().getOptions().size();
        char correctAnswer = question.getAnswers().getCorrectAnswer();
        Difficulty difficulty = setAskTheAudienceDifficulty(question);

        // 1. Calculate the correct answer's percentage based on difficulty bounds
        int minVote = difficulty.getMinVotePercentage();
        int maxVote = difficulty.getMaxVotePercentage();
        int correctVote = minVote + random.nextInt(maxVote - minVote + 1);

        // 2. Get the distribution for the wrong answers
        int remainder = 100 - correctVote;
        int numberOfWrongOptions = numOptions - 1;
        List<Integer> wrongOptions = generateRandomDistribution(remainder, numberOfWrongOptions);

        // 3. Map the results to their corresponding option letters
        // Using LinkedHashMap ensures the map iterates in A, B, C, D order
        Map<Character, Integer> audienceVotes = new LinkedHashMap<>();
        int wrongIndex = 0;

        for (int i = 0; i < numOptions; i++) {
            char currentOption = (char) ('A' + i);

            if (currentOption == correctAnswer) {
                audienceVotes.put(currentOption, correctVote);
            } else {
                audienceVotes.put(currentOption, wrongOptions.get(wrongIndex++));
            }
        }

        return audienceVotes;
    }

    private List<Integer> generateRandomDistribution(int totalSum, int numberBuckets) {
        if (numberBuckets <= 0) return new ArrayList<>();
        if (numberBuckets == 1) return List.of(totalSum);

        List<Integer> cuts = new ArrayList<>();
        for (int i = 0; i < numberBuckets - 1; i++) {
            cuts.add(random.nextInt(totalSum + 1));
        }
        Collections.sort(cuts);

        List<Integer> distribution = new ArrayList<>();
        int previousCut = 0;

        for (int cut : cuts) {
            distribution.add(cut - previousCut);
            previousCut = cut;
        }

        // Add the final remaining piece
        distribution.add(totalSum - previousCut);

        return distribution;
    }

    private Difficulty setAskTheAudienceDifficulty(Question question) {
        int difficultyLevel = question.getDifficultyLevel();

        return switch (difficultyLevel) {
            case 1, 2 -> Difficulty.EASY;
            case 3 -> Difficulty.MEDIUM;
            case 4 -> Difficulty.HARD;
            case 5 -> Difficulty.EXPERT;
            default -> throw new IllegalArgumentException("Invalid difficulty level");
        };
    }
}
