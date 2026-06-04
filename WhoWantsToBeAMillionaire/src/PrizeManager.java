public class PrizeManager {
    private static final int[] PRIZE_LADDER = {
            100, 200, 300, 500, 1000,
            2000, 4000, 8000, 16_000, 32_000,
            64_000, 125_000, 250_000, 500_000, 1_000_000
    };

    private int currentWinnings;
    private int guaranteedWinnings;

    public PrizeManager() {
        currentWinnings = 0;
        guaranteedWinnings = 0;
    }

    public int getQuestionValue(int questionNumber) {
        return PRIZE_LADDER[questionNumber - 1];
    }

    public void recordCorrectAnswer(int questionNumber) {
        currentWinnings = getQuestionValue(questionNumber);

        if (questionNumber == 5 || questionNumber == 10) {
            guaranteedWinnings = currentWinnings;
        }
    }

    public int getMoneyOnLoss() {
        return guaranteedWinnings;
    }
}
