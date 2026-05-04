package homework6.task5;

public class Main {

    public static void main(String[] args) {

        final double CELSIUS_TO_FAHRENHEIT_MULTIPLIER = 1.8;
        final int CELSIUS_TO_FAHRENHEIT_OFFSET = 32;

        double temperatureFahrenheit;

        // Prints the table header
        System.out.printf("%-7s | %6s%n", "Celsius", "Fahrenheit");
        System.out.printf("--------------------%n");

        for (double temperatureCelsius = 0; temperatureCelsius <= 100; temperatureCelsius += 10) {
            temperatureFahrenheit = temperatureCelsius * CELSIUS_TO_FAHRENHEIT_MULTIPLIER +
            CELSIUS_TO_FAHRENHEIT_OFFSET;

            // Prints the variables
            System.out.printf("%-7.1f | %10.1f%n", temperatureCelsius, temperatureFahrenheit);
        }
    }
}
