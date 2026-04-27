package VariablesOperatorsStringsScanner.Part2;

import java.util.Scanner;

public class SalaryCalculator {

    public String totalSalary() {

        Scanner input = new Scanner(System.in);

        System.out.println("Enter your name: ");
        String name = input.nextLine();

        System.out.println("Enter your hourly rate: ");
        double hourlyRate = Double.parseDouble(input.nextLine());

        System.out.println("Enter your hours worked: ");
        double hoursWorked = Double.parseDouble(input.nextLine());

        Double salary = hoursWorked * hourlyRate;

        System.out.println("-".repeat(50));

        return String.format("%s's salary is %.2f", name, salary);
    }
}
