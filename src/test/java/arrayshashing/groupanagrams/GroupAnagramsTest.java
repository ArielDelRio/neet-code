package arrayshashing.groupanagrams;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import org.junit.jupiter.api.Test;

class GroupAnagramsTest {

    private final GroupAnagrams solution = new GroupAnagrams();

    @Test
    void example1() {
        List<List<String>> result = solution.groupAnagrams(new String[]{"act", "pots", "tops", "cat", "stop", "hat"});
        assertEquals(3, result.size());
        assertTrue(result.stream().anyMatch(group -> group.size() == 1 && group.contains("hat")));
        assertTrue(result.stream().anyMatch(group -> group.size() == 2 && group.contains("act") && group.contains("cat")));
        assertTrue(result.stream().anyMatch(group -> group.size() == 3 && group.contains("stop") && group.contains("pots") && group.contains("tops")));
    }

    @Test
    void example2() {
        List<List<String>> result = solution.groupAnagrams(new String[]{"x"});
        assertEquals(1, result.size());
        assertEquals(1, result.get(0).size());
        assertTrue(result.get(0).contains("x"));
    }

    @Test
    void example3() {
        List<List<String>> result = solution.groupAnagrams(new String[]{""});
        assertEquals(1, result.size());
        assertEquals(1, result.get(0).size());
        assertTrue(result.get(0).contains(""));
    }

    @Test
    void noAnagrams() {
        List<List<String>> result = solution.groupAnagrams(new String[]{"apple", "banana", "cherry"});
        assertEquals(3, result.size());
        assertTrue(result.stream().allMatch(group -> group.size() == 1));
    }

    @Test
    void allAnagrams() {
        List<List<String>> result = solution.groupAnagrams(new String[]{"abc", "cab", "bca"});
        assertEquals(1, result.size());
        assertEquals(3, result.get(0).size());
        assertTrue(result.get(0).containsAll(List.of("abc", "cab", "bca")));
    }

    @Test
    void emptyStringsWithOthers() {
        List<List<String>> result = solution.groupAnagrams(new String[]{"", "a", ""});
        assertEquals(2, result.size());
        assertTrue(result.stream().anyMatch(group -> group.size() == 2 && group.stream().allMatch(String::isEmpty)));
        assertTrue(result.stream().anyMatch(group -> group.size() == 1 && group.contains("a")));
    }
}
