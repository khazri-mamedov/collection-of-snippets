package org.scratch.basic;

import org.junit.jupiter.api.Test;

import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;


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
    public void testFirstNonRepeatedFail() {
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
}
