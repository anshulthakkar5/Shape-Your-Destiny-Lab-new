package org.example;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class AppTest {

    private static final double EPS = 1e-6;

    @Test
    void circleAreaAndPerimeter() {
        Circle c = new Circle(2.0);
        assertEquals(Math.PI * 4.0, c.getArea(), EPS);
        assertEquals(2.0 * Math.PI * 2.0, c.getPerimeter(), EPS);
    }

    @Test
    void rectangleAreaPerimeterAndSides() {
        Rectangle r = new Rectangle(3.0, 4.0);
        assertEquals(12.0, r.getArea(), EPS);
        assertEquals(14.0, r.getPerimeter(), EPS);
        assertEquals(4, r.numberOfSides());
    }

    @Test
    void rightTriangleAreaPerimeterAndSides() {
        RightTriangle t = new RightTriangle(3.0, 4.0);
        assertEquals(6.0, t.getArea(), EPS);
        assertEquals(12.0, t.getPerimeter(), EPS);
        assertEquals(3, t.numberOfSides());
    }

    @Test
    void squareInheritsRectangle() {
        Square s = new Square(5.0);
        assertEquals(25.0, s.getArea(), EPS);
        assertEquals(20.0, s.getPerimeter(), EPS);
        assertEquals(4, s.numberOfSides());
    }

    @Test
    void isoscelesRightTriangleInheritsRightTriangle() {
        IsoscelesRightTriangle iso = new IsoscelesRightTriangle(2.0);
        assertEquals(2.0, iso.getArea(), EPS);
        assertEquals(4.0 + Math.sqrt(8.0), iso.getPerimeter(), EPS);
        assertEquals(3, iso.numberOfSides());
    }

    @Test
    void invalidCircleThrows() {
        assertThrows(IllegalArgumentException.class, () -> new Circle(0));
    }

    @Test
    void invalidRectangleThrows() {
        assertThrows(IllegalArgumentException.class, () -> new Rectangle(-1, 2));
    }

    @Test
    void invalidTriangleThrows() {
        assertThrows(IllegalArgumentException.class, () -> new RightTriangle(0, 5));
    }
}
