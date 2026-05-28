package homework10.part1.task1;

public class FullTimeEmployee extends Employee {
    private final double annualBonus;

    private static final int MOTHS_IN_YEAR = 12;

    public FullTimeEmployee(String name, int salary, int annualBonus) {
        super(name, salary);
        this.annualBonus = annualBonus;
    }

    private double calculateBonusAmount() {
        return (super.getBaseSalary() * MOTHS_IN_YEAR) * (annualBonus / 100);
    }

    private double calculateAnnualSalary() {
        return super.getBaseSalary() * MOTHS_IN_YEAR;
    }

    @Override
    public String getEmployeeReport() {
        return String.format("""
                %s per month
                
                %s annual salary: $%,.2f
                %s has an annual bonus in the amount of $%,.2f
                %s have paid vacation days""",
                super.getEmployeeReport(), super.getName(), calculateAnnualSalary(),
                super.getName(), calculateBonusAmount(), super.getName());
    }
}
