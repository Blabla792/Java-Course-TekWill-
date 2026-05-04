package homework5.task4;

import utils.InputHelper;

public class Main {

    public static void main(String[] args) {

        System.out.println("Enter temperature: ");
        double temperature = InputHelper.getDouble("Enter temperature: ");

        double maxTemp = 100;
        double minTemp = 0;

        if (temperature > maxTemp) {
            System.out.println("Porridge is too hot.");
        } else if (temperature < minTemp) {
            System.out.println("Porridge is too cold.");
        } else {
            System.out.println("Porridge is just right.");
        }
    }
}
