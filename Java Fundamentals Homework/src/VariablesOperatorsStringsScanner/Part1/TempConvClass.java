package VariablesOperatorsStringsScanner.Part1;

import java.util.Scanner;

public class TempConvClass {

    public String convTempCalcs() {

        Scanner input = new Scanner(System.in);

        System.out.print("Enter a temperature in Celsius: ");
        double temp = input.nextDouble();

        double convertedTemp = temp * 1.8 + 32;

        System.out.println("-".repeat(50));

        return String.format("Temperature in Fahrenheit: %.2f", convertedTemp);
    }
}
