package org.example;

public class App {

    public static void main(String[] args) {
        Shape[] shapes = new Shape[]{
                new Circle(2.0),
                new Rectangle(3.0, 4.0),
                new Square(5.0),
                new RightTriangle(3.0, 4.0),
                new IsoscelesRightTriangle(2.0)
        };

        for (int i = 0; i < shapes.length; i++) {
            Shape s = shapes[i];
            System.out.println(
                    s.getClass().getSimpleName()
                            + " area=" + s.getArea()
                            + " perimeter=" + s.getPerimeter()
            );

            if (s instanceof Polygon) {
                Polygon p = (Polygon) s;
                System.out.println("sides=" + p.numberOfSides());
            }
        }
    }
}

abstract class Shape {
    public abstract double getArea();
    public abstract double getPerimeter();
}

interface Polygon {
    int numberOfSides();
}

class Circle extends Shape {
    private final double radius;

    public Circle(double radius) {
        if (radius <= 0) throw new IllegalArgumentException("Radius must be > 0");
        this.radius = radius;
    }

    @Override
    public double getArea() {
        return Math.PI * radius * radius;
    }

    @Override
    public double getPerimeter() {
        return 2 * Math.PI * radius;
    }
}

class Rectangle extends Shape implements Polygon {
    protected final double length;
    protected final double width;

    public Rectangle(double length, double width) {
        if (length <= 0 || width <= 0) throw new IllegalArgumentException("Sides must be > 0");
        this.length = length;
        this.width = width;
    }

    @Override
    public double getArea() {
        return length * width;
    }

    @Override
    public double getPerimeter() {
        return 2 * (length + width);
    }

    @Override
    public int numberOfSides() {
        return 4;
    }
}

class Square extends Rectangle {
    public Square(double side) {
        super(side, side);
    }
}

class RightTriangle extends Shape implements Polygon {
    protected final double leg1;
    protected final double leg2;

    public RightTriangle(double leg1, double leg2) {
        if (leg1 <= 0 || leg2 <= 0) throw new IllegalArgumentException("Legs must be > 0");
        this.leg1 = leg1;
        this.leg2 = leg2;
    }

    @Override
    public double getArea() {
        return 0.5 * leg1 * leg2;
    }

    @Override
    public double getPerimeter() {
        double hyp = Math.sqrt(leg1 * leg1 + leg2 * leg2);
        return leg1 + leg2 + hyp;
    }

    @Override
    public int numberOfSides() {
        return 3;
    }
}

class IsoscelesRightTriangle extends RightTriangle {
    public IsoscelesRightTriangle(double leg) {
        super(leg, leg);
    }
}
