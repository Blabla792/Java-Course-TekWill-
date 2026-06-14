package game.lifeline;

import game.model.Answer;
import game.utils.GlobalUtils;

public class AskTheAudience extends Lifeline {

    public int[] getAskTheAudience(Answer answer) {
        int[] votes = new int[answer.options().length];

        int correctAnswerIndex = answer.correctAnswer() - 'A';

        // Give the correct answer a random large chunk (between 40% and 85%)
        int correctVote = 40 + GlobalUtils.RANDOM.nextInt(46);
        votes[correctAnswerIndex] = correctVote;

        int remainder = 100 - correctVote;

        int cut1 = GlobalUtils.RANDOM.nextInt(remainder + 1);
        int cut2 = GlobalUtils.RANDOM.nextInt(remainder + 1);

        int minCut = Math.min(cut1, cut2);
        int maxCut = Math.max(cut1, cut2);

        int wrong1 = minCut;
        int wrong2 = maxCut - minCut;
        int wrong3 = remainder - maxCut;

        int[] wrongVotes = {wrong1, wrong2, wrong3};
        int wrongIndex = 0;

        for (int i = 0; i < votes.length; i++) {
            if (i != correctAnswerIndex) {
                votes[i] = wrongVotes[wrongIndex];
                wrongIndex++;
            }
        }
        return votes;
    }
}
