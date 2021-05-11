/**

Key points: 

    1. Several different approaches

Difficulty: Hard

*/

class Solution {
    public int trap_Stack(int[] height) {

        /**
         * Via stack
         */
        
        Stack<Integer> stack = new Stack<Integer>();
        int waterTrapped = 0;
        
        for (int i = 0; i < height.length; i ++) {
            
            while (!stack.empty() && height[i] > height[stack.peek()]) {
                
                int middleIndex = stack.pop();
                if (stack.empty()) break;
                int leftIndex = stack.peek();
                waterTrapped += (i - leftIndex - 1) * (Math.min(height[leftIndex], height[i]) - height[middleIndex]);
                
            }
            
            stack.push(i);
        }
        
        return waterTrapped;
    }

    public int trap(int[] height) {

        /**
         * Via two pointers
         */
        
        int left = 0;
        int right = height.length - 1;
        int left_max = 0;
        int right_max = 0;
        int waterTrapped = 0;
        
        while (left < right) {
            
            if (height[left] < height[right]) {
                
                if (height[left] > left_max) left_max = height[left];
                else{
                    waterTrapped += left_max - height[left];
                }
                
                left ++;
                
            }
            else {
                
                if (height[right] > right_max) right_max = height[right];
                else{
                    waterTrapped += right_max - height[right];
                }
                
                right --;
                
            }
            
        }
        
        return waterTrapped;
    }
}