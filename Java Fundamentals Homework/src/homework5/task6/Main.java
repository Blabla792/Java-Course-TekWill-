package homework5.task6;

import utils.InputHelper;

public class Main {

    public static void main(String[] args) {

        calculateAndPrintConversion();
    }

    public static void calculateAndPrintConversion () {

        boolean flag = false;
        while (!flag) {

            String currencyCode = InputHelper.getString("Provide currency code (EUR, GBP, INR, AUD): ");

            switch (currencyCode) {
                case "EUR", "GBP", "INT", "AUD" -> {

                    double usdValue = InputHelper.getDouble("Enter USD value: ", true);

                    System.out.printf("Enter %s conversion rate: ", currencyCode);
                    double conversionRate = InputHelper.getDouble("", true);

                    double result = usdValue * conversionRate;

                    System.out.printf("Converted value from USD to %s is: %.2f %s\n", currencyCode, result,
                            currencyCode);
                    flag = true;
                }
                default -> System.out.println("Unsupported currency.");
            }
        }
    }
}
