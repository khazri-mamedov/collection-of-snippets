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

/**
 * Naming convention for tests: unitOfWork_StateUnderTest_ExpectedValue
 */
public class StringManipulationTest {
    private final StringManipulation stringManipulation = new StringManipulation();
    
    @Test
    public void duplicateCharsIterate_FoundDuplicatesCount_Equals2() {
        final String testValue = "abba";
        Map<Character, Long> result = stringManipulation.duplicateCharsIterate(testValue);
        
        assertSame(result.get('a'), 2L);
        assertSame(result.get('b'), 2L);
    }
    
    @Test
    public void duplicateCharsStream_FoundDuplicatesCount_Equals2() {
        final String testValue = "abba";
        Map<Character, Long> result = stringManipulation.duplicateCharsStream(testValue);
        
        assertSame(result.get('a'), 2L);
        assertSame(result.get('b'), 2L);
    }
    
    @Test
    public void firstNonRepeated_FoundNonRepeated_Equals() {
        final String testValue = "accb";
        char result = stringManipulation.firstNonRepeated(testValue);
        
        assertSame(result, 'a');
    }
    
    @Test
    public void firstNonRepeatedFail_NotFound_ExceptionThrown() {
        final String testValue = "ccc";
        assertThrows(IllegalArgumentException.class, () -> stringManipulation.firstNonRepeated(testValue));
    }
    
    @Test
    public void reverseLetters_Reversed_EqualsReversedString() {
        final String sentence = "Are you this?";
        String result = stringManipulation.reverseLetters(sentence);
        
        assertEquals(result, "erA uoy ?siht");
    }
    
    @Test
    public void reverseLettersStream_Reversed_EqualsReversedString() {
        final String sentence = "Are you this?";
        String result = stringManipulation.reverseLettersStream(sentence);
        
        assertEquals(result, "erA uoy ?siht");
    }
    
    @Test
    public void isAllDigits_AllDigits_True() {
        final String testValue = "1122";
        boolean result = stringManipulation.isAllDigits(testValue);
        
        assertTrue(result);
    }
    
    @Test
    public void isAllDigits_ContainsCharacter_False() {
        final String testValue = "1122a";
        boolean result = stringManipulation.isAllDigits(testValue);
        
        assertFalse(result);
    }
    
    @Test
    public void isAllDigitsStream_AllDigits_True() {
        final String testValue = "1122";
        boolean result = stringManipulation.isAllDigitsStream(testValue);
        
        assertTrue(result);
    }
    
    @Test
    public void isAllDigitsStream_ContainsCharacter_False() {
        final String testValue = "1122a";
        boolean result = stringManipulation.isAllDigitsStream(testValue);
        
        assertFalse(result);
    }
    
    @Test
    public void countVowels_AllVowels_EqualsInputLength() {
        final String testValue = "Aaa";
        long result = stringManipulation.countVowels(testValue);
        
        assertSame(result, (long) testValue.length());
    }
    
    @Test
    public void countVowels_NoneVowels_Equals0() {
        final String testValue = "sssss";
        long result = stringManipulation.countVowels(testValue);
        
        assertSame(result, 0L);
    }
    
    @Test
    public void countVowelsStream_AllVowels_EqualsInputLength() {
        final String testValue = "Aaa";
        long result = stringManipulation.countVowelsStream(testValue);
        
        assertSame(result, (long) testValue.length());
    }
    
    @Test
    public void occurrencesOfChar_Occurred_EqualsOccurrenceCount() {
        final String word = "Some simple sentence";
        
        assertSame(stringManipulation.occurrencesOfChar(word, 's'), 3);
    }
    
    @Test
    public void occurrencesOfCharLoop_Occurred_EqualsOccurrenceCount() {
        final String word = "Some simple sentence";
        
        assertSame(stringManipulation.occurrencesOfCharLoop(word, 's'), 3);
    }
    
    @Test
    public void removeWhiteSpaces_Removed_EqualsRemovedValue() {
        final String testValue = " H e l l o ";
        
        assertEquals(stringManipulation.removeWhiteSpaces(testValue), "Hello");
    }
    
    @Test
    public void joinByDelimiter_Joined_EqualsToJoinedValue() {
        assertEquals(stringManipulation.joinByDelimiter(
                '/', "aa", "bb"), "aa/bb");
    }
    
