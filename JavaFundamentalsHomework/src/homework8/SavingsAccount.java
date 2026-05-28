package homework8;

public class SavingsAccount {

    private static final int MONTHS_IN_YEAR = 12;

    private static double annualInterestRate;
    private double savingsBalance;

    public SavingsAccount(double savingsBalance) {
        this.savingsBalance = savingsBalance;
    }

    public final void calculateMonthlyInterest() {

        double monthlyInterest = savingsBalance * ((annualInterestRate / 100) / MONTHS_IN_YEAR);

        savingsBalance += monthlyInterest;
    }

    public static void modifyInterestRate(double interestRate) {
        annualInterestRate = interestRate;
    }

    public double getSavingsBalance() {
        return savingsBalance;
    }
}
