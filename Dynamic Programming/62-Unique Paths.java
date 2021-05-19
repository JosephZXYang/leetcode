/**

Key points:

    1. A simple AF dynamic programming problem. VERY basic.

    2. We don't really need a 2D array. 1D is sufficient. To
    save space, construct an array with length min(m, n)

Difficulty: Medium

*/
class Solution {
    public int uniquePaths(int m, int n) {
        
        if (m < 1 || n < 1) return 0;
        
        if (m > n) {
            int[] table = new int[n];

            for (int i = 0; i < n; i ++) {
                table[i] = 1;
            }

            for (int i = 1; i < m; i ++) {
                for (int j = 1; j < n; j ++) {
                    table[j] += table[j - 1];
                }
            }

            return table[n - 1];
        }
        
        else {
            int[] table = new int[m];

            for (int i = 0; i < m; i ++) {
                table[i] = 1;
            }

            for (int i = 1; i < n; i ++) {
                for (int j = 1; j < m; j ++) {
                    table[j] += table[j - 1];
                }
            }

            return table[m - 1];
        }

    }
}