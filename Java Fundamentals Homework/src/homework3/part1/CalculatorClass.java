package homework3.part1;

import java.util.Scanner;

public class CalculatorClass {

    public String calcs() {

        Scanner input = new Scanner(System.in);

        System.out.println("Enter first number: ");
        int number1 = Integer.parseInt(input.nextLine());

        System.out.println("Enter second number: ");
        int number2 = Integer.parseInt(input.nextLine());

        int sum = number1 + number2;
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
