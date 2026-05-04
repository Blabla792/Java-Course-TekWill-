package homework4.task5;

import utils.InputHelper;

public class Main {

    public static void main(String[] args) {

        double input = InputHelper.getDouble("Enter total purchase amount: ",
                true);
        double discount = (input > 100) ? (input - (input * 0.1)) : input;

        System.out.println("Final price: " + discount);
    }
}
