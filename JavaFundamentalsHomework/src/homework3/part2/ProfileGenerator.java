package homework3.part2;

import utils.InputHelper;

public class ProfileGenerator {

    public String miniProfile() {

        String name = InputHelper.getString("Enter name: ");
        int age = InputHelper.getInt("Enter your age: ",
                true);
        String programLanguage = InputHelper.getString("Enter your favorite program language: ");

        System.out.println("-".repeat(50));

        return String.format("%s is %d years old and loves %s!", name, age, programLanguage);
    }
}
