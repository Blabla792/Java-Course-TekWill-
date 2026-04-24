import java.util.Scanner;

public class TempConvClass {

    private double temp;

    public String convTempCalcs() {

        Scanner input = new Scanner(System.in);

        System.out.print("Enter a temperature in Celsius: ");
        this.temp = input.nextDouble();

        double convertedTemp = this.temp * 1.8 + 32;

        System.out.println("-".repeat(50));

        return String.format("Temperature in Fahrenheit: %.2f", convertedTemp);
    }
}
