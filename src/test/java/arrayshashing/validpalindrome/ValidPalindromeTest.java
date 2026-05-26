package arrayshashing.validpalindrome;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ValidPalindromeTest {

    private final ValidPalindrome solution = new ValidPalindrome();

    @Test
    void example1_shouldReturnTrue() {
        assertTrue(solution.isPalindrome("Was it a car or a cat I saw?"));
    }

    @Test
    void example2_shouldReturnFalse() {
        assertFalse(solution.isPalindrome("tab a cat"));
    }

    @Test
    void singleCharacter_shouldReturnTrue() {
        assertTrue(solution.isPalindrome("a"));
        assertTrue(solution.isPalindrome("1"));
    }

    @Test
    void ignoresNonAlphanumericAndCase_shouldReturnTrue() {
        assertTrue(solution.isPalindrome("A man, a plan, a canal: Panama!"));
        assertTrue(solution.isPalindrome("No 'x' in Nixon"));
    }

    @Test
    void notPalindrome_shouldReturnFalse() {
        assertFalse(solution.isPalindrome("hello"));
        assertFalse(solution.isPalindrome("Palindrome"));
    }

    @Test
    void onlyNonAlphanumeric_shouldReturnTrue() {
        assertTrue(solution.isPalindrome(" "));
        assertTrue(solution.isPalindrome(".,;!"));
    }
}
