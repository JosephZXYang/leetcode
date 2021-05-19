/**

Key points:

    1. Another easy AF dynamic programming problem.

    2. I don't fucking understand why w/o using array
    would use more space than the basic array DP approach.
    
    Difficulty: Medium

*/
class Solution {
    public int climbStairs(int n) {
        
        if (n <= 0) return 0;
        if (n == 1) return 1;
        if (n == 2) return 2;
        
        int p = 2;
        int pp = 1;
        int result = 0;
        
        for (int i = 3; i <= n; i ++) {
            result = p + pp;
            pp = p;
            p = result;
        }
        
        return result;
        
    }
}