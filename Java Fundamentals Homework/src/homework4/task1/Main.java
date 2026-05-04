package homework4.task1;

import utils.InputHelper;

public class Main {

    public static void main(String[] args) {

        int inputNumber = InputHelper.getInt("Enter a number: ", true);

        if (inputNumber % 2 == 0) {
            System.out.printf("The number %d is even", inputNumber);
        } else {
            System.out.printf("The number %d is odd", inputNumber);
        }
    }
}
