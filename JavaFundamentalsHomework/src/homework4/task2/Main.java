package homework4.task2;

import utils.InputHelper;

public class Main {

    public static void main(String[] args) {

        double width1 = InputHelper.getDouble("Enter width of rectangle 1: ",
                true);
        double height1 = InputHelper.getDouble("Enter height of rectangle 1: ",
                true);

        double width2 = InputHelper.getDouble("Enter width of rectangle 2: ",
                true);
        double height2 = InputHelper.getDouble("Enter height of rectangle 2: ",
                true);

        double area1 = width1 * height1;
        double area2 = width2 * height2;

        if (area1 > area2) {
            System.out.println("The area of the " +
                    "rectangle 1 is greater than rectangle 2.");
        } else if (area2 > area1) {
            System.out.println("The area of the " +
                    "rectangle 2 is greater than rectangle 1.");
        } else {
            System.out.println("The rectangle 1 and rectangle 2 is the same.");
        }
    }
}
