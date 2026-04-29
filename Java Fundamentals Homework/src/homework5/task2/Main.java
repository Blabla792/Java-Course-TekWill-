package homework5.task2;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        System.out.println("Enter your age: ");
        Scanner scanner = new Scanner(System.in);
        int age = Integer.parseInt(scanner.nextLine());

        System.out.println("Enter your marital status: ");
        String maritalStatus = scanner.nextLine().toLowerCase();

        String result = (age < 18) && (maritalStatus.equals("no")) ?
                "You are not eligible for discounts" : (age < 18) &&
                                                       (maritalStatus.equals("yes")) ?
                "You are eligible for discounts" : (age >= 18) &&
                                                   (maritalStatus.equals("no")) ?
                "You are not eligible for discounts" : (age > 18) &&
                                                       (maritalStatus.equals("yes")) ?
                "You are eligible for discounts" : "Invalid Data";

        System.out.println(result);

        scanner.close();
    }
}
