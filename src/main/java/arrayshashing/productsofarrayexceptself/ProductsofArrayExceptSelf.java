package arrayshashing.productsofarrayexceptself;

// Input: nums = [1,2,4,6]
// Output: [48,24,12,8]

public class ProductsofArrayExceptSelf {
    public int[] productExceptSelf(int[] nums) {
        int length = nums.length;
        int[] out = new int[length];
        out[0] = 1;
        // create accumulative from left to right
        for (int i = 1; i < length; i++) {
            out[i] = out[i - 1] * nums[i - 1];
        }

        int R = 1;
        for (int i = length - 1; i >= 0; i--) {
            out[i] = out[i] * R;
            R = R * nums[i];
        }

        return out;
    }
}
