package org.scratch.basic;

import org.junit.jupiter.api.Test;
import org.scratch.basic.object.Bottle;
import org.scratch.basic.util.Pair;

import java.util.Collection;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;

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

        final Pair<String, String> minMax = collectionManipulation.minMax(objects);

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
    
    @Test
    public void isSumOfPairExistOrdered_SumExists_True() {
        final int[] numbers = {1, 3, 4, 8, 9};
        
        assertTrue(collectionManipulation.isSumOfPairExistOrdered(numbers, 4));
    }
    
    @Test
    public void isSumOfPairExistOrdered_NonExistingSum_False() {
        final int[] numbers = {1, 4, 5, 8, 10, 12};
        
        assertFalse(collectionManipulation.isSumOfPairExistOrdered(numbers, 69));
    }
    
    @Test
    public void isSumOfPairExistUnordered_SumExists_True() {
        final int[] numbers = {1, 4, 2, 5, 3, 10, 9};
        
        assertTrue(collectionManipulation.isSumOfPairExistUnordered(numbers, 19));
    }
    
    @Test
    public void isSumOfPairExistUnordered_NonExistingSum_False() {
        final int[] numbers = {1, 4, 2, 5, 3, 10, 9};
    
        assertFalse(collectionManipulation.isSumOfPairExistUnordered(numbers, 99));
    }
    
    @Test
    public void firstRecurringCharacter_CharacterOccurs_EqualsExpected() {
        final String value = "ABCA";
        
        assertSame(collectionManipulation.firstRecurringCharacter(value), 'A');
    }
    
    @Test
    public void firstRecurringCharacter_FoundFirst_EqualsExpected() {
        final String value = "ABACB";
    
        assertSame(collectionManipulation.firstRecurringCharacter(value), 'A');
    }
    
    @Test
    public void sortMapByKeyStream_SortedMap_ExpectedSorted() {
        final Bottle bottle1 = new Bottle(1, "Jenkins");
        final Bottle bottle2 = new Bottle(2, "Docker");
        
        final Map<Bottle, String> bottles = Map.of(bottle1, "Evroopt", bottle2, "Prostore");
    
        Comparator<Bottle> bottleComparator = Comparator.comparing(Bottle::getId);
        
        assertSame(collectionManipulation.sortMapByKeyStream(bottles, bottleComparator)
                        .entrySet().iterator().next().getKey().getId(),
                1);
    }
    
    @Test
    public void mergeMapsStream_MergedMap_CollisionExpectedSecondValue() {
        final Map<Integer, String> firstMap = Map.of(1, "some_value");
        final Map<Integer, String> secondMap = Map.of(1, "some_value2");
        
        assertEquals(collectionManipulation
                .mergeMapsStream(firstMap, secondMap)
                .entrySet().iterator().next().getValue(), "some_value2");
    }
}
