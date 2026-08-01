package game.lifeline;

public abstract class Lifeline {
    private boolean isUsed = false;

    public boolean hasBeenUsed() {
        return isUsed;
    }

    public void markAsUsed() {
        isUsed = true;
    }

    public void reset() {
        isUsed = false;
    }
}
