package homework3.part1;

import utils.InputHelper;

public class UserClass {

    public String getUserInfo() {

        String name = InputHelper.getString("Enter name: ");
        // Call the advanced getInt method for checking if the value is greater than 0.
        int age = InputHelper.getInt("Enter age: ",  true);
        String city = InputHelper.getString("Enter city: ");

        System.out.println("-".repeat(50));

        return String.format("""
                Hello %s!
                You are %d years old.
                You live in %s.""", name, age, city);
    }
}
