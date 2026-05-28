package homework3.part1;

import utils.InputHelper;

public class CalculatorClass {

    public String performCalculations() {

        int number1 = InputHelper.getInt("Enter first number: ");

        // Call the advanced getInt method for checking if the value is greater than 0.
        int number2 = InputHelper.getInt("Enter second number: ", true);

        int sum = number1 + number2;
        // Calculate absolute difference.
        int difference = Math.abs(number1 - number2);
        int multiplication = number1 * number2;
        double division = (double) number1 / number2;

        System.out.println("-".repeat(50));

        return String.format("""
                        Sum: %d
                        Difference: %d
                        Multiplication: %d
                        Division: %.2f""",
                sum, difference, multiplication, division);
    }
}
