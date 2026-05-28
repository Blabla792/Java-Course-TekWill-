public class Question {

    private final int questionNumber;
    private final String question;
    private final Answer answers;
    private final int difficultyLevel;
    private final int moneyValue;

    public Question(int questionNumber, String question, Answer answers,
                    int moneyValue, int difficultyLevel) {
        this.questionNumber = questionNumber;
        this.question = question;
        this.answers = answers;
        this.moneyValue = moneyValue;
        this.difficultyLevel = difficultyLevel;
    }

    public String getQuestion() {
        return question;
    }

    public Answer getAnswers() {
        return answers;
    }

    public int getQuestionNumber() {
        return questionNumber;
    }

    public int getDifficultyLevel() {
        return difficultyLevel;
    }

    public int getMoneyValue() {
        return moneyValue;
    }

    public void displayQuestion() {
        System.out.printf("Question %d for $%d:\n\n", questionNumber, moneyValue);
        System.out.println(question);

        String[] options = answers.answers();
        for(int i = 0; i < options.length; i++) {
            if(i > 0) {
                System.out.print(" | ");
            }

            char letter = (char) ('A' + i);
            System.out.printf("%c: %s", letter, options[i]);
        }
        System.out.println("\n");
    }

}
