package TheifIfelseAndTernaryConstructs.Task6;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        System.out.print("What is your age? ");
        Scanner sc = new Scanner(System.in);
        int age = sc.nextInt();

        if (age < 12) {
            System.out.println("Ticket price: $5");
        } else if (age <= 60) {
            System.out.println("Ticket price: $10");
        } else {
            System.out.println("Ticket price: $7");
        }
    }
}
