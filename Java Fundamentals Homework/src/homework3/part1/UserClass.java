package homework3.part1;

import java.util.Scanner;

public class UserClass {

    public String input() {

        Scanner input = new Scanner(System.in);

        System.out.println("Enter your name: ");
        String name = input.nextLine();

        System.out.println("Enter your age: ");
        int age = Integer.parseInt(input.nextLine());

        System.out.println("Enter your city: ");
        String city = input.nextLine();

        System.out.println("-".repeat(50));

        return String.format("""
                Hello %s!
                You are %d years old.
                You live in %s.""", name, age, city);
    }
}
