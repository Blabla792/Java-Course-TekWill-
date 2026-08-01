import game.entity.Answer;
import game.lifeline.FiftyFifty;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;

public class FiftyFiftyTest {
    FiftyFifty fiftyFifty;

    @BeforeEach
    void setUp() {
        fiftyFifty = new FiftyFifty();
    }

    private Answer createAnswer(int numOptions, char correctChar) {
        List<String> options = new ArrayList<>();
        for (int i = 0; i < numOptions; i++) {
            options.add("Option " + (i + 1));
        }
        return new Answer(options, correctChar);
    }

    @Test
    @DisplayName("Test that all answer options are present in the resulting map")
    void getFiftyFiftyAnswers_withFourOptions_shouldContainAllFourKeys() {
        // Arrange
        Answer answer = createAnswer(4, 'A');

        // Act
        Map<Character, String> result = fiftyFifty.getFiftyFiftyAnswers(answer);

        // Assert
        assertEquals(4, result.size());
        assertTrue(result.containsKey('A'));
        assertTrue(result.containsKey('B'));
        assertTrue(result.containsKey('C'));
        assertTrue(result.containsKey('D'));
    }

    @Test
    @DisplayName("Test that 50:50 keeps exactly two options, one of which must be the correct one")
    void getFiftyFiftyAnswers_withValidAnswer_shouldKeepExactlyTwoOptionsIncludingCorrectOne() {
        // Arrange
        char correctAnswer = 'A';
        Answer answer = createAnswer(4, correctAnswer);

        // Act
        Map<Character, String> result = fiftyFifty.getFiftyFiftyAnswers(answer);

        // Assert
        long optionCount = result.values().stream()
                .filter(s -> !s.equals("     "))
                .count();

        assertEquals(2, optionCount, "Exactly two options should be kept");
        assertNotEquals("     ", result.get(correctAnswer), "The correct answer must never be removed");
    }

    @Test
    @DisplayName("Test that an incorrect answer character outside the range of options throws an exception")
    void getFiftyFiftyAnswers_withOutOfBoundsCorrectAnswer_shouldThrowIllegalArgumentException() {
        // Arrange
        Answer answer = createAnswer(4, 'O');

        // Act & Assert
        assertThrows(IllegalArgumentException.class, () ->
                fiftyFifty.getFiftyFiftyAnswers(answer),
                "An answer character outside the list size should throw IllegalArgumentException");
    }

    @Test
    @DisplayName("Test that providing fewer than two options throws an exception")
    void getFiftyFiftyAnswers_withSingleOption_shouldThrowIllegalStateException() {
        // Arrange
        Answer answer = createAnswer(1, 'A');

        // Act & Assert
        assertThrows(IllegalStateException.class, () ->
                fiftyFifty.getFiftyFiftyAnswers(answer),
                "50:50 cannot function with only one option");
    }
}
