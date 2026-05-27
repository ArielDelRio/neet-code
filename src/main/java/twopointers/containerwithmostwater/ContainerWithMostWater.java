package twopointers.containerwithmostwater;

public class ContainerWithMostWater {

    public int maxArea(int[] heights) {
        int left = 0;
        int right = heights.length - 1;
        int area = 0;

        while (left < right) {
            area = Math.max(area, Math.min(heights[left], heights[right]) * Math.abs(right - left));
            if (heights[right] < heights[left]) {
                right--;
            } else {
                left++;
            }
        }

        return area;
    }
}
