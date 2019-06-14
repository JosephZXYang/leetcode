/**

Key points:

    1. Start with two ends of the array (i.e. longest width)

    2. In each iteration, width is decremented by 1. But height
    is guaranteed to increase (or remain the same). So by traversing
    the entire array once, it is guaranteed that we would encounter
    the largest case some time.

*/

class Solution {
    public int maxArea(int[] height) {
        int maxArea = 0;
        int leftLine = 0;
        int rightLine = height.length - 1;
        
        while (leftLine < rightLine) {
            maxArea = Math.max(maxArea, Math.min(height[leftLine], height[rightLine]) * (rightLine - leftLine));
            if (height[leftLine] < height[rightLine]) {
                leftLine ++;
            }
            else {
                rightLine --;
            }
        }
        
        return maxArea;
    }
}