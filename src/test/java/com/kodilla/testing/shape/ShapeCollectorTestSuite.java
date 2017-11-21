package com.kodilla.testing.shape;

import org.junit.*;
import java.util.*;
import com.kodilla.testing.shape.ShapeCollector;
import com.kodilla.testing.shape.Circle;
import com.kodilla.testing.shape.Square;
import com.kodilla.testing.shape.Triangle;

public class ShapeCollectorTestSuite {
    private static int testCounter = 0;

    @BeforeClass
    public static void beforeAllTests() {
        System.out.println("This is the beginning of tests.");
    }

    @AfterClass
    public static void afterAllTests() {
        System.out.println("All tests are finished.");
    }

    @Before
    public void beforeEveryTest() {
        testCounter++;
        System.out.println("Preparing to execute test #" + testCounter);
    }

    @Test
    public void testAddFigureTriangle() {
        //Given
        ShapeCollector shapeCollector = new ShapeCollector();
        Shape triangle = new Triangle(12.4, 5.1);
        //When
        shapeCollector.addFigure(triangle);
        //Then
        Assert.assertEquals(1, shapeCollector.getShapeQuantity());
    }

    @Test
    public void testAddFigureCircle() {
        //Given
        ShapeCollector shapeCollector = new ShapeCollector();
        Shape circle = new Circle(22.4);
        //When
        shapeCollector.addFigure(circle);
        //Then
        Assert.assertEquals(1, shapeCollector.getShapeQuantity());
    }

    @Test
    public void testAddFigureSquare() {
        //Given
        ShapeCollector shapeCollector = new ShapeCollector();
        Shape square = new Square(10.0);
        //When
        shapeCollector.addFigure(square);
        //Then
        Assert.assertEquals(1, shapeCollector.getShapeQuantity());
    }

    @Test
    public void testRemoveFigure() {
        //Given
        ShapeCollector shapeCollector = new ShapeCollector();
        Shape square = new Square(78.5);
        shapeCollector.addFigure(square);
        //When
        boolean result = shapeCollector.removeFigure(square);
        //Then
        Assert.assertTrue(result);
        Assert.assertEquals(0, shapeCollector.getShapeQuantity());
    }

    @Test
    public void testGetFigure() {
        //Given
        ShapeCollector shapeCollector = new ShapeCollector();
        Shape triangle = new Triangle(12.1, 78.5);
        shapeCollector.addFigure(triangle);
        //When
        Shape retrievedShape;
        retrievedShape = shapeCollector.getFigure(0);
        //Then
        Assert.assertEquals(triangle, retrievedShape);
    }

    @Test
    public void testGetShapeNameTriangle() {
        //Given
        Shape triangle = new Triangle(12.1, 78.5);
        //When
        String whatShapeName = triangle.getShapeName();
        //Then
        Assert.assertEquals("triangle", whatShapeName);
    }

    @Test
    public void testGetShapeNameCircle() {
        //Given
        Shape circle = new Circle(5.18);
        //When
        String whatShapeName = circle.getShapeName();
        //Then
        Assert.assertEquals("circle", whatShapeName);
    }

    @Test
    public void testGetShapeNameSquare() {
        //Given
        Shape square = new Square(25.45);
        //When
        String whatShapeName = square.getShapeName();
        //Then
        Assert.assertEquals("square", whatShapeName);
    }

    @Test
    public void testGetFieldTriangle() {
        //Given
        Shape triangle = new Triangle(25.0, 24.6);
        //When
        Double whatShapeArea = triangle.getField();
        //Then
        Assert.assertEquals((Double)307.5, whatShapeArea);
    }

    @Test
    public void testGetFieldCircle() {
        //Given
        Shape circle = new Circle(16.0);
        //When
        Double whatShapeArea = circle.getField();
        //Then
        Assert.assertEquals((Double)803.84, whatShapeArea);
    }

    @Test
    public void testGetFieldSquare() {
        //Given
        Shape square = new Square(49.0);
        //When
        Double whatShapeArea = square.getField();
        //Then
        Assert.assertEquals((Double)2401.0, whatShapeArea);
    }
}
