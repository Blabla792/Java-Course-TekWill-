package homework9.task2;

import utils.InputHelper;

public class Main {

    public static void main(String[] args) {

        Geometry geometry = new Geometry();

        String input = InputHelper.getString("Enter shape and dimensions" +
                "(e.g., 'square 5' or 'circle 10'): ");

        try {
            double area = geometry.callShapeMethod(input);
            System.out.printf("Calculated Area: %.2f%n", area);
        } catch (IllegalArgumentException e) {
            System.err.println("Error: " + e.getMessage());
        }
    }
}
