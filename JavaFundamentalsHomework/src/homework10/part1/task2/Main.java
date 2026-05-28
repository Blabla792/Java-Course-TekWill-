package homework10.part1.task2;

public class Main {

    public static void main(String[] args) {

        Circle circle = new Circle(25.5);
        circle.printShape();

        System.out.println("-".repeat(60));

        Rectangle rectangle = new Rectangle(25.3, 4.2);
        rectangle.printShape();

        System.out.println("-".repeat(60));

        Triangle triangle = new Triangle();
        triangle.printShape();
    }
}
