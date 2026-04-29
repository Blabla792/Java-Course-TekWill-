package homework3.part2;

import java.util.Scanner;

public class ProfileGenerator {

    public String miniProfile() {

        Scanner input = new Scanner(System.in);

        System.out.print("Enter your name: ");
        String name = input.nextLine();

        System.out.print("Enter your age: ");
        int age = Integer.parseInt(input.nextLine());

        System.out.print("Enter your favorite program language: ");
        String programLanguage = input.nextLine();

        System.out.println("-".repeat(50));

        return String.format("%s is %d years old and loves %s!", name, age, programLanguage);
    }
}