    @Test
    public void joinByDelimiterStream_Joined_EqualsToJoinedValue() {
        assertEquals(stringManipulation.joinByDelimiterStream(
                '/', "aa", "bb"), "aa/bb");
    }
    
    @Test
    public void isPalindrome_PalindromeWord_True() {
        final String word = "abba";
        
        assertTrue(stringManipulation.isPalindrome(word));
    }
    
    @Test
    public void isPalindromeLoop_PalindromeWord_True() {
        final String word = "abba";
        
        assertTrue(stringManipulation.isPalindromeLoop(word));
    }
    
    @Test
    public void isPalindromeLoop_NotPalindromeWord_False() {
        final String word = "abbc";
        
        assertFalse(stringManipulation.isPalindromeLoop(word));
    }
    
    @Test
    public void removeDuplicatesStream_DuplicatesRemoved_EqualsDuplicateRemoved() {
        final String word = "abba";
    
        assertEquals(stringManipulation.removeDuplicatesStream(word), "ab");
    }
    
    @Test
    public void removeDuplicatesLoop_DuplicatesRemoved_EqualsDuplicateRemoved() {
        final String word = "abba";
        
        assertEquals(stringManipulation.removeDuplicatesLoop(word), "ab");
    }
    
    @Test
    public void removeCharacter_CharacterRemoved_EqualsWithRemoved() {
        final String word = "abba";
        
        assertEquals(stringManipulation.removeCharacter(word, 'a'), "bb");
    }
    
    @Test
    public void removeCharacterStream_CharacterRemoved_EqualsWithRemoved() {
        final String word = "abba";
    
        assertEquals(stringManipulation.removeCharacterStream(word, 'a'), "bb");
    }
    
    @Test
    public void mostFoundChar_FoundMostUsedChar_EqualsFoundChar() {
        final String word = "cccaacccb";
        
        assertSame(stringManipulation.mostFoundChar(word), 'c');
    }
    
    @Test
    public void mostFoundCharStream_FoundMostUsedChar_EqualsFoundChar() {
        final String word = "cccaacccb";
        
        assertSame(stringManipulation.mostFoundCharStream(word), 'c');
    }
    
    @Test
    public void sortStringsByLength_Sorted_EqualsSorted() {
        String[] strings = new String[] { "ccc", "a", "bb", "dddd" };
        stringManipulation.sortStringsByLength(strings);
        
        assertLinesMatch(Arrays.asList(strings), List.of("a", "bb", "ccc", "dddd"));
    }
    
    @Test
    public void substringOccurrence_Occurred_Once() {
        final String testValue = "abbba";
        final String substring = "bb";
        
        assertSame(stringManipulation.substringOccurrence(testValue, substring), 1);
    }
    
    @Test
    public void ssAnagrams_ValuesAreAnagrams_True() {
        final String firstValue = "Hello world";
        final String secondValue = "lloehldrow";
        
        assertTrue(stringManipulation.isAnagrams(firstValue, secondValue));
    }
    
    @Test
    public void multilineStrings_StringWithCarriageReturn_EqualsWithCarriage() {
        assertEquals(stringManipulation.multilineStrings("Hello", "World"), "Hello\nWorld");
    }
    
    @Test
    public void consistsOfOnlySubstrings_OnlySubstrings_True() {
        final String testValue = "hellohellohello";
        
        assertTrue(stringManipulation.consistsOfOnlySubstrings(testValue));
    }
    
    @Test
    public void consistsOfOnlySubstrings_OnlySubstrings_False() {
        final String testValue = "helloworld";
        
        assertFalse(stringManipulation.consistsOfOnlySubstrings(testValue));
    }
    
    @Test
    public void longestPrefix_FoundLongest_EqualsLongestPrefix() {
        assertEquals(stringManipulation.longestPrefix("ab", "abc", "abd", "abb"), "ab");
    }
    
    @Test
    public void longestPrefix_NoneLongest_EqualsEmpty() {
        assertEquals(stringManipulation.longestPrefix("ab", "ac", "cd", "aa"), "");
    }
    
    @Test
    public void longestPrefix_OneValue_EqualsFirstValue() {
        assertEquals(stringManipulation.longestPrefix("ab"), "ab");
    }
}
