import java.util.Scanner;

public class ProfileGenerator {

    private String name;
    private int age;
    private String programLanguage;

    public String miniProfile() {

        Scanner input = new Scanner(System.in);

        System.out.print("Enter your name: ");
        name = input.nextLine();

        System.out.print("Enter your age: ");
        age = Integer.parseInt(input.nextLine());

        System.out.print("Enter your favorite program language: ");
        programLanguage = input.nextLine();

        System.out.println("-".repeat(50));

        return String.format("%s is %d years old and loves %s!", name, age, programLanguage);
    }
}
