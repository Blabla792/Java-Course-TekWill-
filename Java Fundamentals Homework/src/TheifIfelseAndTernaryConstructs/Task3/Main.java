package TheifIfelseAndTernaryConstructs.Task3;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        System.out.print("Enter number: ");
        Scanner scanner = new Scanner(System.in);
        double number = scanner.nextDouble();

        if (number == 0) {
            System.out.println("zero");
        } else if (Math.abs(number) < 1) {
            System.out.println("small");
        } else if (number > 1000000) {
            System.out.println("large");
        } else if (number < 0) {
            System.out.println("negative");
        } else if (number > 0) {
            System.out.println("positive");
        }
    }
}
