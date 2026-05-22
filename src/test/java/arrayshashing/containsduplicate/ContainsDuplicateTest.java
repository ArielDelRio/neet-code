package arrayshashing.containsduplicate;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class ContainsDuplicateTest {

    private final ContainsDuplicate solution = new ContainsDuplicate();

    @Test
    void withDuplicate() {
        assertTrue(solution.hasDuplicate(new int[]{1, 2, 3, 3}));
    }

    @Test
    void withoutDuplicate() {
        assertFalse(solution.hasDuplicate(new int[]{1, 2, 3, 4}));
    }

    @Test
    void emptyArray() {
        assertFalse(solution.hasDuplicate(new int[]{}));
    }

    @Test
    void singleElement() {
        assertFalse(solution.hasDuplicate(new int[]{42}));
    }

    @Test
    void allSame() {
        assertTrue(solution.hasDuplicate(new int[]{5, 5, 5, 5}));
    }
}
