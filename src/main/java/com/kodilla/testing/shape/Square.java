package com.kodilla.testing.shape;

public class Square implements Shape {
    Double side;

    public Square(Double side) {
        this.side = side;
    }

    @Override
    public String getShapeName() {
        return "square";
    }

    @Override
    public Double getField() {
        return side*side;
    }
}
