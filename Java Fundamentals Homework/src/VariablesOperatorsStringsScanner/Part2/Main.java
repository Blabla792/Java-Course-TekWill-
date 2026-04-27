package VariablesOperatorsStringsScanner.Part2;

public class Main {

    public static void main(String[] args) {
        // 1. Salary Calculator
        styleMethod();
        System.out.println("Salary Calculator");
        styleMethod();

        SalaryCalculator calculator = new SalaryCalculator();
        System.out.println(calculator.totalSalary());
        System.out.println("#".repeat(50) + "\n");

        // 2. Age in the Future
        styleMethod();
        System.out.println("Age in the Future");
        styleMethod();

        AgeFuture ageFuture = new AgeFuture();
        System.out.println(ageFuture.futureAge());
        System.out.println("#".repeat(50) + "\n");

        // 3. Mini Profile Generator
        styleMethod();
        System.out.println("Mini Profile Generator");
        styleMethod();

        ProfileGenerator profileGenerator = new ProfileGenerator();
        System.out.println(profileGenerator.miniProfile());
        System.out.println("#".repeat(50) + "\n");
    }

    public static void styleMethod() {
        System.out.println("-".repeat(50));
    }
}
