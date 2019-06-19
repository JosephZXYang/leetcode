/**

Key points:

    1. Since this is an optimization problem, we would like to solve it 
    by dynamic programming.

    2. Entry i in the DP table represents the maximum subarray ending at 
    entry i of nums array.

Difficulty: Easy

*/
class Solution {
    public int maxSubArray(int[] nums) {
        int[] maximum = new int[nums.length];
        int result = Integer.MIN_VALUE;
        
        for (int i = 0; i < nums.length; i ++) {
            if (i == 0) {
                maximum[i] = nums[i];
            }
            else {
                maximum[i] = Math.max(nums[i], maximum[i-1] + nums[i]);
            }
            result = Math.max(result, maximum[i]);
        }
        
        return result;
    }
}