/**

Key points:

    1. Take care of edge case (ArrayIndexOutOfBound).

Difficulty: Medium

*/
class Solution {
    public int jump(int[] nums) {
        
        if (nums.length <= 1) return 0;
        
        int[] table = new int[nums.length];
        for (int i = 0; i < nums.length; i++) {
            table[i] = Integer.MAX_VALUE;
        }
        table[0] = 0;
        
        for (int i = 1; i <= nums[0] && i < nums.length; i++) {
            table[i] = 1;
        }
        
        for (int i = 1; i < nums.length; i++) {
            for (int j = 1; j <= nums[i] && i + j < nums.length; j++) {
                table[i + j] = Math.min(table[i + j], table[i] + 1);
            }
        }
        
        return table[nums.length-1];
    }
}