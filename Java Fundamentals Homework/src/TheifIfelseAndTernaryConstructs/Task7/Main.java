package TheifIfelseAndTernaryConstructs.Task7;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        System.out.print("Enter an year: ");
        Scanner input = new Scanner(System.in);
        int year = input.nextInt();

        if (year % 4 == 0 && year % 100 != 0 || year % 400 == 0) {
            System.out.println("Leap year");
        } else  {
            System.out.println("Not a leap year");
        }
    }
}
