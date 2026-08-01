import game.entity.Answer;
import game.entity.Question;
import game.lifeline.AskTheAudience;
import game.lifeline.Difficulty;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;

public class AskTheAudienceTest {
    private AskTheAudience askTheAudience;

    @BeforeEach
    void setup() {
        askTheAudience = new AskTheAudience();
    }

    private Question createQuestion(int difficultyLevel, char correctChar, int numOptions) {
        List<String> options = new ArrayList<>();
        for (int i = 0; i < numOptions; i++) {
            options.add("Option " + (i + 1));
        }
        Answer answer = new Answer(options, correctChar);
        return new Question(1L, "Test Question", difficultyLevel, answer);
    }

    @Test
    @DisplayName("Test that the total percentage always sums to 100")
    void getAskTheAudience_withValidQuestion_shouldSumTo100Percent() {
        // Arrange
        Question question = createQuestion(3, 'B', 4);

        // Act
        Map<Character, Integer> result = askTheAudience.getAskTheAudience(question);

        // Assert
        int totalVotes = result.values().stream().mapToInt(Integer::intValue).sum();
        assertEquals(100, totalVotes, "The sum of all audience votes must be exactly 100");
    }

    @Test
    @DisplayName("Test that all answer options are present in the resulting map")
    void getAskTheAudience_withFourOptions_shouldContainAllFourKeys() {
        // Arrange
        Question question = createQuestion(1, 'A', 4);

        // Act
        Map<Character, Integer> result = askTheAudience.getAskTheAudience(question);

        // Assert
        assertEquals(4, result.size());
        assertTrue(result.containsKey('A'));
        assertTrue(result.containsKey('B'));
        assertTrue(result.containsKey('C'));
        assertTrue(result.containsKey('D'));
    }

    @ParameterizedTest
    @CsvSource({
            "1, EASY",
            "2, EASY",
            "3, MEDIUM",
            "4, HARD",
            "5, EXPERT"
    })
    @DisplayName("Test that the correct answer percentage is within the range defined by the difficulty")
    void getAskTheAudience_withSpecificDifficulty_shouldReturnVoteWithinDifficultyBounds(int difficultLevel, Difficulty expectedDifficulty) {
        // Arrange
        char correctChar = 'C';
        Question question = createQuestion(difficultLevel, correctChar, 4);

        // Act
        Map<Character, Integer> result = askTheAudience.getAskTheAudience(question);
        int actualVote = result.get(correctChar);

        // Assert
        int minVote = expectedDifficulty.getMinVotePercentage();
        int maxVote = expectedDifficulty.getMaxVotePercentage();

        assertTrue(actualVote >= minVote && actualVote <= maxVote,
                String.format("For difficulty %s, vote %d should be between %d and %d", expectedDifficulty,
                        actualVote, minVote, maxVote));
    }

    @Test
    @DisplayName("Test that an invalid difficulty level throws an exception")
    void getAskTheAudience_withInvalidDifficultyLevel_shouldThrowIllegalArgumentException() {
        // Arrange
        Question question = createQuestion(99, 'A', 4);

        // Act & Assert
        assertThrows(IllegalArgumentException.class, () ->
                askTheAudience.getAskTheAudience(question),
                "Difficulty level 99 should trigger an IllegalArgumentException");
    }

}
