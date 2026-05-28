package homework10.part1.task2;

public class Rectangle extends Shape {
    private final double width;
    private final double height;

    public Rectangle(double width, double height) {
        this.width = width;
        this.height = height;
    }

    @Override
    double calculateArea() {
        return width * height;
    }

    @Override
    void printShape() {
        System.out.printf("""
                Width of rectangle is: %.2f
                Height of rectangle is: %.2f
                Area of rectangle is: %.2f
                """, width, height, calculateArea());
    }
}
