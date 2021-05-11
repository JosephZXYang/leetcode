/**

Key points: 

	1. First step binary search: find one occurrence of 
        target value and a current range of search.
    2. Search the start in the first half of range of search.
    3. Search the end in the second half of range of search.

Difficulty: Medium
 
*/
class Solution {
    public int[] searchRange(int[] nums, int target) {
        
        int[] result = new int[2];
        result[0] = -1;
        result[1] = -1;
        if (nums.length == 0) return result;
        
        int start = 0;
        int end = nums.length-1;
        int middle = 0;
        
        while (start <= end) {
            middle = (start + end) / 2;
            
            if (nums[middle] > target) {
                end = middle - 1;
            }
            
            else if (nums[middle] == target) {
                break;
            }
            
            else if (nums[middle] < target) {
                start = middle + 1;
            }
        }
        
        if (nums[middle] == target) {
            result[0] = searchStart(nums, target, start, middle);
            result[1] = searchEnd(nums, target, middle, end);
        }
        
        return result;
        
    }
    
    private int searchStart(int[] nums, int target, int s, int e) {
        
        if (nums.length == 0) return -1;
        
        int start = s;
        int end = e;
        int middle;
        
        while (start < end) {
            middle = (start + end) / 2;
            
            if (nums[middle] > target) {
                end = middle - 1;
            }
            
            else if (nums[middle] == target) {
                end = middle;
            }
            
            else if (nums[middle] < target) {
                start = middle + 1;
            }
        }
        
        return start;
        
    }
    
    private int searchEnd(int[] nums, int target, int s, int e) {
        
        if (nums.length == 0) return -1;
        
        int start = s;
        int end = e;
        int middle;
        
        while (start < end) {
            middle = (start + end) / 2 + 1;
            
            if (nums[middle] > target) {
                end = middle - 1;
            }
            
            else if (nums[middle] == target) {
                start = middle;
            }
            
            else if (nums[middle] < target) {
                start = middle + 1;
            }
        }
        
        return start;
        
    }
}