package twopointers.trappingrainwater;

public class TrappingRainWater {

    public int trap(int[] height) {
        int left = 0;
        int right = height.length - 1;
        int maxLeft = 0;
        int maxRight = 0;
        int water = 0;

        while (left < right) {
            maxLeft = Math.max(maxLeft, height[left]);
            maxRight = Math.max(maxRight, height[right]);

            if (maxLeft <= maxRight) {
                water += maxLeft - height[left];
                left++;
            } else {
                water += maxRight - height[right];
                right--;
            }
        }
        return water;
    }
}
