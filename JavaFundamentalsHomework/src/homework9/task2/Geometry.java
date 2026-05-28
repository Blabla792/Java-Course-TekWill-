package homework9.task2;

public class Geometry {

    private double squareShape(double length) {
        return length * length;
    }

    private double rectangleShape(double length, double width) {
        return length * width;
    }

    private double circleShape(double radius) {
        return Math.PI * Math.pow(radius, 2);
    }

    public double callShapeMethod(String input) {
        String[] parts = input.trim().split("\\s+");

        if (parts.length != 2) {
            throw new IllegalArgumentException("Invalid format. Use: shapeName value(s)");
        }

        switch (parts[0].toLowerCase()) {
            case "square" -> {
                return squareShape(Double.parseDouble(parts[1]));
            }
            case "rectangle" -> {
                if (parts.length != 3) {
                    throw new IllegalArgumentException("Rectangle requires length and width.");
                }
                return rectangleShape(Double.parseDouble(parts[1]), Double.parseDouble(parts[2]));
            }
            case "circle" -> {
                return circleShape(Double.parseDouble(parts[1]));
            }
            default -> throw new IllegalArgumentException("Unknown shape: \"" + parts[0] + "\"");
        }
    }
}
