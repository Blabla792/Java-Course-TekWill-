package utils;

import java.util.Scanner;

public class InputHelper {

    public static final Scanner scanner = new Scanner(System.in);

    // Standard getInt. Allowing any integer (positive or negative).
    public static int getInt(String prompt) {
        return getInt(prompt, false);
    }

    // Advanced getInt. Specify if the number MUST be positive.
    public static int getInt(String prompt, boolean positiveValuesOnly) {

        int result = 0;
        boolean isValid = false;

        // Check valid data
        while (!isValid) {
            System.out.print(prompt);

            if (scanner.hasNextInt()) {
                result = scanner.nextInt();

                // Check for positive values here
                if (positiveValuesOnly && result <= 0) {
                    System.out.println("Error: Please enter a positive number (greater than 0).");
                } else {
                    isValid = true;
                }
            } else {
                System.out.println("Error: Invalid input. Please enter a whole number.");
            }
            scanner.nextLine();
        }
        return result;
    }

    // Standard getDouble. Allowing any double (positive or negative).
    public static double getDouble(String prompt) {
        return getDouble(prompt, false);
    }

    // Advanced getDouble. Specify if the number MUST be positive.
    public static double getDouble(String prompt, boolean positiveValuesOnly) {

        double result = 0.0;
        boolean isValid = false;

        while (!isValid) {
            System.out.print(prompt);

            // Check valid data
            if (scanner.hasNextDouble()) {
                result = scanner.nextDouble();

                // Check for positive values here
                if (positiveValuesOnly && result <= 0.0) {
                    System.out.println("Error: Please enter a positive decimal (greater than 0.0).");
                } else {
                    isValid = true;
                }
            } else {
                System.out.println("Error: Invalid input. Please enter a decimal number.");
            }
            scanner.nextLine();
        }
        return result;
    }

    // Standard getString. Prompts the user for text input.
    public static String getString(String prompt) {
        return getString(prompt, false);
    }

    // Advance getString. Prompts the user for text input and optionally enforces a Yes/No response.
    public static String getString(String prompt, boolean isYesOrNo) {
        String result = "";
        boolean isValid = false;

        while (!isValid) {
            System.out.println(prompt);
            result = scanner.nextLine().trim();

            // Check for yes OR no
            if (isYesOrNo) {
                if (result.equalsIgnoreCase("yes") || result.equalsIgnoreCase("no")) {
                    isValid = true;
                } else {
                    System.out.println("Error: Invalid input. Please enter yes or no.");
                }
            } else {
                isValid = true;
            }
        }
        return result;
    }
}
