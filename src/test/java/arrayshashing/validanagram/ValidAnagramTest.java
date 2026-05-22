package arrayshashing.validanagram;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class ValidAnagramTest {

    private final ValidAnagram solution = new ValidAnagram();

    @Test
    void isAnagram() {
        assertTrue(solution.isAnagram("racecar", "carrace"));
    }

    @Test
    void notAnagram() {
        assertFalse(solution.isAnagram("jar", "jam"));
    }

    @Test
    void differentLengths() {
        assertFalse(solution.isAnagram("ab", "abc"));
    }
}
