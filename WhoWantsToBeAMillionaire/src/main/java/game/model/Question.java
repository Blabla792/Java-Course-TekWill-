package game.model;

public class Question {

    private int questionNumber;
    private String question;
    private Answer answers;
    private int difficultyLevel;

    // The default no-argument constructor for Jackson
    public Question() {
    }

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
