package utils;

import java.util.Scanner;
/**
 * A utility class providing robust methods for capturing and validating user input
 * from the console. Handles common data types and input error scenarios.
 */
public class InputHelper {

    /** Shared scanner instance for all input operations. */
    public static final Scanner scanner = new Scanner(System.in);

    /**
     * Prompts the user for a whole number.
     *
     * @param prompt The message to display to the user.
     * @return The integer entered by the user.
     */
    public static int getInt(String prompt) {

        return getInt(prompt, false);
    }

    /**
     * Prompts the user for a whole number with optional positivity validation.
     *
     * @param prompt             The message to display to the user.
     * @param positiveValuesOnly If true, the method will reject numbers <= 0.
     * @return A valid integer provided by the user.
     */
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
            scanner.nextLine(); // Clear the buffer
        }
        return result;
    }

    /**
     * Prompts the user for a decimal number.
     *
     * @param prompt The message to display to the user.
     * @return The double entered by the user.
     */
    public static double getDouble(String prompt) {

        return getDouble(prompt, false);
    }

    /**
     * Prompts the user for a decimal number with optional positivity validation.
     *
     * @param prompt             The message to display to the user.
     * @param positiveValuesOnly If true, the method will reject numbers <= 0.0.
     * @return A valid double provided by the user.
     */
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
            scanner.nextLine(); // Clear the buffer
        }
        return result;
    }

    /**
     * Prompts the user for a single line of text.
     *
     * @param prompt The message to display to the user.
     * @return The string entered by the user, trimmed of whitespace.
     */
    public static String getString(String prompt) {

        return getString(prompt, false);
    }

    /**
     * Prompts the user for text, optionally forcing a "yes" or "no" response.
     *
     * @param prompt     The message to display to the user.
     * @param isYesOrNo  If true, will repeat until user enters "yes" or "no" (case-insensitive).
     * @return The validated string input.
     */
    public static String getString(String prompt, boolean isYesOrNo) {

        String result = null;
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

    /**
     * Prompts the user for a string of numbers and splits them into an array.
     *
     * @param prompt    The message to display (e.g., "Enter 3 numbers separated by commas").
     * @param separator The delimiter string used to split the input (e.g., ",").
     * @return An array of integers parsed from the user's input.
     */
    public static int[] getIntArray(String prompt, String separator) {

        return getIntArray(prompt, separator, false);
    }

    /**
     * Prompts the user for a string of numbers, splits them into an array,
     * and optionally validates that all numbers are positive.
     *
     * @param prompt             The message to display to the user.
     * @param separator          The delimiter string used to split the input.
     * @param positiveValuesOnly If true, will reject the input if any number is <= 0.
     * @return A validated array of integers.
     */
    public static int[]  getIntArray(String prompt, String separator,
                                     boolean positiveValuesOnly) {

        int[] result = null;
        boolean isValid = false;
        while (!isValid) {
            System.out.println(prompt);

            String input = scanner.nextLine();
            String[] splitInput = input.split(separator);
            result = new int[splitInput.length];

            try {
                boolean allPositive = true;
                for (int i = 0; i < splitInput.length; i++) {
                    int value = Integer.parseInt(splitInput[i].trim());
                    if (positiveValuesOnly && value <= 0) {
                        System.out.println("Error: Please enter a positive number" +
                                " (greater than 0).");
                        allPositive = false;
                        break;
                    }
                    result[i] = value;
                }

                if (allPositive) {
                    isValid = true;
                }
            } catch (NumberFormatException e) {
                System.out.println("Error: Invalid input. Please enter an integers.");
            }
        }
        return result;
    }

    /**
     * Prompts the user multiple times to populate a 2D array row by row.
     * Generates a numbered prompt for each row and optionally validates that
     * all entered numbers are positive.
     *
     * @param numbersOfRows      The total number of rows the 2D array should contain.
     * @param separator          The delimiter string used to split the input for each row.
     * @param positiveValuesOnly If true, will reject the input if any number is <= 0.
     * @return A populated 2D array of integers based on the user's inputs.
     */
    public static int[][] getIntArrayArray(int numbersOfRows,
                                           String separator, boolean positiveValuesOnly) {

        int[][] result = new int[numbersOfRows][];

        for (int i = 0; i < numbersOfRows; i++) {
            String prompt = "Enter numbers for row " + (i + 1) + ", separated by '" + separator + "': ";
            result[i] = getIntArray(prompt, separator, positiveValuesOnly);
        }

        return result;
    }
}
