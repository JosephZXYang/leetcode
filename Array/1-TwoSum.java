/**

Key points: 

    1. Iterates the array only once.

    2. Use a HashSet to store visited numbers.

Difficulty: Easy

*/

import java.util.*;

class Solution {
    public int[] twoSum(int[] nums, int target) {
        HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
        int[] result = new int[2];
        for (int i=0; i<nums.length; i++) {
            int tar = target - nums[i];
            if (map.containsKey(tar)) {
                result[0] = map.get(tar);
                result[1] = i;
                return result;
            }
            else {
                map.put(nums[i], i);
            }
        }
        return result;
    }
}