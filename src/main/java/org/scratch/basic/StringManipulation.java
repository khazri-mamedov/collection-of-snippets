package org.scratch.basic;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.Map;
import java.util.Set;
import java.util.StringJoiner;
import java.util.function.Consumer;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

/**
 * Common string manipulations
 */
public class StringManipulation {
    /**
     * Counting duplicate characters old-fashion way. UTF-32 isn't supported (low, high surrogates)
     * @param value for finding duplicates in
     * @return Map of Characters with count
     */
    public Map<Character, Long> duplicateCharsIterate(final String value) {
        Map<Character, Long> result = new HashMap<>();
        
        for (var ch : value.toCharArray()) {
            result.merge(ch, 1L, Long::sum);
        }
        
        return result;
    }
    
    /**
     * Counting duplicate characters with Stream API. UTF-32 isn't supported (low, high surrogates)
     * @param value for finding duplicates
     * @return Map of Characters with count
     */
    public Map<Character, Long> duplicateCharsStream(final String value) {
        return value.chars()
                .mapToObj(intChar -> (char) intChar)
                .collect(Collectors.groupingBy(ch -> ch, Collectors.counting()));
    }
    
    /**
     * First non repeated character from input value.
     * @param value for finding non repeated char
     * @return non repeated char
     * @throws IllegalArgumentException in case of all repeated characters
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
        for (var word : words) {
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
        for(var ch : value.toCharArray()) {
            if(!Character.isDigit(ch)) {
                return false;
            }
        }
        
        return true;
    }
    
    /**
     * Checking all characters are digits with Stream API.
     * allMatch will be slower than reverting anyMatch
     */
    public boolean isAllDigitsStream(final String value) {
        return !value.chars()
                .anyMatch(i -> !Character.isDigit(i));
    }
    
    /**
     * Count vowels in a string (case-insensitive)
     */
    public long countVowels(final String value) {
        long vowelsCount = 0L;
        final Set<Character> vowels = Set.of('a', 'e', 'i', 'o', 'u');
        
        for (var ch : value.toLowerCase().toCharArray()) {
            if (vowels.contains(ch)) {
                ++vowelsCount;
            }
        }
        
        return vowelsCount;
    }
    
    /**
     * Count vowels in a string with Stream API (case-insensitive)
     */
    public long countVowelsStream(final String value) {
        final Set<Character> vowels = Set.of('a', 'e', 'i', 'o', 'u');
        return value.toLowerCase().chars().filter(i -> vowels.contains((char) i)).count();
    }
    
    /**
     * Count occurrences of character in a word ignoring case
     */
    public int occurrencesOfChar(final String word, final char ch) {
        String replacedValue = word.toLowerCase().replace(String.valueOf(ch), "");
        return word.length() - replacedValue.length();
    }
    
    /**
     * Count occurrences of character in a word with single loop ignoring case
     */
    public int occurrencesOfCharLoop(final String word, final char ch) {
        int count = 0;
        
        for (var wordChar : word.toLowerCase().toCharArray()) {
            if (wordChar == ch) {
                ++count;
            }
        }
        return count;
    }
    
    /**
     * Remove whitespaces with regexp
     */
    public String removeWhiteSpaces(final String value) {
        return value.replaceAll("\\s", "");
    }
    
    /**
     * Join words by delimiter using StringJoiner from Java 8
     */
    public String joinByDelimiter(char delimiter, String... words) {
        StringJoiner joiner = new StringJoiner(String.valueOf(delimiter));
        
        for (var word : words) {
            joiner.add(word);
        }
        
        return joiner.toString();
    }
    
    /**
     * Join words by delimiter using Stream API
     */
    public String joinByDelimiterStream(char delimiter, String... words) {
        return Arrays.stream(words).collect(Collectors.joining(String.valueOf(delimiter)));
    }
    
    /**
     * Checking for palindrome (simple solution)
     */
    public boolean isPalindrome(final String word) {
        return word.equals(new StringBuilder(word).reverse().toString());
    }
    
    /**
     * Checking for palindrome with single loop
     */
    public boolean isPalindromeLoop(final String word) {
        int wordLength = word.length();
        
        for (int i = 0; i < wordLength / 2; ++i) {
            if (word.charAt(i) != word.charAt(wordLength - i - 1)) {
                return false;
            }
        }
        
        return true;
    }
    
    /**
     * Removing duplicates from a String with Stream API
     */
    public String removeDuplicatesStream(final String value) {
        return Arrays.stream(value.split(""))
                .distinct()
                .collect(Collectors.joining());
    }
    
