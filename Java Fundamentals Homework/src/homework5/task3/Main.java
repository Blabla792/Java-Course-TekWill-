package homework5.task3;

import utils.InputHelper;

public class Main {

    public static void main(String[] args) {

        int month = InputHelper.getInt("Enter month number: ", true);

        switch (month) {
            case 12, 1, 2 -> System.out.println("It's Winter");
            case 3, 4, 5 -> System.out.println("It's Spring");
            case 6, 7, 8 -> System.out.println("It's Summer");
            case 9, 10, 11 -> System.out.println("It's Fall");
        }
    }
}
