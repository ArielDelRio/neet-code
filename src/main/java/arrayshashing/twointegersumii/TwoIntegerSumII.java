package arrayshashing.twointegersumii;

public class TwoIntegerSumII {

    public int[] twoSum(int[] numbers, int target) {
        int leftPointer = 0;
        int rightPointer = numbers.length - 1;

        while (leftPointer < rightPointer) {
            int sum = numbers[leftPointer] + numbers[rightPointer];

            if (sum == target) {
                return new int[] { leftPointer + 1, rightPointer + 1 };
            }

            if (sum > target) {
                rightPointer--;
            } else if (sum < target) {
                leftPointer++;
            }
        }

        throw new IllegalArgumentException("No solution");
    }
}
