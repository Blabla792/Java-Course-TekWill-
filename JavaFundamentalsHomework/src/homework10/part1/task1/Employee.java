package homework10.part1.task1;

public class Employee {
    private String name;
    private double baseSalary;

    public Employee(String name, double baseSalary) {
        this.name = name;
        this.baseSalary = baseSalary;
    }

    public String getName() {
        return name;
    }

    public double getBaseSalary() {
        return baseSalary;
    }

    public String getEmployeeReport() {
        return String.format("""
                Employee name: %s
                Employee salary: $%,.2f""",
                name, baseSalary);
    }
}
