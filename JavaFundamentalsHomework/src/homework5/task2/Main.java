package homework5.task2;

import utils.InputHelper;

public class Main {

    public static void main(String[] args) {

        int age = InputHelper.getInt("Enter your age: ", true);
        // Restricts valid input to "yes" or "no".
        String maritalStatus = InputHelper.getString("Enter your marital status: ",
                true);

        String result = (age < 18) && (maritalStatus.equalsIgnoreCase("no")) ?
                "You are not eligible for discounts" : (age < 18) &&
                                                       (maritalStatus.equalsIgnoreCase("yes")) ?
                "You are eligible for discounts" : (age >= 18) &&
                                                   (maritalStatus.equalsIgnoreCase("no")) ?
                "You are not eligible for discounts" : (age > 18) &&
                                                       (maritalStatus.equalsIgnoreCase("yes")) ?
                "You are eligible for discounts" : "Invalid Data";

        System.out.println(result);
    }
}
