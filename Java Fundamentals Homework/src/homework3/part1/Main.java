package homework3.part1;

public class Main {

    public static void main(String[] args) {
        // 1. Personal Information Program
        printStyle();
        System.out.println("Personal Information Program");
        printStyle();

        UserClass user1 = new UserClass();
        System.out.println(user1.input());
        System.out.println("#".repeat(50) + "\n");

        // 2. Simple Calculator
        printStyle();
        System.out.println("Simple Calculator");
        printStyle();

        CalculatorClass calculator = new CalculatorClass();
        System.out.println(calculator.calcs());
        System.out.println("#".repeat(50) + "\n");

        // 3. Temperature Converter
        printStyle();
        System.out.println("Temperature Converter");
        printStyle();

        TempConvClass tempConv = new TempConvClass();
        System.out.println(tempConv.convTempCalcs());
        System.out.println("#".repeat(50) + "\n");
    }

    public static void printStyle() {
        System.out.println("-".repeat(50));
    }
}
