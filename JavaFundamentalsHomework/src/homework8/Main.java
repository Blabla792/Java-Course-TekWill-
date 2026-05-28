package homework8;

public class Main {

    public static void main(String[] args) {

        SavingsAccount saver1 = new SavingsAccount(2000);
        SavingsAccount saver2 = new SavingsAccount(3000);

        SavingsAccount[] accounts = {saver1,saver2};

        printInterestTable(accounts, 4, "4% Interest");

        printInterestTable(accounts, 5, "5% Interest");

    }

    public static void printInterestTable(SavingsAccount[] accounts, double interestRate,
                                           String tableTitle) {

        SavingsAccount.modifyInterestRate(interestRate);

        System.out.println("=".repeat(60));
        System.out.println(tableTitle);
        System.out.println("-".repeat(60));
        System.out.printf("%-10s | %-15s | %-15s | %-15s%n",
                "Account", "Initial Balance", "Interest Earned", "New Balance");
        System.out.println("-".repeat(60));

        for (int i = 0; i < accounts.length; i++) {

            double initialBalance = accounts[i].getSavingsBalance();

            accounts[i].calculateMonthlyInterest();

            double newBalance = accounts[i].getSavingsBalance();
            double interestEarned = newBalance - initialBalance;

            System.out.printf("Saver %-4d | $%,-14.2f | $%,-14.2f | $%,-14.2f%n",
                    (i + 1), initialBalance, interestEarned, newBalance);
        }

        System.out.println("=".repeat(60));
    }
}
