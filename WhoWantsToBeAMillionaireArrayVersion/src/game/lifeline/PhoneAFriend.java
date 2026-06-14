package game.lifeline;

import game.model.Answer;
import game.utils.GlobalUtils;

public class PhoneAFriend extends Lifeline {
    private static final int CONFIDENCE_THRESHOLD = 80;

    private final int confidence;

    public PhoneAFriend() {
        this.confidence = GlobalUtils.RANDOM.nextInt(100);
    }

    public boolean isConfident() {
        return confidence < CONFIDENCE_THRESHOLD;
    }

    public char getPhoneAFriendAnswer(Answer answer) {
        char correctLetter = answer.correctAnswer();
        char randomLetter = (char) ('A' + GlobalUtils.RANDOM.nextInt(answer.options().length));

        if (isConfident()) {
            return correctLetter;
        } else {
            return randomLetter;
        }
    }
}
