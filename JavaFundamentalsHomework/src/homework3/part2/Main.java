package homework3.part2;

public class Main {

    public static void main(String[] args) {
        // 1. Salary Calculator
        printSeparator();
        System.out.println("Salary Calculator");
        printSeparator();

        SalaryCalculator calculator = new SalaryCalculator();
        System.out.println(calculator.calculateSalary());
        System.out.println("#".repeat(50) + "\n");

        // 2. Age in the Future
        printSeparator();
        System.out.println("Age in the Future");
        printSeparator();

        AgeFuture ageFuture = new AgeFuture();
        System.out.println(ageFuture.futureAge());
        System.out.println("#".repeat(50) + "\n");

        // 3. Mini Profile Generator
        printSeparator();
        System.out.println("Mini Profile Generator");
        printSeparator();

        ProfileGenerator profileGenerator = new ProfileGenerator();
        System.out.println(profileGenerator.miniProfile());
        System.out.println("#".repeat(50) + "\n");
    }

    public static void printSeparator() {
        System.out.println("-".repeat(50));
    }
}