    /**
     * Removing duplicates from a String
     */
    public String removeDuplicatesLoop(final String value) {
        Set<String> distinct = new LinkedHashSet<>();
        
        for (var ch : value.toCharArray()) {
            distinct.add(String.valueOf(ch));
        }
        return String.join("", distinct);
    }
    
    /**
     * Remove occurrence of character in a String with single loop
     */
    public String removeCharacter(final String value, char toRemove) {
        StringBuilder result = new StringBuilder();
        
        for (var ch : value.toCharArray()) {
            if (ch != toRemove) {
                result.append(ch);
            }
        }
        return result.toString();
    }
    
    /**
     * Remove occurrence of character in a String with Stream API
     */
    public String removeCharacterStream(final String value, char toRemove) {
        return value.chars()
                .filter(character -> character != toRemove)
                .mapToObj(i -> String.valueOf((char) i))
                .collect(Collectors.joining());
    }
    
    /**
     * Find max occurring char in a String using 2 loops
     */
    public char mostFoundChar(final String value) {
        Map<Character, Integer> occurrences = new HashMap<>();
        
        for (var ch : value.toCharArray()) {
            occurrences.merge(ch, 1, Integer::sum);
        }
        
        int maxCount = Collections.max(occurrences.values());
        
        for (Map.Entry<Character, Integer> entry : occurrences.entrySet()) {
            if (entry.getValue() == maxCount) {
                return entry.getKey();
            }
        }
        
        return Character.MIN_VALUE;
    }
    
    /**
     * Find max occurring char in a String using Stream API
     */
    public char mostFoundCharStream(final String value) {
        return value.chars()
                .mapToObj(ch -> String.valueOf((char) ch))
                .collect(Collectors.groupingBy(ch -> ch, Collectors.counting()))
                .entrySet()
                .stream()
                .max(Map.Entry.comparingByValue())
                .map(stringLongEntry -> stringLongEntry.getKey().charAt(0))
                .orElse(Character.MIN_VALUE);
    }
    
    /**
     * Sort strings by length
     */
    public void sortStringsByLength(String... strings) {
        Arrays.sort(strings, Comparator.comparingInt(String::length));
    }
    
    /**
     * Occurrence of substring in a string. Example: "abbba" has only one bb occurrence
     */
    public int substringOccurrence(final String value, final String substring) {
        int position = 0;
        int substringLength = substring.length();
        int occurrence = 0;
        
        while((position = value.indexOf(substring, position)) != -1) {
            position += substringLength;
            ++occurrence;
        }
        
        return occurrence;
    }
    
    /**
     * Is string anagrams or not. Anagrams - same characters possibly in different order
     */
    public boolean isAnagrams(final String firstValue, final String secondValue) {
        char[] firstChars = firstValue.replaceAll("\\s", "").toLowerCase().toCharArray();
        char[] secondChars = secondValue.replaceAll("\\s", "").toLowerCase().toCharArray();
        
        Arrays.sort(firstChars);
        Arrays.sort(secondChars);
        
        return Arrays.equals(firstChars, secondChars);
    }
    
    /**
     * Multiline strings before official support in Java 13
     */
    public String multilineStrings(String... values) {
        StringJoiner stringJoiner = new StringJoiner(System.lineSeparator());
        for (var value : values) {
            stringJoiner.add(value);
        }
        
        return stringJoiner.toString();
    }
    
    /**
     * Process multiline string
     */
    public void processMultilineString(final String multilineString, final Consumer<String> consumer) {
        multilineString.lines().forEach(consumer);
    }
    
    /**
     * Is string consists of only substrings
     */
    public boolean consistsOfOnlySubstrings(final String value) {
        StringBuilder substring = new StringBuilder();
        
        for (int i = 0; i < value.length() / 2; ++i) {
            substring.append(value.charAt(i));
            String result = value.replaceAll(substring.toString(), "");
            if (result.length() == 0) {
                return true;
            }
        }
        return false;
    }
    
    /**
     * Longest prefix from strings
     */
    public String longestPrefix(String... values) {
        if (values.length == 1) {
            return values[0];
        }
        
        for (int i = 0; i < values[0].length(); ++i) {
            char firstValueChar = values[0].charAt(i);
            for (int j = 1; j < values.length; ++j) {
                if (i >= values[j].length() || values[j].charAt(i) != firstValueChar) {
                    return values[0].substring(0, i);
                }
            }
        }
        
        return values[0];
    }
}
