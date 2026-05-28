package homework10.part1.task2;

import utils.InputHelper;

public class Triangle extends Shape {
    private double a;
    private double b;
    private double c;
    private double h;
    private double angle;
    private int methodUsed;

    public Triangle() {
        this.methodUsed = chooseAreaFormula();
        setupDimensions();
    }

    private int chooseAreaFormula() {
        return InputHelper.getInt("""
                ==========================================
                TRIANGLE AREA CALCULATOR
                ==========================================
                1. Base and Height
                2. Three Sides (Heron's Formula)
                3. Two Sides and an Included Angle
                ------------------------------------------
                Please select an option:\s""");
    }

    private void setupDimensions() {
        switch (methodUsed) {
            case 1 -> {
                System.out.println("""
                                   / \\
                                  /   \\
                                 /     \\  <-- Vertex
                                /   |   \\
                               /    |h   \\
                              /     |     \\
                             /______|______\\
                             \\______b______/
                                    ^
                              (Perpendicular\s
                               intersection)
                        """);
                b = InputHelper.getDouble("Enter value for b: ");
                h = InputHelper.getDouble("Enter value for h: ");
            }
            case 2 -> {
                System.out.println("""
                                      / \\
                                     /   \\
                                  a /     \\ c
                                   /       \\
                                  /_________\\
                                       b
                        """);
                a = InputHelper.getDouble("Enter value for a: ");
                b = InputHelper.getDouble("Enter value for b: ");
                c = InputHelper.getDouble("Enter value for c: ");
            }
            case 3 -> {
                System.out.println("""
                                      / \\
                                     /   \\
                                  a /     \\
                                   /  θ    \\
                                  /_________\\
                                       b
                                       ^
                              (Angle θ is\s
                              trapped between
                               sides a and b)
                        """);
                a = InputHelper.getDouble("Enter value for a: ");
                b = InputHelper.getDouble("Enter value for b: ");
                angle = InputHelper.getDouble("Enter value for angle: ");
            }
        }
    }

    @Override
    double calculateArea() {
        return switch (methodUsed) {
            case 1 -> (b * h) / 2;
            case 2 -> {
                double s = (a + b + c) / 2;
                yield Math.sqrt(s * (s - a) * (s - b) * (s - c));
            }
            case 3 -> ((a * b) * Math.sin(Math.toRadians(angle))) / 2;
            default -> 0.0;
        };
    }

    @Override
    void printShape() {
        System.out.printf("Triangle Method Used: %d%n", methodUsed);
        switch (methodUsed) {
            case 1 -> System.out.printf("""
                    Base: %.2f
                    Height: %.2f
                    """, b, h);
            case 2 -> System.out.printf("""
                   Sides: %.2f, %.2f, %.2f
            """, a, b, c);
            case 3 -> System.out.printf("""
                        Sides: %.2f, %.2f
                        Angle: %.2f
                        """, a, b, angle);
        }
        System.out.printf("Area of the triangle: %.2f%n", calculateArea());
    }
}
