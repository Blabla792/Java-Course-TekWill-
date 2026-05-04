package homework3.part1;

import utils.InputHelper;

public class TempConvClass {

    private static final double CELSIUS_TO_FAHRENHEIT_MULTIPLIER = 1.8;
    private static final int CELSIUS_TO_FAHRENHEIT_OFFSET = 32;

    public String convertCelsiusToFahrenheit() {

        double temp = InputHelper.getDouble("Enter a temperature in Celsius: ");
        double convertedTemp = temp * CELSIUS_TO_FAHRENHEIT_MULTIPLIER +
                CELSIUS_TO_FAHRENHEIT_OFFSET;

        System.out.println("-".repeat(50));

        return String.format("Temperature in Fahrenheit: %.2f", convertedTemp);
    }
}
