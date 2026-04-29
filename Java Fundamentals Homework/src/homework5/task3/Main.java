package homework5.task3;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        System.out.println("Enter month number: ");
        Scanner scanner = new Scanner(System.in);
        int month = scanner.nextInt();

        switch (month) {
            case 12, 1, 2 -> System.out.println("It's Winter");
            case 3, 4, 5 -> System.out.println("It's Spring");
            case 6, 7, 8 -> System.out.println("It's Summer");
            case 9, 10, 11 -> System.out.println("It's Fall");
        }

        scanner.close();
    }
}
