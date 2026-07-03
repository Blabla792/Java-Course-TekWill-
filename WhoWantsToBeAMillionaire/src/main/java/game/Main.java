package game;

import game.core.TriviaGame;
import game.utils.GlobalUtils;

public class Main {

    public static void main(String[] args) {
        String pathToJson = "question/data/questionsData.json";

        if (args.length > 0) {
            pathToJson = args[0];
        }

        displayMainMenu(pathToJson);
    }

    private static void displayMainMenu(String path) {
        boolean inMenu = true;

        while (inMenu) {
            System.out.println("""
                \n===========================================
                      WHO WANTS TO BE A MILLIONAIRE?
                ===========================================
                
                  1. Start Game
                  2. How to Play
                  3. Exit
                
                \nSelect an option (1-3):""");

            String userChose = GlobalUtils.SCANNER.nextLine().trim();

            switch (userChose) {
                case "1" -> {
                    System.out.println("\n---Let's play Who Wants to Be a Millionaire!---".toUpperCase());
                    TriviaGame game = new TriviaGame(path);
                    game.start();
                    inMenu = false;
                }
                case "2" -> {
                    System.out.println("""
                            \n--- HOW TO PLAY ---
                            Answer 15 multiple-choice questions correctly to win $1,000,000.
                            You have 3 lifelines: 50/50, Phone a Friend, and Ask the Audience.
                            
                            Press Enter to return to the menu...""");
                    GlobalUtils.SCANNER.nextLine();
                }
                case "3" -> {
                    System.out.println("Thanks for playing! Goodbye.");
                    System.exit(0);
                }
                default -> System.out.println("Invalid option. Please type 1, 2, or 3.");
            }
        }
    }
}
