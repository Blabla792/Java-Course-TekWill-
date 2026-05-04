package homework6.task1;

import utils.InputHelper;

public class Main {

    public static void main() {

        int positiveNumber = InputHelper.getInt("Please enter a positive number (greater than 0): ",
                true);
        int reversedNumber = 0;

        while (positiveNumber > 0) {
            int lastDigit = positiveNumber % 10;
            reversedNumber = (reversedNumber * 10) + lastDigit;
            positiveNumber = positiveNumber / 10;
        }

        System.out.println("Reversed number: " + reversedNumber);
    }
}
