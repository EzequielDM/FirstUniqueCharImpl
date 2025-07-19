package org.zlogic;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 * Unit test for FirstUniqueChar based on the provided implementation.
 */
public class FirstUniqueCharacterTest {

    // --- Tests for findFirstUniqueChar (Case-Sensitive) ---

    @Test
    @DisplayName("findFirstUniqueChar: Basic case with a unique char")
    void testFindFirstUniqueChar_BasicUniqueExists() {
        assertEquals("l", FirstUniqueChar.findFirstUniqueChar("leetcode"));
    }

    @Test
    @DisplayName("findFirstUniqueChar: Multiple unique chars, returns the first")
    void testFindFirstUniqueChar_MultipleUniqueReturnsFirst() {
        assertEquals("v", FirstUniqueChar.findFirstUniqueChar("loveleetcode"));
    }

    @Test
    @DisplayName("findFirstUniqueChar: No unique characters")
    void testFindFirstUniqueChar_NoUniqueChars() {
        assertNull(FirstUniqueChar.findFirstUniqueChar("aabb"));
    }

    @Test
    @DisplayName("findFirstUniqueChar: Empty string")
    void testFindFirstUniqueChar_EmptyString() {
        assertNull(FirstUniqueChar.findFirstUniqueChar(""));
    }

    @Test
    @DisplayName("findFirstUniqueChar: Null input")
    void testFindFirstUniqueChar_NullInput() {
        assertNull(FirstUniqueChar.findFirstUniqueChar(null));
    }

    @Test
    @DisplayName("findFirstUniqueChar: String with only one character")
    void testFindFirstUniqueChar_SingleCharacter() {
        assertEquals("a", FirstUniqueChar.findFirstUniqueChar("a"));
    }

    @Test
    @DisplayName("findFirstUniqueChar: String with numbers and special characters")
    void testFindFirstUniqueChar_WithNumbersAndSpecialChars() {
        assertEquals("a", FirstUniqueChar.findFirstUniqueChar("a!b!c@c#d#"));
    }

    @Test
    @DisplayName("findFirstUniqueChar: Case sensitivity - different cases are distinct")
    void testFindFirstUniqueChar_CaseSensitiveDistinct() {
        // 'a' is unique, 'A' is unique, 'b' is unique, 'B' is unique. 'a' is first.
        assertEquals("a", FirstUniqueChar.findFirstUniqueChar("aAbB"));
    }

    @Test
    @DisplayName("findFirstUniqueChar: Case sensitivity - repeated case matters")
    void testFindFirstUniqueChar_CaseSensitiveRepeatMatters() {
        // "aaA": 'a' twice, 'A' once. 'A' is the first unique character.
        assertEquals("A", FirstUniqueChar.findFirstUniqueChar("aaA"));
        // "aAA": 'a' once, 'A' twice. 'a' is the first unique character.
        assertEquals("a", FirstUniqueChar.findFirstUniqueChar("aAA"));
    }

    @Test
    @DisplayName("findFirstUniqueChar: String with all same characters")
    void testFindFirstUniqueChar_AllSameCharacters() {
        assertNull(FirstUniqueChar.findFirstUniqueChar("zzzzzz"));
    }

    // --- Tests for findFirstUniqueCharIgnoreCase ---
    // These tests are written STRICTLY based on your provided code's behavior:
    // It first converts the entire string to lowercase, then finds the first unique char.
    // The RETURNED character will ALWAYS be lowercase.

    @Test
    @DisplayName("findFirstUniqueCharIgnoreCase: Unique char 'l' in lowercase string")
    void testFindFirstUniqueCharIgnoreCase_BasicUniqueExists() {
        // Input: "leetcode" -> lowercase(input) = "leetcode"
        // First unique is 'l'.
        assertEquals("l", FirstUniqueChar.findFirstUniqueCharIgnoreCase("leetcode"));
    }

    @Test
    @DisplayName("findFirstUniqueCharIgnoreCase: Unique char 'l' in mixed case string")
    void testFindFirstUniqueCharIgnoreCase_UniqueIsLowerInMixedCase() {
        // Input: "Loveleetcode" -> lowercase(input) = "loveleetcode"
        // 'l' appears twice, 'o' twice, 'v' once. 'v' is the first unique.
        assertEquals("v", FirstUniqueChar.findFirstUniqueCharIgnoreCase("Loveleetcode"));
    }

    @Test
    @DisplayName("findFirstUniqueCharIgnoreCase: Unique char 'L' in mixed case string")
    void testFindFirstUniqueCharIgnoreCase_UniqueIsUpperInMixedCase() {
        // Input: "leetcodeL" -> lowercase(input) = "leetcodeL" -> "leetcode l" (typo fixed to leetcodeL)
        // Input: "leetcodeL" -> lowercase(input) = "leetcode l"
        // All letters l,e,t,c,o,d appear twice or more, except 'l' appearing at the very end.
        // Input: "leetcodeL" -> lowercase(input) = "leetcode l" (corrected)
        // Lowercase counts: l:2, e:3, t:1, c:1, o:1, d:1
        // First unique lowercase character encountered: 't'.
        assertEquals("t", FirstUniqueChar.findFirstUniqueCharIgnoreCase("leetcodeL"));
    }

