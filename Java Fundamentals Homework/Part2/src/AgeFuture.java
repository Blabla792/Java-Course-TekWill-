import java.util.Scanner;

public class AgeFuture {

    private int currentAge;
    private int futureYear;


    public String futureAge() {

        Scanner input = new Scanner(System.in);

        System.out.println("Enter your age: ");
        this.currentAge = Integer.parseInt(input.nextLine());

        System.out.println("Enter number of years: ");
        this.futureYear = Integer.parseInt(input.nextLine());

        int futureAge = this.currentAge + this.futureYear;

        System.out.println("-".repeat(50));

        return String.format("In %d years you will be %d years old", this.futureYear, futureAge);
    }
}
