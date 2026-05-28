package homework3.part1;

public class Main {

    public static void main(String[] args) {
        // 1. Personal Information Program
        printSeparator();
        System.out.println("Personal Information Program");
        printSeparator();

        UserClass user1 = new UserClass();
        System.out.println(user1.getUserInfo());
        System.out.println("#".repeat(50) + "\n");

        // 2. Simple Calculator
        printSeparator();
        System.out.println("Simple Calculator");
        printSeparator();

        CalculatorClass calculator = new CalculatorClass();
        System.out.println(calculator.performCalculations());
        System.out.println("#".repeat(50) + "\n");

        // 3. Temperature Converter
        printSeparator();
        System.out.println("Temperature Converter");
        printSeparator();

        TempConvClass tempConv = new TempConvClass();
        System.out.println(tempConv.convertCelsiusToFahrenheit());
        System.out.println("#".repeat(50) + "\n");
    }

    public static void printSeparator() {
        System.out.println("-".repeat(50));
    }
}