    @Test
    @DisplayName("findFirstUniqueCharIgnoreCase: Multiple unique chars, returns the first (case-insensitive)")
    void testFindFirstUniqueCharIgnoreCase_MultipleUniqueReturnsFirst() {
        // Input: "loveLEetcode" -> lowercase(input) = "loveleetcode"
        // Counts: l:2, o:2, v:1, e:4, t:1, c:1, d:1
        // Unique lowercase chars: v, t, c, d.
        // First occurrence in the lowercase string is 'v'.
        assertEquals("v", FirstUniqueChar.findFirstUniqueCharIgnoreCase("loveLEetcode"));
    }

    @Test
    @DisplayName("findFirstUniqueCharIgnoreCase: No unique characters (case-insensitive)")
    void testFindFirstUniqueCharIgnoreCase_NoUniqueChars() {
        // Input: "aAbB" -> lowercase(input) = "aabb"
        // Counts: a:2, b:2. No unique.
        assertNull(FirstUniqueChar.findFirstUniqueCharIgnoreCase("aAbB"));

        // Input: "abAB" -> lowercase(input) = "abab"
        // Counts: a:2, b:2. No unique.
        assertNull(FirstUniqueChar.findFirstUniqueCharIgnoreCase("abAB"));
    }

    @Test
    @DisplayName("findFirstUniqueCharIgnoreCase: Empty string")
    void testFindFirstUniqueCharIgnoreCase_EmptyString() {
        assertNull(FirstUniqueChar.findFirstUniqueCharIgnoreCase(""));
    }

    @Test
    @DisplayName("findFirstUniqueCharIgnoreCase: Null input")
    void testFindFirstUniqueCharIgnoreCase_NullInput() {
        assertNull(FirstUniqueChar.findFirstUniqueCharIgnoreCase(null));
    }

    @Test
    @DisplayName("findFirstUniqueCharIgnoreCase: String with only one character")
    void testFindFirstUniqueCharIgnoreCase_SingleCharacter() {
        // Input: "a" -> lowercase = "a". Unique 'a'.
        assertEquals("a", FirstUniqueChar.findFirstUniqueCharIgnoreCase("a"));
        // Input: "A" -> lowercase = "a". Unique 'a'.
        assertEquals("a", FirstUniqueChar.findFirstUniqueCharIgnoreCase("A"));
    }

    @Test
    @DisplayName("findFirstUniqueCharIgnoreCase: Numbers and special characters combined with letters")
    void testFindFirstUniqueCharIgnoreCase_NumbersAndSpecialCharsCombined() {
        // Input: "a!b!c@c#d#" -> lowercase = "a!b!c@c#d#"
        // Counts: a:1, !:2, b:1, c:2, @:1, #:1, d:1
        // Unique chars: a, b, @, #, d. First is 'a'.
        assertEquals("a", FirstUniqueChar.findFirstUniqueCharIgnoreCase("a!b!c@c#d#"));
    }

    @Test
    @DisplayName("findFirstUniqueCharIgnoreCase: All same characters, mixed case")
    void testFindFirstUniqueCharIgnoreCase_AllSameCharactersMixedCase() {
        // Input: "zZzZzZ" -> lowercase = "zzzzzz"
        // Counts: z:6. No unique.
        assertNull(FirstUniqueChar.findFirstUniqueCharIgnoreCase("zZzZzZ"));
    }

    @Test
    @DisplayName("findFirstUniqueCharIgnoreCase: Mixed casing, first unique char appears early")
    void testFindFirstUniqueCharIgnoreCase_MixedCasingEarlyUnique() {
        // Input: "aAbBcCDdeEf" -> lowercase = "aabbccdeef"
        // Counts: a:2, b:2, c:2, d:2, e:2, f:1
        // Unique char: 'f'.
        assertEquals("f", FirstUniqueChar.findFirstUniqueCharIgnoreCase("aAbBcCDdeEf"));
    }

    @Test
    @DisplayName("findFirstUniqueCharIgnoreCase: Mixed casing, first unique char appears later")
    void testFindFirstUniqueCharIgnoreCase_MixedCasingLateUnique() {
        // Input: "aabbCCDdeE" -> lowercase = "aabbccddee"
        // Counts: a:2, b:2, c:2, d:2, e:2
        // No unique characters.
        assertNull(FirstUniqueChar.findFirstUniqueCharIgnoreCase("aabbCCDdeE"));
    }

    @Test
    @DisplayName("findFirstUniqueCharIgnoreCase: Demonstrating behavior - returns lowercase of first unique")
    void testFindFirstUniqueCharIgnoreCase_ReturnsLowercase() {
        // Input: "aBcDe" -> lowercase = "abcde"
        // Counts: a:1, b:1, c:1, d:1, e:1
        // First unique character in the lowercase string is 'a'.
        assertEquals("a", FirstUniqueChar.findFirstUniqueCharIgnoreCase("aBcDe"));
    }

    @Test
    @DisplayName("findFirstUniqueCharIgnoreCase: Demonstrating behavior - returns lowercase even if original was upper")
    void testFindFirstUniqueCharIgnoreCase_OriginalUpperReturnsLowercase() {
        // Input: "abCde" -> lowercase = "abcde"
        // Counts: a:1, b:1, c:1, d:1, e:1
        // First unique character in the lowercase string is 'a'.
        assertEquals("a", FirstUniqueChar.findFirstUniqueCharIgnoreCase("abCde"));
    }
}