package homework4.task7;

import utils.InputHelper;

public class Main {

    public static void main(String[] args) {

        int year = InputHelper.getInt("Enter an year: ", true);

        if (year % 4 == 0 && year % 100 != 0 || year % 400 == 0) {
            System.out.println("Leap year");
        } else {
            System.out.println("Not a leap year");
        }
    }
}
