package org.scratch.basic;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

public class StringManipulation {
    /**
     * Counting duplicate characters old-fashion way. UTF-32 isn't supported (low, high surrogates)
     */
    public Map<Character, Long> duplicateCharsIterate(final String value) {
        Map<Character, Long> result = new HashMap<>();
        
        for (char ch : value.toCharArray()) {
            result.merge(ch, 1L, Long::sum);
        }
        
        return result;
    }
    
    /**
     * Counting duplicate characters with Stream API. UTF-32 isn't supported (low, high surrogates)
     */
    public Map<Character, Long> duplicateCharsStream(final String value) {
        return value.chars()
                .mapToObj(intChar -> (char) intChar)
                .collect(Collectors.groupingBy(ch -> ch, Collectors.counting()));
    }
    
    /**
     * First non repeated character from input value.
     * IllegalArgumentException in case of all repeated characters
     */
    public char firstNonRepeated(final String value) {
        LinkedHashMap<Character, Long> result = value.chars()
                .mapToObj(ch -> (char) ch)
                .collect(Collectors.groupingBy(ch -> ch, LinkedHashMap::new, Collectors.counting()));
        
        return result.entrySet().stream()
                .filter(characterLongEntry -> characterLongEntry.getValue() == 1L)
                .findFirst()
                .orElseThrow(IllegalArgumentException::new)
                .getKey();
    }
    
    /**
     * Reverse letters in a word. Splitting sentence by whitespace
     */
    public String reverseLetters(final String sentence) {
        StringBuilder result = new StringBuilder();
        
        final String[] words = sentence.split(" ");
        for (String word : words) {
            StringBuilder reverseWord = new StringBuilder(word).reverse();
            result.append(reverseWord).append(" ");
        }
        
        return result.toString().trim();
    }
    
    /**
     * Reverse letters in a word with Stream API. Splitting sentence by whitespace
     */
    public String reverseLettersStream(final String sentence) {
        Pattern pattern = Pattern.compile(" +");
        return pattern.splitAsStream(sentence)
                .map(s -> new StringBuilder(s).reverse())
                .collect(Collectors.joining(" "));
    }
    
    /**
     * Checking all characters are digits
     */
    public boolean isAllDigits(final String value) {
        for(char ch : value.toCharArray()) {
            if(!Character.isDigit(ch)) {
                return false;
            }
        }
        
        return true;
    }
    
    /**
     * Checking all characters are digits with Stream API. allMatch will be slower than reverting anyMatch
     */
    public boolean isAllDigitsStream(final String value) {
        return !value.chars()
                .anyMatch(i -> !Character.isDigit(i));
    }
}
