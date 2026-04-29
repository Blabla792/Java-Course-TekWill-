package homework4.task2;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        System.out.print("Enter width of rectangle 1: ");
        Scanner sc = new Scanner(System.in);
        double width1 = sc.nextDouble();
        System.out.print("Enter height of rectangle 1: ");
        double height1 = sc.nextDouble();

        System.out.print("Enter width of rectangle 2: ");
        double width2 = sc.nextDouble();
        System.out.print("Enter height of rectangle 2: ");
        double height2 = sc.nextDouble();

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
