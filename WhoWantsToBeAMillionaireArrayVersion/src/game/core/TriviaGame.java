package game.core;

import game.lifeline.AskTheAudience;
import game.lifeline.FiftyFifty;
import game.lifeline.LifelineType;
import game.lifeline.PhoneAFriend;
import game.manager.DataManage;
import game.manager.PrizeManager;
import game.model.Answer;
import game.model.Question;
import game.utils.GlobalUtils;

public class TriviaGame {
    private final DataManage data;
    private final PrizeManager prizeManager;
    private final FiftyFifty fiftyFifty;
    private final PhoneAFriend phoneAFriend;
    private final AskTheAudience askTheAudience;

    public TriviaGame() {
        data = new DataManage();
        prizeManager = new PrizeManager();
        fiftyFifty = new FiftyFifty();
        phoneAFriend = new PhoneAFriend();
        askTheAudience = new AskTheAudience();
    }

    public void start() {
        int totalQuestions = data.getGameQuestions().length;

        for (int i = 0; i < totalQuestions; i++) {
            Question currentQuestion = data.getGameQuestions()[i];
            displayQuestion(currentQuestion);

            int numberOptions = currentQuestion.getAnswers().options().length;
            char maxValidLetter = (char) ('A' + numberOptions - 1);

            boolean answered = false;

            while (!answered) {
                String userChose = GlobalUtils.SCANNER.nextLine().toUpperCase().trim();
                String correctAnswer = String.valueOf(currentQuestion.getAnswers().correctAnswer());

                if (userChose.equals(correctAnswer)) {
                    System.out.printf("Correct answer! You won $%,d!\n",
                            this.prizeManager.getQuestionValue(currentQuestion.getQuestionNumber()));
                    this.prizeManager.recordCorrectAnswer(currentQuestion.getQuestionNumber());
                    answered = true;
                } else if (userChose.equals("1") || userChose.equals("2") || userChose.equals("3")) {
                    handleLifelineChoice(currentQuestion, userChose);
                } else if (userChose.length() == 1 && userChose.charAt(0) >= 'A' && userChose.charAt(0) <= maxValidLetter ) {
                    gameOver(currentQuestion, this.prizeManager);
                    return;
                } else {
                    handleInvalidInput(currentQuestion);
                }
            }
        }
        System.out.println("CONGRATULATIONS! YOU ARE A MILLIONAIRE!");
    }

    private void displayQuestion(Question question) {
        int currentPrize = this.prizeManager.getQuestionValue(question.getQuestionNumber());
        int questionNumber = question.getQuestionNumber();

        String safeHaven = (questionNumber == 5 || questionNumber == 10) ? " [Safe Haven!]".toUpperCase() : "";

        System.out.println("-".repeat(80));
        System.out.println("Level: " + question.getDifficultyLevel());
        System.out.printf("Question %d for $%,d%s:\n\n", question.getQuestionNumber(), currentPrize, safeHaven);
        System.out.println(question.getQuestion());
        System.out.println("-".repeat(80));

        String[] options = question.getAnswers().options();
        for (int i = 0; i < options.length; i++) {
            if (i > 0) {
                System.out.print(" | ");
            }

            char letter = (char) ('A' + i);
            System.out.printf("%c: %s", letter, options[i]);
        }
        System.out.println("\n");

        System.out.println("--- Lifelines ---");
        System.out.println(" 1: 50/50            " + (fiftyFifty.hasBeenUsed() ? "[USED]" : "[AVAILABLE]"));
        System.out.println(" 2: Phone a Friend   " + (phoneAFriend.hasBeenUsed() ? "[USED]" : "[AVAILABLE]"));
        System.out.println(" 3: Ask the Audience " + (askTheAudience.hasBeenUsed() ? "[USED]" : "[AVAILABLE]"));
        System.out.println("-".repeat(80));
    }

    private void displayFiftyFifty(String[] answers) {
        System.out.println("--- 50/50 game.lifeline.Lifeline Used ---");

        for (int i = 0; i < answers.length; i++) {
            if (i > 0) {
                System.out.print(" | ");
            }
            char letter = (char) ('A' + i);
            System.out.printf("%c: %s", letter, answers[i]);
        }
        System.out.println();
        System.out.println("-".repeat(80));
    }

