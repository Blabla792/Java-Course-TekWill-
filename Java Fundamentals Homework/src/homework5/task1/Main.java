package homework5.task1;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        System.out.println("Enter person age: ");
        Scanner scanner = new Scanner(System.in);
        int age = scanner.nextInt();

        String result = (age < 18) ? "Minor" : (age <= 29) ? "Young" :
                                               (age <= 64) ? "Adult" :
                                               (age >= 65) ? "Old" : "Invalid Data";

        System.out.println(result);

        scanner.close();
    }
}
