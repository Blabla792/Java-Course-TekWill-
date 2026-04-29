package homework4.task4;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        System.out.print("Enter temperature: ");
        Scanner scanner = new Scanner(System.in);
        double temp = scanner.nextDouble();

        if (temp < 10) {
            System.out.println("Wear a jacket!");
        } else if (temp >= 10 && temp <= 25) {
            System.out.println("It's a nice day!");
        } else {
            System.out.println("It's very hot, stay hydrated!");
        }
    }
}
