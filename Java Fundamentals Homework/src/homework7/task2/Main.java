package homework7.task2;

import utils.InputHelper;

public class Main {

    public static void main(String[] args) {

        int[] inputArray = InputHelper.getIntArray("Enter a list of integers, " +
                "separated by commas: ", ",", true);

        int counterEven = 0;
        int counterOdd = 0;

        for (int value : inputArray) {
            if (value % 2 == 0) counterEven++;
            else counterOdd++;
        }

        System.out.printf("""
    Number of even numbers: %d
    Number of odd numbers: %d""", counterEven, counterOdd);
    }
}
