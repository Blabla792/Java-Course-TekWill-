package TheifIfelseAndTernaryConstructs.Task10;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        System.out.print("Define a password: ");
        Scanner input = new Scanner(System.in);
        String password = input.nextLine();

        if (password.length() < 6) {
            System.out.println("Weak password");
        } else if (password.length() <= 12) {
            System.out.println("Moderate password");
        }  else {
            System.out.println("Strong password");
        }
    }
}
