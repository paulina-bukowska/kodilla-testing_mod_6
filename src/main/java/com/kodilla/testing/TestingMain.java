package com.kodilla.testing;
import com.kodilla.testing.collection.OddNumbersExterminator;
import java.util.*;

public class TestingMain {
    public static void main(String[] args) {
        ArrayList<Integer> numbers = new ArrayList<Integer>();
        numbers.add(13);
        numbers.add(6);
        numbers.add(24);
        numbers.add(77);
        numbers.add(17);
        numbers.add(14);
        numbers.add(98);

        OddNumbersExterminator oddNumbersExterminator = new OddNumbersExterminator();
        ArrayList<Integer> evenNumbers = oddNumbersExterminator.exterminate(numbers);
        System.out.println(evenNumbers);
    }
}
