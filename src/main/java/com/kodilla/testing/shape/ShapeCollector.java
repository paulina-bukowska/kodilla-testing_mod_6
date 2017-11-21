package com.kodilla.testing.shape;
import java.util.*;

public class ShapeCollector {
    private ArrayList<Shape> shapes = new ArrayList<Shape>();

    // dodaje figurę do kolekcji
    public void addFigure(Shape shape) {
        shapes.add(shape);
    }

    // usuwa figurę z kolekcji
    public boolean removeFigure(Shape shape) {
        boolean result = false;
        if(shapes.contains(shape)) {
            shapes.remove(shape);
            result = true;
        }
        return result;
    }

    // pobiera z kolekcji figurę z pozycji n listy
    public Shape getFigure(int n) {
        return shapes.get(n);
    }

    // wyświetla zawartość kolekcji
    public void showFigures() {
        for(Shape shape : shapes) {
            System.out.println(shape);
        }
    }

    //zwraca ilość figur w kolekcji
    public int getShapeQuantity(){
        return shapes.size();
    }
}
