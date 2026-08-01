package game.lifeline;

import lombok.Getter;

@Getter
public enum Difficulty {
    EASY(75, 95),
    MEDIUM(50, 75),
    HARD(25, 45),
    EXPERT(15, 35);

    private final int minVotePercentage;
    private final int maxVotePercentage;

    Difficulty(int min, int max) {
        this.minVotePercentage = min;
        this.maxVotePercentage = max;
    }

}
