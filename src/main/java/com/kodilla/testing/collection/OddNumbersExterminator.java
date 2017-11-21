package com.kodilla.testing.collection;
import java.util.*;

public class OddNumbersExterminator {
    private ArrayList<Integer> evenNumbers= new ArrayList<Integer>();

    public ArrayList<Integer> exterminate(ArrayList<Integer> numbers) {
        for(Integer num : numbers) {
            if(num%2 == 0) {
                evenNumbers.add(num);
            }
        }
        return evenNumbers;
    }
}

