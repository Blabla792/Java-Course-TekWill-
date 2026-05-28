package homework4.task3;

import utils.InputHelper;

public class Main {

    public static void main(String[] args) {

        double number = InputHelper.getDouble("Enter number: ");

        if (number == 0) {
            System.out.println("zero");
        } else if (Math.abs(number) < 1) {
            System.out.println("small");
        } else if (number > 1000000) {
            System.out.println("large");
        } else if (number < 0) {
            System.out.println("negative");
        } else if (number > 0) {
            System.out.println("positive");
        }
    }
}
