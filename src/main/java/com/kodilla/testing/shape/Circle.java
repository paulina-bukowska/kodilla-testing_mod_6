package com.kodilla.testing.shape;

public class Circle implements Shape {
    Double radius;
    final Double PI = 3.14;

    public Circle(Double radius) {
        this.radius = radius;
    }

    @Override
    public String getShapeName() {
        return "circle";
    }

    @Override
    public Double getField() {
        return PI*(radius*radius);
    }
}
