package twopointers.threesum;

import org.junit.jupiter.api.Test;

import twopointers.threesum.ThreeSum;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.assertEquals;

class ThreeSumTest {

    private final ThreeSum solution = new ThreeSum();

    private static Set<List<Integer>> normalize(List<List<Integer>> triplets) {
        Set<List<Integer>> normalized = new HashSet<>();
        for (List<Integer> triplet : triplets) {
            List<Integer> t = new ArrayList<>(triplet);
            t.sort(Integer::compareTo);
            normalized.add(List.copyOf(t));
        }
        return normalized;
    }

    @Test
    void example1() {
        List<List<Integer>> result = solution.threeSum(new int[] { -1, 0, 1, 2, -1, -4 });
        Set<List<Integer>> expected = Set.of(
                List.of(-1, -1, 2),
                List.of(-1, 0, 1));
        assertEquals(expected, normalize(result));
    }

    @Test
    void example2() {
        List<List<Integer>> result = solution.threeSum(new int[] { 0, 1, 1 });
        assertEquals(Set.of(), normalize(result));
    }

    @Test
    void example3() {
        List<List<Integer>> result = solution.threeSum(new int[] { 0, 0, 0 });
        assertEquals(Set.of(List.of(0, 0, 0)), normalize(result));
    }

    @Test
    void allNegatives() {
        List<List<Integer>> result = solution.threeSum(new int[] { -5, -4, -3, -2, -1 });
        assertEquals(Set.of(), normalize(result));
    }

    @Test
    void multipleDuplicatesOnlyOneTriplet() {
        List<List<Integer>> result = solution.threeSum(new int[] { -2, 0, 0, 2, 2 });
        assertEquals(Set.of(List.of(-2, 0, 2)), normalize(result));
    }
}
