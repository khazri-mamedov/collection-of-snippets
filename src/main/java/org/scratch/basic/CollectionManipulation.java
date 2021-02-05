package org.scratch.basic;

import org.scratch.basic.util.Tuple;

import java.util.Collection;
import java.util.Comparator;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;
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

    /**
     * Finding average of numbers
     * @param numbers to compute avg
     * @return computed average
     */
    public double findAvg(final int[] numbers) {
        return IntStream.of(numbers).average().orElseThrow();
    }

    /**
     * In-place array reversing
     * @param numbers for reversing
     * @param <T> any type
     */
    public <T> void reverseArray(T[] numbers) {
        for (int head = 0, tail = numbers.length - 1; head < tail; ++head, --tail) {
            T temp = numbers[head];
            numbers[head] = numbers[tail];
            numbers[tail] = temp;
        }
    }

    /**
     * Reverse collection using Stream API
     * @param collection for reversing
     * @param <T> any Comparable type
     * @return reversed List
     */
    public <T extends Comparable<T>> List<T> reverseCollectionStream(final Collection<T> collection) {
        return collection.stream()
                .sorted(Comparator.reverseOrder())
                .collect(Collectors.toList());
    }

    /**
     * Find index of element in collection with binary search
     * @param sortedObjects for traversing
     * @param toFind element to find
     * @param <T> any Comparable type
     * @return found index, otherwise -1
     */
    public <T extends Comparable<T>> int binarySearch(final List<T> sortedObjects, T toFind) {
        int high = sortedObjects.size() - 1;
        int low = 0;

        while (low <= high) {
            int middle = (low + high) / 2;
            if (sortedObjects.get(middle).compareTo(toFind) < 0) {
                low = middle + 1;
            } else if(sortedObjects.get(middle).compareTo(toFind) > 0) {
                high = middle - 1;
            } else if (sortedObjects.get(middle).compareTo(toFind) == 0) {
                return middle;
            }
        }
        return -1;
    }
    
    /**
     * Finding if pair with sum exists. O(n) time complexity, O(1) space complexity
     * @param numbers for finding sum (assuming ordered)
     * @param sum for finding in numbers
     * @return true if sum exists, otherwise false
     */
    public boolean isSumOfPairExistOrdered(final int[] numbers, final int sum) {
        int head = 0;
        int tail = numbers.length - 1;
        
        while (head < tail) {
            int calculatedSum = numbers[head] + numbers[tail];
            if (sum > calculatedSum) {
                ++head;
            } else if (sum < calculatedSum) {
                --tail;
            } else {
                return true;
            }
        }
        
        return false;
    }
    
    /**
     * Finding if pair with sum exists. O(n) time complexity, O(n) space complexity
     * @param numbers for finding sum
     * @param sum sum for finding in numbers
     * @return true if sum exists, otherwise false
     */
    public boolean isSumOfPairExistUnordered(final int[] numbers, final int sum) {
        Set<Integer> seenBefore = new HashSet<>();
        
        for (var num : numbers) {
            int calculatedDiff = sum - num;
            if (seenBefore.contains(calculatedDiff)) {
                return true;
            }
            seenBefore.add(num);
        }
        
        return false;
    }
    
    /**
     * Find first recurring character. O(n) time complexity, O(n) space complexity
     * @param value for finding character
     * @return found character, otherwise Character.MIN_VALUE
     */
    public char firstRecurringCharacter(final String value) {
        Set<Character> seenCharacters = new HashSet<>();
        
        for (var character : value.toCharArray()) {
            if (seenCharacters.contains(character)) {
                return character;
            }
            seenCharacters.add(character);
        }
        
        return Character.MIN_VALUE;
    }
}
