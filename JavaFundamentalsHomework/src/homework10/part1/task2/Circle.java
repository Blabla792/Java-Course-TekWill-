package homework10.part1.task2;

public class Circle extends Shape {
    private final double radius;

    public Circle(double radius) {
        this.radius = radius;
    }

    @Override
    double calculateArea() {
        return 2 * Math.PI * Math.pow(radius, 2);
    }

    @Override
    void printShape() {
        System.out.printf("""
                Radius of the circle is: %.2f
                The area of the circle is: %.2f
                """, radius, calculateArea());
    }
}
