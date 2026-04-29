package homework3.part2;

import java.util.Scanner;

public class AgeFuture {

    public String futureAge() {

        Scanner input = new Scanner(System.in);

        System.out.println("Enter your age: ");
        int currentAge = Integer.parseInt(input.nextLine());

        System.out.println("Enter number of years: ");
        int futureYear = Integer.parseInt(input.nextLine());

        int futureAge = currentAge + futureYear;

        System.out.println("-".repeat(50));

        return String.format("In %d years you will be %d years old", futureYear, futureAge);
    }
}
