package homework4.task4;

import utils.InputHelper;

public class Main {

    public static void main(String[] args) {

        double temp = InputHelper.getDouble("Enter temperature: ");

        if (temp < 10) {
            System.out.println("Wear a jacket!");
        } else if (temp <= 25) {
            System.out.println("It's a nice day!");
        } else {
            System.out.println("It's very hot, stay hydrated!");
        }
    }
}
