package homework5.task4;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        System.out.println("Enter temperature: ");
        Scanner scanner = new Scanner(System.in);
        double temperature = scanner.nextFloat();

        double maxTemp = 100;
        double minTemp = 0;

        if (temperature > maxTemp) {
            System.out.println("Porridge is too hot.");
        } else if (temperature < minTemp) {
            System.out.println("Porridge is too cold.");
        } else {
            System.out.println("Porridge is just right.");
        }

        scanner.close();
    }
}
