/**

Key points:
    
    1. This is a DP solution for this problem.

    2. The basic idea is: at each iteration, loop over all posible
    palindromes containing the character in the last iteration. Find
    the longest one from DP table.

    3. Need extra space for DP table, which is a con comparing to 
    simple loop/recursion solution.

*/


class Solution {

    // Dynamic Programming Solution, not optimal, only beats 45%
    public String longestPalindrome(String s) {
        if (s.equals("")) {
            return s;
        }
        boolean[][] DPTable = new boolean[s.length()][s.length()];
        String longest = s.substring(0, 1);
        DPTable[0][0] = true;
        for (int i = 1; i < s.length(); i++) {
            DPTable[i][i] = true;
            if (s.charAt(i - 1) == s.charAt(i)) {
                DPTable[i-1][i] = true;
                if (2 > longest.length()) {
                    longest = s.substring(i-1, i+1);
                }
            }
            for (int j = i-2; j >= 0; j--) {
                if (DPTable[j+1][i-1] == true && s.charAt(j) == s.charAt(i)) {
                    DPTable[j][i] = true;
                    if (i - j + 1 > longest.length()) {
                        longest = s.substring(j, i+1);
                    }
                }
            }
        }
        return longest;
    }
}