package com.stackroute.optional;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.Map;
import java.util.Optional;

import static java.util.Map.entry;
import static org.junit.jupiter.api.Assertions.*;

/* Complete the class as per the requirements given in PROBLEM.md */
public class FruitUtilTests {
    private FruitUtil fruitUtil;

    @BeforeEach
    public void setup() {
        fruitUtil = new FruitUtil();
    }

    @Test
    public void searchFruitsTestWhenPresent() {
        List<String> fruits = List.of("Apple", "Orange", "Banana", "Grapes", "Watermelon");
        boolean isPresent = fruitUtil.searchFruit(fruits, "Banana");
        assertTrue(isPresent);
    }

    @Test
    public void searchFruitsTestWhenNotPresent() {
        List<String> fruits = List.of("Apple", "Orange", "Banana", "Grapes", "Watermelon");
        boolean isPresent = fruitUtil.searchFruit(fruits, "MuskMelon");
        assertFalse(isPresent);
    }

    @Test
    public void checkIfListIsEmpty() {
        List<String> fruits = List.of();
        boolean isPresent = fruitUtil.searchFruit(fruits, "MuskMelon");
        assertFalse(isPresent);
    }

    @Test
    public void checkIfListIsNull() {
        List<String> fruits = null;
        boolean isPresent = fruitUtil.searchFruit(fruits, "MuskMelon");
        assertFalse(isPresent);
    }

    @Test
    public void checkIfFruitStringIsNull() {
        List<String> fruits = List.of("Apple", "Orange", "Banana", "Grapes", "Watermelon");
        boolean isPresent = fruitUtil.searchFruit(fruits, null);
        assertFalse(isPresent);
    }

    @Test
    public void checkIfFruitStringIsEmpty() {
        List<String> fruits = List.of("Apple", "Orange", "Banana", "Grapes", "Watermelon");
        boolean isPresent = fruitUtil.searchFruit(fruits, "");
        assertFalse(isPresent);
    }

    @Test
    public void getFruitByTasteTest() throws FruitNotFoundException {
        Map<String, String> fruits = Map.ofEntries(
                entry("Sweet", "Blueberry"),
                entry("Sour", "Orange"),
                entry("Salty", "Apple")
        );
        String searchTaste = "Sour";
        String fruitIs = fruitUtil.getFruitByTaste(fruits, searchTaste);
        assertEquals("Orange", fruitIs);
    }

    @Test
    public void checkIfTasteNotPresent() throws FruitNotFoundException {
        Map<String, String> fruits = Map.ofEntries(
                entry("Sweet", "Blueberry"),
                entry("Sour", "Orange"),
                entry("Salty", "Apple")
        );
        String searchTaste = null;
        String fruitIs = fruitUtil.getFruitByTaste(fruits, searchTaste);
        assertNull(fruitIs);
    }

    @Test
    public void checkIfMapIsNull() throws FruitNotFoundException {
        Map<String, String> fruits = null;
        String searchTaste = "Sweet";
        String fruitIs = fruitUtil.getFruitByTaste(fruits, searchTaste);
        assertNull(fruitIs);
    }
}