    private void displayPhoneAFriend(Question question) {
        Answer answer = question.getAnswers();
        String questionText = question.getQuestion();
        String[] options = answer.options();

        char suggestedLetter = this.phoneAFriend.getPhoneAFriendAnswer(answer);

        int index = suggestedLetter - 'A';
        String answerText = answer.options()[index];

        int questionValue = this.prizeManager.getQuestionValue(question.getQuestionNumber());

        System.out.println("--- Phone a Friend Used ---");
        System.out.println("Ringing your friend...");
        System.out.println("Friend: Hello?");
        System.out.println("You: I need your help with a question for $" + questionValue + "!");
        System.out.println("You: The question is: " + questionText);

        System.out.println("You: The options are: ");
        printOptions(options);
        System.out.println(".");
        System.out.println("Friend: Let me think...");

        if (this.phoneAFriend.isConfident()) {
            System.out.println("Friend: I'm pretty sure I know this one. The answer is " + suggestedLetter + ": " + answerText);
            System.out.println("-".repeat(80));
        } else {
            System.out.println("Friend: Wow, that's tough. If I had to guess, I'd say " + suggestedLetter + ": " + answerText);
            System.out.println("-".repeat(80));
        }
    }

    private void displayAskTheAudience(Question question) {
        Answer answer = question.getAnswers();
        String[] options = answer.options();

        int[] votePercentages = this.askTheAudience.getAskTheAudience(answer);

        System.out.println("--- Ask the Audience Used ---");

        System.out.print("Host: Audience, pick up your keypads! Vote for ");
        printOptions(options);

        System.out.println("\n...");
        System.out.println("Host: The results are in. Here is what the audience thinks:");

        for (int i = 0; i < options.length; i++) {
            char letter = (char) ('A' + i);

            System.out.printf("%c: %d%% - %s%n", letter, votePercentages[i], options[i]);
        }
        System.out.println("-".repeat(80));
    }

    private static void printOptions(String[] options) {
        for (int i = 0; i < options.length; i++) {
            char letter = (char) ('A' + i);
            System.out.print(letter + ": " + options[i]);

            if (i < options.length - 2) {
                System.out.print(", ");
            } else if (i == options.length - 2) {
                System.out.print(", or ");
            }
        }
    }

    private void handleLifelineChoice(Question question, String userChose) {
        LifelineType choice = LifelineType.fromInt(userChose);

        if (choice == null) {
            handleInvalidInput(question);
            return;
        }

        switch (choice) {
            case FIFTY_FIFTY -> {
                if (this.fiftyFifty.hasBeenUsed()) {
                    System.out.println("You already used 50/50!");
                } else {
                    String[] f = this.fiftyFifty.getFiftyFiftyAnswers(question.getAnswers());
                    displayFiftyFifty(f);
                    this.fiftyFifty.markAsUsed();
                }
            }
            case PHONE_A_FRIEND -> {
                if (this.phoneAFriend.hasBeenUsed()) {
                    System.out.println("You already called a friend!");
                } else {
                    displayPhoneAFriend(question);
                    this.phoneAFriend.markAsUsed();
                }
            }
            case ASK_AUDIENCE -> {
                if (this.askTheAudience.hasBeenUsed()) {
                    System.out.println("You already asked the audience!");
                } else {
                    displayAskTheAudience(question);
                    this.askTheAudience.markAsUsed();
                }
            }
        }
    }

    private void handleInvalidInput(Question question) {
        System.out.print("Invalid input. Please enter ");
        int length = question.getAnswers().options().length;
        for (int i = 0; i < length; i++) {
            System.out.print((char) ('A' + i));
            if (i < length - 1) {
                System.out.print(", ");
            }
        }
        System.out.print(" or 1, 2, 3.\n");
    }

    private void gameOver(Question question, PrizeManager prizeManager) {
        int numberOfQuestions = question.getQuestionNumber();
        char correctAnswerLetter = question.getAnswers().correctAnswer();
        int correctAnswerIndex = correctAnswerLetter - 'A';
        String correctAnswerText = question.getAnswers().options()[correctAnswerIndex];
        int safeHavensMoney = prizeManager.getMoneyOnLoss();

        if (numberOfQuestions <= 5) {
            System.out.printf("""
                    Oh no... I am so sorry, but that is incorrect. The correct answer was %c: %s.
                    Because you haven't reached the first milestone, you are unfortunately leaving with $%d. \
                    Thank you so much for playing!
                    """, correctAnswerLetter, correctAnswerText, safeHavensMoney);
        } else if (numberOfQuestions <= 10) {
            System.out.printf("""
                    You took a brave guess, but unfortunately, that is the wrong answer. It was actually %c: %s.
                    But it's not all bad news! You crossed our first milestone, which means you are not leaving empty-handed. \
                    Congratulations, you are going home with $%d!
                    """, correctAnswerLetter, correctAnswerText, safeHavensMoney);
        } else {
            System.out.printf("""
                    [Heartbeat pause] ...I am so sorry this is wrong answer. The correct answer was %c: %s.
                    It is a devastating drop, but you still played a fantastic game. \
                    You secured the second milestone, and you are leaving here today with $%d!
                    """, correctAnswerLetter, correctAnswerText, safeHavensMoney);
        }
    }
}
