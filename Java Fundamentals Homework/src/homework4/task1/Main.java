package homework4.task1;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        System.out.print("Enter number: ");
        Scanner sc = new Scanner(System.in);
        int inputNumber = Integer.parseInt(sc.nextLine());

        if (inputNumber % 2 == 0) {
            System.out.printf("The number %d is even", inputNumber);
        }  else {
            System.out.printf("The number %d is odd", inputNumber);
        }
    }
}
