package com.kodilla.testing.collection;
import com.kodilla.testing.collection.OddNumbersExterminator;
import org.junit.*;

import java.lang.reflect.Array;
import java.util.*;

public class CollectionTestSuite {
    @Before
    public void before(){
        System.out.println("Test Case: begin");
    }
    @After
    public void after(){
        System.out.println("Test Case: end\n");
    }
    @Test
    public void testOddNumbersExterminatorEmptyList() {
        //Given
        OddNumbersExterminator oddNumbersExterminator = new OddNumbersExterminator();
        ArrayList<Integer> expectedNumbers = new ArrayList<Integer>();
        //When
        ArrayList<Integer> numbers = new ArrayList<Integer>();
        ArrayList<Integer> evenNumbers = oddNumbersExterminator.exterminate(numbers);
        System.out.println("Testing method exterminate when the list is EMPTY");
        //Then
        Assert.assertEquals(expectedNumbers, evenNumbers);
    }
    @Test
    public void testOddNumbersExterminatorNormalList() {
        //Given
        OddNumbersExterminator oddNumbersExterminator = new OddNumbersExterminator();
        Integer expectedNum[] = new Integer[] {6, 24, 14, 98};
        ArrayList<Integer> expectedNumbers = new ArrayList<Integer>(Arrays.asList(expectedNum));
        //When
        Integer givenNum[] = new Integer[] {13, 6, 24, 77, 17, 14, 98};
        ArrayList<Integer> numbers = new ArrayList<Integer>(Arrays.asList(givenNum));
        ArrayList<Integer> evenNumbers = oddNumbersExterminator.exterminate(numbers);
        System.out.println("Testing method exterminate when the list is NORMAL");
        //Then
        Assert.assertEquals(expectedNumbers, evenNumbers);
    }
}
