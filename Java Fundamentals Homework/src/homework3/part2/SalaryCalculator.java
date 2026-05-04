package homework3.part2;

import utils.InputHelper;

public class SalaryCalculator {

    public String calculateSalary() {

        String name = InputHelper.getString("Enter your name: ");
        // Call the advanced getDouble method for checking if the value is greater than 0.
        double hourlyRate = InputHelper.getDouble("Enter your hourly rate: ",
                true);
        double hoursWorked = InputHelper.getDouble("Enter your hours worked: ",
                true);
        double salary = hoursWorked * hourlyRate;

        System.out.println("-".repeat(50));

        return String.format("%s's salary is %.2f", name, salary);
    }
}
