package org.scratch.basic;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertLinesMatch;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;


public class StringManipulationTest {
    private final StringManipulation stringManipulation = new StringManipulation();
    
    @Test
    public void testDuplicateCharsIterateSuccess() {
        final String testValue = "abba";
        Map<Character, Long> result = stringManipulation.duplicateCharsIterate(testValue);
        
        assertSame(result.get('a'), 2L);
        assertSame(result.get('b'), 2L);
    }
    
    @Test
    public void testDuplicateCharsStreamSuccess() {
        final String testValue = "abba";
        Map<Character, Long> result = stringManipulation.duplicateCharsStream(testValue);
        
        assertSame(result.get('a'), 2L);
        assertSame(result.get('b'), 2L);
    }
    
    @Test
    public void testFirstNonRepeatedSuccess() {
        final String testValue = "accb";
        char result = stringManipulation.firstNonRepeated(testValue);
        
        assertSame(result, 'a');
    }
    
    @Test
    public void testFirstNonRepeatedFail_Throws() {
        final String testValue = "ccc";
        assertThrows(IllegalArgumentException.class, () -> stringManipulation.firstNonRepeated(testValue));
    }
    
    @Test
    public void testReverseLettersSuccess() {
        final String sentence = "Are you this?";
        String result = stringManipulation.reverseLetters(sentence);
        
        assertEquals(result, "erA uoy ?siht");
    }
    
    @Test
    public void testReverseLettersStreamSuccess() {
        final String sentence = "Are you this?";
        String result = stringManipulation.reverseLettersStream(sentence);
        
        assertEquals(result, "erA uoy ?siht");
    }
    
    @Test
    public void testIsAllDigitsSuccess() {
        final String testValue = "1122";
        boolean result = stringManipulation.isAllDigits(testValue);
        
        assertTrue(result);
    }
    
    @Test
    public void testIsAllDigitsFail() {
        final String testValue = "1122a";
        boolean result = stringManipulation.isAllDigits(testValue);
        
        assertFalse(result);
    }
    
    @Test
    public void testIsAllDigitsStreamSuccess() {
        final String testValue = "1122";
        boolean result = stringManipulation.isAllDigitsStream(testValue);
        
        assertTrue(result);
    }
    
    @Test
    public void testIsAllDigitsStreamFail() {
        final String testValue = "1122a";
        boolean result = stringManipulation.isAllDigitsStream(testValue);
        
        assertFalse(result);
    }
    
    @Test
    public void testCountVowelsSuccess() {
        final String testValue = "Aaa";
        long result = stringManipulation.countVowels(testValue);
        
        assertSame(result, 3L);
    }
    
    @Test
    public void testCountVowelsSuccess_0() {
        final String testValue = "sssss";
        long result = stringManipulation.countVowels(testValue);
        
        assertSame(result, 0L);
    }
    
    @Test
    public void testCountVowelsStreamSuccess() {
        final String testValue = "Aaa";
        long result = stringManipulation.countVowelsStream(testValue);
        
        assertSame(result, 3L);
    }
    
    @Test
    public void testOccurrencesOfCharSuccess() {
        final String word = "Some simple sentence";
        
        assertSame(stringManipulation.occurrencesOfChar(word, 's'), 3);
    }
    
    @Test
    public void testOccurrencesOfCharLoopSuccess() {
        final String word = "Some simple sentence";
        
        assertSame(stringManipulation.occurrencesOfCharLoop(word, 's'), 3);
    }
    
    @Test
    public void testRemoveWhiteSpacesSuccess() {
        final String testValue = " H e l l o ";
        
        assertEquals(stringManipulation.removeWhiteSpaces(testValue), "Hello");
    }
    
    @Test
    public void testJoinByDelimiterSuccess() {
        assertEquals(stringManipulation.joinByDelimiter(
                '/', "aa", "bb"), "aa/bb");
    }
    
    @Test
    public void testJoinByDelimiterStreamSuccess() {
        assertEquals(stringManipulation.joinByDelimiterStream(
                '/', "aa", "bb"), "aa/bb");
    }
    
    @Test
    public void testIsPalindromeTrue() {
        final String word = "abba";
        
        assertTrue(stringManipulation.isPalindrome(word));
    }
    
    @Test
    public void testIsPalindromeLoopTrue() {
        final String word = "abba";
        
        assertTrue(stringManipulation.isPalindromeLoop(word));
    }
    
    @Test
    public void testIsPalindromeLoopFalse() {
        final String word = "abbc";
        
        assertFalse(stringManipulation.isPalindromeLoop(word));
    }
    
    @Test
    public void testRemoveDuplicatesStreamSuccess() {
        final String word = "abba";
    
        assertEquals(stringManipulation.removeDuplicatesStream(word), "ab");
    }
    
    @Test
    public void testRemoveDuplicatesLoopSuccess() {
        final String word = "abba";
        
        assertEquals(stringManipulation.removeDuplicatesLoop(word), "ab");
    }
    
    @Test
    public void testRemoveCharacterSuccess() {
        final String word = "abba";
        
        assertEquals(stringManipulation.removeCharacter(word, 'a'), "bb");
    }
    
    @Test
    public void testRemoveCharacterStreamSuccess() {
        final String word = "abba";
    
        assertEquals(stringManipulation.removeCharacterStream(word, 'a'), "bb");
    }
    
    @Test
    public void testMostFoundCharSuccess() {
        final String word = "cccaacccb";
        
        assertSame(stringManipulation.mostFoundChar(word), 'c');
    }
    
    @Test
    public void testMostFoundCharStreamSuccess() {
        final String word = "cccaacccb";
        
        assertSame(stringManipulation.mostFoundCharStream(word), 'c');
    }
    
    @Test
    public void testSortStringsByLength() {
        String[] strings = new String[] { "ccc", "a", "bb", "dddd" };
        stringManipulation.sortStringsByLength(strings);
        
        assertLinesMatch(Arrays.asList(strings), List.of("a", "bb", "ccc", "dddd"));
    }
    
    @Test
    public void testSubstringOccurrenceSuccess() {
        final String testValue = "abbba";
        final String substring = "bb";
        
        assertSame(stringManipulation.substringOccurrence(testValue, substring), 1);
    }
    
    @Test
    public void testIsAnagramsTrue() {
        final String firstValue = "Hello world";
        final String secondValue = "lloehldrow";
        
        assertTrue(stringManipulation.isAnagrams(firstValue, secondValue));
    }
    
    @Test
    public void testMultilineStringsSuccess() {
        assertEquals(stringManipulation.multilineStrings("Hello", "World"), "Hello\nWorld");
    }
    
    @Test
    public void testConsistsOfOnlySubstringsTrue() {
        final String testValue = "hellohellohello";
        
        assertTrue(stringManipulation.consistsOfOnlySubstrings(testValue));
    }
    
    @Test
    public void testConsistsOfOnlySubstringsFalse() {
        final String testValue = "helloworld";
        
        assertFalse(stringManipulation.consistsOfOnlySubstrings(testValue));
    }
    
    @Test
    public void testLongestPrefixSuccess() {
        assertEquals(stringManipulation.longestPrefix("ab", "abc", "abd", "abb"), "ab");
    }
    
    @Test
    public void testLongestPrefixNone() {
        assertEquals(stringManipulation.longestPrefix("ab", "ac", "cd", "aa"), "");
    }
    
    @Test
    public void testLongestPrefixAlone() {
        assertEquals(stringManipulation.longestPrefix("ab"), "ab");
    }
}
