import java.util.Scanner;

public class CalculatorClass {

    private int number1;
    private int number2;

    public String calcs() {

        Scanner input = new Scanner(System.in);

        System.out.println("Enter first number: ");
        this.number1 = Integer.parseInt(input.nextLine());

        System.out.println("Enter second number: ");
        this.number2 = Integer.parseInt(input.nextLine());

        int sum = number1 + number2;
        int difference = Math.abs(number1 - number2);
        int multiplication = number1 * number2;
        double division = (double) number1 / number2;

        System.out.println("-".repeat(50));

        return String.format("Sum: %d\n" +
                "Difference: %d\n" +
                "Multiplication: %d\n" +
                "Division: %.2f",
                sum, difference, multiplication, division);
    }
}
