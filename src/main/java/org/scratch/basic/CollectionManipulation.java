package org.scratch.basic;

import org.scratch.basic.util.Tuple;

import java.util.Arrays;
import java.util.stream.IntStream;

/**
 * Common collection (also java.util.Map) manipulations
 */
public class CollectionManipulation {

    /**
     * Simple bubble sort with comparable objects. Sorts in-place.
     * Time complexity O(n^2) for average, O(n) for best case
     * @param objects to sort
     * @param <T> any Comparable type
     */
    public <T extends Comparable<T>> void bubbleSort(T[] objects) {
        for (int i = 0; i < objects.length - 1; ++i) {
            for (int j = 0; j < objects.length - i - 1; ++j) {
                if (objects[j].compareTo(objects[j + 1]) > 0) {
                    T temp = objects[j + 1];
                    objects[j + 1] = objects[j];
                    objects[j] = temp;
                }
            }
        }
    }

    /**
     * In-place insertion sort
     * Time complexity O(n^2) for average, O(n) for best case
     * @param objects to sort
     * @param <T> any Comparable type
     */
    public <T extends Comparable<T>> void insertionSort(T[] objects) {
        for (int i = 1; i < objects.length; ++i) {
            T key = objects[i];
            int prevIndex = i - 1;

            while (prevIndex >= 0 && objects[prevIndex].compareTo(key) > 0) {
                objects[prevIndex + 1] = objects[prevIndex];
                --prevIndex;
            }

            objects[prevIndex + 1] = key;
        }
    }

    /**
     * Finding min and max from array with one loop
     * @param objects to find
     * @param <T> any Comparable type
     * @return org.scratch.basic.util.Tuple of min and max
     */
    public <T extends Comparable<T>> Tuple<T, T> minMax(T[] objects) {
        T min = objects[0];
        T max = objects[0];

        for (int i = 1; i < objects.length; ++i) {
            if (objects[i].compareTo(max) > 0) {
                max = objects[i];
            } else if(objects[i].compareTo(min) < 0) {
                min = objects[i];
            }
        }

        return new Tuple<>(min, max);
    }

    /**
     * Try to find index of element from array, otherwise -1
     * @param numbers for searching
     * @param elem for finding
     * @return found index
     */
    public int findIndexOfElement(final int[] numbers, final int elem) {
        return IntStream.range(0, numbers.length)
                .filter(i -> elem == numbers[i])
                .findFirst()
                .orElse(-1);
    }
}
