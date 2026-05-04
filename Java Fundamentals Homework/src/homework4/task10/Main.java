package homework4.task10;

import utils.InputHelper;

public class Main {

    public static void main(String[] args) {

        String password = InputHelper.getString("Define a password: ");

        if (password.length() < 6) {
            System.out.println("Weak password");
        } else if (password.length() <= 12) {
            System.out.println("Moderate password");
        } else {
            System.out.println("Strong password");
        }
    }
}
