package homework4.task6;

import utils.InputHelper;

public class Main {

    public static void main(String[] args) {

        int age = InputHelper.getInt("Enter your age: ", true);

        if (age < 12) {
            System.out.println("Ticket price: $5");
        } else if (age <= 60) {
            System.out.println("Ticket price: $10");
        } else {
            System.out.println("Ticket price: $7");
        }
    }
}
