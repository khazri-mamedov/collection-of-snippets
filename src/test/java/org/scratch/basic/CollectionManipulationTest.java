package org.scratch.basic;

import org.junit.jupiter.api.Test;
import org.scratch.basic.util.Tuple;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertSame;

public class CollectionManipulationTest {
    private final CollectionManipulation collectionManipulation = new CollectionManipulation();

    @Test
    public void bubbleSort_SortingObjects_ArraySorted() {
        String[] objects = new String[] {"B", "A", "E", "C"};

        collectionManipulation.bubbleSort(objects);

        assertEquals(String.join("", objects), "ABCE");
    }

    @Test
    public void insertionSort_SortingObjects_ArraySorted() {
        String[] objects = new String[] {"F", "A", "E", "C"};

        collectionManipulation.insertionSort(objects);

        assertEquals(String.join("", objects), "ACEF");
    }

    @Test
    public void minMax_MinMaxFound_True() {
        String[] objects = new String[] {"F", "A", "E", "C"};

        final Tuple<String, String> minMax = collectionManipulation.minMax(objects);

        assertEquals(minMax.getFirst(), "A");
        assertEquals(minMax.getSecond(), "F");
    }

    @Test
    public void findIndexOfElement_IndexFound_Equals() {
        final int[] numbers = new int[] {1, 2, 3, 4};

        assertSame(collectionManipulation.findIndexOfElement(numbers, 4), 3);
    }

    @Test
    public void findIndexOfElement_IndexNotFound_EqualsNegative() {
        final int[] numbers = new int[] {1, 2, 3, 4};

        assertSame(collectionManipulation.findIndexOfElement(numbers, 5), -1);
    }
}
