import utils.GlobalUtils;

public class PhoneAFriend {
    private static final int CONFIDENCE_THRESHOLD = 80;

    private final int confidence;
    private boolean isUsed;

    public PhoneAFriend() {
        this.confidence = GlobalUtils.RANDOM.nextInt(100);
        this.isUsed = false;
    }

    public boolean hasBeenUsed() {
        return isUsed;
    }

    public void markAsUsed() {
        isUsed = true;
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
