package homework3.part2;

import utils.InputHelper;

public class AgeFuture {

    public String futureAge() {

        // Call the advanced getInt method for checking if the value is greater than 0.
        int currentAge = InputHelper.getInt("Please enter your age: ",
                true);
        int futureYear = InputHelper.getInt("Enter number of years: ",
                true);
        int yearsToAdd = currentAge + futureYear;

        System.out.println("-".repeat(50));

        return String.format("In %d years you will be %d years old", futureYear, yearsToAdd);
    }
}
