package twopointers.validpalindrome;

public class ValidPalindrome {
    /**
     * Returns true if the given string is a palindrome, false otherwise.
     *
     * @param s the input string
     * @return true if s is a palindrome, false otherwise
     */

    public boolean isPalindrome(String s) {
        int left = 0;
        int right = s.length() - 1;

        while (left < right) {
            char charAtLeft = Character.toLowerCase(s.charAt(left));
            char charAtRight = Character.toLowerCase(s.charAt(right));
            boolean isCharAtLeftValid = Character.isLetterOrDigit(charAtLeft);
            boolean isCharAtRightValid = Character.isLetterOrDigit(charAtRight);

            if (!isCharAtLeftValid) {
                left++;
            }
            if (!isCharAtRightValid) {
                right--;
            }

            if (isCharAtLeftValid && isCharAtRightValid) {
                if (charAtLeft == charAtRight) {
                    left++;
                    right--;
                } else {
                    return false;
                }
            }
        }

        return true;
    }
}
