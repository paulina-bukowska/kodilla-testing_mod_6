package com.kodilla.testing.shape;

public class Triangle implements Shape {
    Double base;
    Double height;

    public Triangle(Double base, Double height) {
        this.base = base;
        this.height = height;
    }

    @Override
    public String getShapeName() {
        return "triangle";
    }

    @Override
    public Double getField() {
        return (base*height)/2;
    }
}
