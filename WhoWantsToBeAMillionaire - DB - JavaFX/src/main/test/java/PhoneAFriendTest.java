import game.entity.Answer;
import game.lifeline.PhoneAFriend;
import lombok.Setter;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class PhoneAFriendTest {
    @Setter
    private static class TestablePhoneAFriend extends PhoneAFriend {
        private boolean confidence;

        @Override
        public boolean isConfident() {
            return confidence;
        }
    }

    private Answer createAnswer(int numberOfOptions, char correctLetter) {
        List<String> options = new ArrayList<>();
        for (int i = 0; i < numberOfOptions; i++) {
            options.add("Option " + i++);
        }
        return new Answer(options, correctLetter);
    }

    @Test
    @DisplayName("Should return the correct letter when the friend is confident")
    void getPhoneAFriendAnswer_withConfidence_shouldReturnCorrectLetter() {
        // Arrange
        TestablePhoneAFriend testablePhoneAFriend = new TestablePhoneAFriend();
        testablePhoneAFriend.setConfidence(true);
        Answer answer = createAnswer(4, 'A');

        // Act
        char result = testablePhoneAFriend.getPhoneAFriendAnswer(answer);

        // Assert
        assertEquals('A', result, "When confident, the friend must return the correct answer");
    }

    @Test
    @DisplayName("Should return a valid option letter when the friend is not confident")
    void getPhoneAFriendAnswer_whenNotConfident_shouldReturnAnyValidLetter() {
        // Arrange
        TestablePhoneAFriend testablePhoneAFriend = new TestablePhoneAFriend();
        testablePhoneAFriend.setConfidence(false);
        Answer answer = createAnswer(4, 'C');

        // Act
        char result = testablePhoneAFriend.getPhoneAFriendAnswer(answer);

        // Assert
        assertTrue(result >= 'A' && result <= 'D', "The result should be a valid option letter");
    }
}
