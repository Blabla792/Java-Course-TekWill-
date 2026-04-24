import java.util.Scanner;

public class SalaryCalculator {

    private String name;
    private double hourlyRate;
    private double hoursWorked;

    public String totalSalary() {

        Scanner input = new Scanner(System.in);

        System.out.println("Enter your name: ");
        this.name = input.nextLine();

        System.out.println("Enter your hourly rate: ");
        this.hourlyRate = Double.parseDouble(input.nextLine());

        System.out.println("Enter your hours worked: ");
        this.hoursWorked = Double.parseDouble(input.nextLine());

        Double salary = this.hoursWorked * this.hourlyRate;

        System.out.println("-".repeat(50));

        return String.format("%s's salary is %.2f", this.name, salary);
    }
}
