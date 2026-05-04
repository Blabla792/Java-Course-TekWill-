package homework6.task2;

import utils.InputHelper;

public class Main {

    public static void main(String[] args) {

        int positiveNumbers = InputHelper.getInt("Please enter the positive numbers: ",
                true);

        int result = 0;
        while (positiveNumbers > 0) {
            result += positiveNumbers % 10;
            positiveNumbers /= 10;
        }

        System.out.println("result = " + result);
    }
}
