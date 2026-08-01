package game.lifeline;

import game.entity.Answer;
import game.utils.GlobalUtils;
import org.springframework.stereotype.Component;

@Component
public class PhoneAFriend extends Lifeline {
    private static final int CONFIDENCE_THRESHOLD = 80;

    public boolean isConfident() {
        return GlobalUtils.RANDOM.nextInt(100) < CONFIDENCE_THRESHOLD;
    }

    public char getPhoneAFriendAnswer(Answer answer) {
        char correctLetter = answer.getCorrectAnswer();
        char randomLetter = (char) ('A' + GlobalUtils.RANDOM.nextInt(answer.getOptions().size()));

        if (isConfident()) {
            return correctLetter;
        } else {
            return randomLetter;
        }
    }
}
