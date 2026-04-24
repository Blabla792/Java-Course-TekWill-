import java.util.Scanner;

public class UserClass {

    private String name;
    private int age;
    private String city;

    public String input() {

        Scanner input = new Scanner(System.in);

        System.out.println("Enter your name: ");
        this.name = input.nextLine();

        System.out.println("Enter your age: ");
        this.age = Integer.parseInt(input.nextLine());

        System.out.println("Enter your city: ");
        this.city = input.nextLine();

        System.out.println("-".repeat(50));

        return String.format("Hello %s!\n" +
                "You are %d years old.\n" +
                "You live in %s.", this.name, this.age, this.city);
    }
}
