package homework6.task4;

import utils.InputHelper;

public class Main {

    public static void main() {

        String password = "1258t8w9v";
        String userEnteredPassword = InputHelper.getString("Enter your password: ");
        int passwordAttemptCount = 0;

        while (true) {
            if (userEnteredPassword.equals(password)) {
                System.out.println("Authentication successful");
                break;
            } else if (passwordAttemptCount < 2) {
                passwordAttemptCount++;
                System.out.println("Wrong password");
                userEnteredPassword = InputHelper.getString("Enter your password: ");
            } else {
                System.out.println("Access blocked");
                break;
            }
        }
    }
}
