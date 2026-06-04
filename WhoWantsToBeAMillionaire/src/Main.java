public class Main {

    public static void main(String[] args) {

        DataManage data = new DataManage();
        FiftyFiftyLifeline fiftyFifty =  new FiftyFiftyLifeline();
        PrizeManager prizeManager = new PrizeManager();
        PhoneAFriend phoneAFriend = new PhoneAFriend();

        displayQuestion(data.getGameQuestions()[14], prizeManager);

        String[] f = fiftyFifty.getFiftyFiftyAnswers(data.getGameQuestions()[14].getAnswers());
        displayFiftyFiftyLifeline(f);

        displayPhoneAFriend(data.getGameQuestions()[2], phoneAFriend, prizeManager);
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

    public static void displayFiftyFiftyLifeline(String[] answers) {
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

    public static void displayPhoneAFriend(Question question, PhoneAFriend phoneAFriend, PrizeManager prizeManager) {
        Answer answer = question.getAnswers();
        String questionText = question.getQuestion();
        String[] options = answer.options();

        char suggestedLetter = phoneAFriend.getPhoneAFriendAnswer(answer);

        int index = suggestedLetter - 'A';
        String answerText = answer.options()[index];

        int questionValue = prizeManager.getQuestionValue(question.getQuestionNumber());

        System.out.println("--- Phone a Friend Used ---");
        System.out.println("Ringing your friend...");
        System.out.println("Friend: Hello?");
        System.out.println("You: I need your help with a question for $" + questionValue + "!");
        System.out.println("You: The question is: " + questionText);

        System.out.println("You: The options are: ");
        for (int i = 0; i < options.length; i++) {
            char letter = (char) ('A' + i);
            System.out.print(letter + ": " + options[i]);

            if (i < options.length - 2) {
                System.out.print(", ");
            } else if (i == options.length - 2) {
                System.out.print(", or ");
            }
        }
        System.out.println(".");

        if (phoneAFriend.isConfident()) {
            System.out.println("Friend: Oh, I'm pretty sure I know this one. The answer is " + suggestedLetter + ": " + answerText);
        } else {
            System.out.println("Friend: Wow, that's tough. If I had to guess, I'd say " + suggestedLetter + ": " + answerText);
        }
    }
}
