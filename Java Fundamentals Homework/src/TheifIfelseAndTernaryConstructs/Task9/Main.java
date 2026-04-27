package TheifIfelseAndTernaryConstructs.Task9;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        System.out.print("Enter your age: ");
        Scanner scanner = new Scanner(System.in);
        int age = Integer.parseInt(scanner.nextLine());
        System.out.print("Are you student: ");
        String isStudent = scanner.nextLine().toLowerCase();

        if (isStudent.equals("yes") || age < 18) {
            System.out.println("You get a 20% discount");
        } else {
            System.out.println("No discount");
        }
    }
}
