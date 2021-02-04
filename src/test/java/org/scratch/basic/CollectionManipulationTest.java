package org.scratch.basic;

import org.junit.jupiter.api.Test;
import org.scratch.basic.util.Tuple;

import java.util.Collection;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertIterableEquals;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class CollectionManipulationTest {
    private final CollectionManipulation collectionManipulation = new CollectionManipulation();

    @Test
    public void bubbleSort_SortingObjects_ArraySorted() {
        String[] objects = {"B", "A", "E", "C"};

        collectionManipulation.bubbleSort(objects);

        assertEquals(String.join("", objects), "ABCE");
    }

    @Test
    public void insertionSort_SortingObjects_ArraySorted() {
        String[] objects = {"F", "A", "E", "C"};

        collectionManipulation.insertionSort(objects);

        assertEquals(String.join("", objects), "ACEF");
    }

    @Test
    public void minMax_MinMaxFound_True() {
        String[] objects = {"C", "A", "E", "F"};

        final Tuple<String, String> minMax = collectionManipulation.minMax(objects);

        assertEquals(minMax.getFirst(), "A");
        assertEquals(minMax.getSecond(), "F");
    }

    @Test
    public void findIndexOfElement_IndexFound_Equals() {
        final int[] numbers = {1, 2, 3, 4};

        assertSame(collectionManipulation.findIndexOfElement(numbers, 4), 3);
    }

    @Test
    public void findIndexOfElement_IndexNotFound_EqualsNegative() {
        final int[] numbers = {1, 2, 3, 4};

        assertSame(collectionManipulation.findIndexOfElement(numbers, 5), -1);
    }

    @Test
    public void findAvg_AvgFound_EqualsExpectedAvg() {
        final int[] numbers = {2, 2, 5};

        assertEquals(collectionManipulation.findAvg(numbers), 3.0);
    }

    @Test
    public void findAvg_EmptyArray_ThrowsException() {
        assertThrows(NoSuchElementException.class, () -> collectionManipulation.findAvg(new int[] {}));
    }

    @Test
    public void reverseArray_Reverse_EqualsExpectedReverse() {
        String[] letters = {"A", "B", "C", "D"};
        collectionManipulation.reverseArray(letters);

        assertArrayEquals(letters, new String[] {"D", "C", "B", "A"});
    }

    @Test
    public void reverseCollectionStream_Reverse_EqualsExpectedReverse() {
        final Collection<String> letters = Set.of("A", "B", "C", "D");

        assertIterableEquals(collectionManipulation.reverseCollectionStream(letters),
                List.of("D", "C", "B", "A"));
    }

    @Test
    public void binarySearch_FindIndex_CorrectlyFound() {
        final List<String> sortedLetters = List.of("A", "B", "C", "D", "Q");

        assertSame(collectionManipulation.binarySearch(sortedLetters, "A"), 0);
    }

    @Test
    public void binarySearch_FindIndex_CorrectlyNotFound() {
        final List<String> sortedLetters = List.of("A", "B", "C", "D", "Q");

        assertSame(collectionManipulation.binarySearch(sortedLetters, "W"), -1);
    }
}