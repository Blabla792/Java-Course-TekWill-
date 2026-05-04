package homework4.task9;

import utils.InputHelper;

public class Main {

    public static void main(String[] args) {

        int age = InputHelper.getInt("Enter your age: ", true);
        // Restricts valid input to "yes" or "no".
        String isStudent = InputHelper.getString("Are your student: ", true);

        if (isStudent.equals("yes") || age < 18) {
            System.out.println("You get a 20% discount");
        } else {
            System.out.println("No discount");
        }
    }
}
