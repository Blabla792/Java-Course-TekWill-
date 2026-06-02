public class Question {

    private int questionNumber;
    private final String question;
    private final Answer answers;
    private final int difficultyLevel;

    public Question(int questionNumber, String question, Answer answers, int difficultyLevel) {
        this.questionNumber = questionNumber;
        this.question = question;
        this.answers = answers;
        this.difficultyLevel = difficultyLevel;
    }

    public String getQuestion() {
        return question;
    }

    public Answer getAnswers() {
        return answers;
    }

    public void setQuestionNumber(int questionNumber) {
        this.questionNumber = questionNumber;
    }

    public int getQuestionNumber() {
        return questionNumber;
    }

    public int getDifficultyLevel() {
        return difficultyLevel;
    }
}
