package homework5.task6;

import homework5.task6.utils.InputHelper;

public class Main {

    public static void main(String[] args) {

        calculateAndPrintConversion();
    }

    public static double getNumbers () {

        double number = 0;
        boolean flag = false;
        while (!flag) {
            try {
                number = Double.parseDouble(InputHelper.scanner.nextLine());
                flag = true;
            } catch (NumberFormatException e) {
                System.out.println("Invalid value, needs to be a number");
            }
        }

        return number;
    }

    public static void calculateAndPrintConversion () {

        boolean flag = false;
        while (!flag) {

            System.out.println("Provide currency code (EUR, GBP, INR, AUD): ");
            String currencyCode = InputHelper.scanner.nextLine().toUpperCase();

            switch (currencyCode) {
                case "EUR", "GBP", "INT", "AUD" -> {

                    System.out.println("Enter USD value: ");
                    double usdValue = getNumbers();

                    System.out.printf("Enter %s conversion rate: ", currencyCode);

                    double result = usdValue * getNumbers();

                    System.out.printf("Converted value from USD to %s is: %.2f %s\n", currencyCode, result,
                            currencyCode);
                    flag = true;
                }
                default -> System.out.println("Unsupported currency.");
            }
        }



    }
}
