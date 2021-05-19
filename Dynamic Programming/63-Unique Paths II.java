/**

Key points:

    1. Still very basic comparing to 62.

    2. We don't really need a 2D array. 1D is sufficient. To
    save space, construct an array with length min(m, n)

    3. Just take care of the FUCKING GODDAMN edge cases.
Difficulty: Medium

*/
class Solution {
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        
        if (obstacleGrid.length == 0 || obstacleGrid[0].length == 0) return 0;
        
        int m = obstacleGrid.length;
        int n = obstacleGrid[0].length;
        
        int[] table = new int[n];
            
        if (obstacleGrid[0][0] == 1) return 0;
        if (obstacleGrid[m - 1][n - 1] == 1) return 0;
        
        table[0] = 1;
        
        for (int i = 1; i < n; i ++) {
            if (table[i - 1] == 0 || obstacleGrid[0][i] == 1) table[i] = 0;
            else table[i] = 1;
        }

        for (int i = 1; i < m; i ++) {
            if (obstacleGrid[i][0] == 1) table[0] = 0;
            
            for (int j = 1; j < n; j ++) {
                if (obstacleGrid[i][j] == 1) table[j] = 0;
                else{
                    table[j] += table[j - 1];
                }
            }
        }
        
        return table[n - 1];
        
    }
}