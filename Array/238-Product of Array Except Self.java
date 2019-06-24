/**

Key points:

    1. REALLY brilliant solution!

    2. Other entries can be divided into two parts:

        a. entries on the left

        b. entries on the right

    3. In this case, we could memorize and reuse products.

Difficulty: Medium

*/
class Solution {
    public int[] productExceptSelf(int[] nums) {
        int[] result = new int[nums.length];
        result[0] = 1;
        for (int i = 1; i < nums.length; i ++) {
            result[i] = result[i-1] * nums[i-1];
        }
        int mul = 1;
        for (int i = nums.length-1; i >= 0; i --) {
            result[i] = result[i] * mul;
            mul *= nums[i];
        }
        return result;
    }
}