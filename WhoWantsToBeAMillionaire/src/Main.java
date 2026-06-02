import java.util.Scanner;

public class Main {
    Scanner input = new Scanner(System.in);

    public static void main(String[] args) {

        DataManage data = new DataManage();
        FiftyFiftyLifeline fiftyFifty =  new FiftyFiftyLifeline();
        PrizeManager prizeManager = new PrizeManager();

        displayQuestion(data.getGameQuestions()[14], prizeManager);

        String[] f = fiftyFifty.getFiftyFiftyAnswers(data.getGameQuestions()[14].getAnswers());
        displayFiftyFiftyAnswers(f);
    }

    public static void displayQuestion(Question question, PrizeManager prizeManager) {
        int currentPrize = prizeManager.getQuestionValue(question.getQuestionNumber());

        System.out.printf("Question %d for $%,d:\n\n", question.getQuestionNumber(), currentPrize);
        System.out.println(question.getQuestion());

        String[] options = question.getAnswers().options();
        for (int i = 0; i < options.length; i++) {
            if (i > 0) {
                System.out.print(" | ");
            }

            char letter = (char) ('A' + i);
            System.out.printf("%c: %s", letter, options[i]);
        }
        System.out.println("\n");
    }

    public static void displayFiftyFiftyAnswers(String[] answers) {
        System.out.println("--- 50/50 Lifeline Used ---");

        for (int i = 0; i < answers.length; i++) {
            if (i > 0) {
                System.out.print(" | ");
            }
            char letter = (char) ('A' + i);
            System.out.printf("%c: %s", letter, answers[i]);
        }
        System.out.println("\n");
    }
}
