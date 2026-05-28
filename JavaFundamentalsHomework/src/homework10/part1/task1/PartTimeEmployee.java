package homework10.part1.task1;

public class PartTimeEmployee extends Employee {
    private final double workedHours;

    public PartTimeEmployee(String name, double baseSalary, double workedHours) {
        super(name, baseSalary);
        this.workedHours = workedHours;
    }

    private double calculateTotalPaid() {
        return workedHours * getBaseSalary();
    }

    @Override
    public String getEmployeeReport() {
        return String.format("""
                %s per hour
                
                %s worked hours: %.2f
                %s total earnings for hours worked: $%,.2f
                %s can work in multiple departments""",
                super.getEmployeeReport(), super.getName(),workedHours,
                super.getName(), calculateTotalPaid(), super.getName());
    }
}
