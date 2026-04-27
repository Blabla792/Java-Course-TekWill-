package TheifIfelseAndTernaryConstructs.Task5;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        System.out.print("Enter total purchase amount: ");
        Scanner scanner = new Scanner(System.in);
        double input = scanner.nextDouble();
        double discount = (input > 100) ? (input - (input * 0.1)) : input;

        System.out.println("Final price: " + discount);
    }
}
