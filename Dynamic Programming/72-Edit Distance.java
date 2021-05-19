/**

Key points:

    1. A very interesting dynamic programming problem

    2. The key idea: case analysis on 3 operations

        Example: "horse" vs. "ros"

        a. Insertion: table[i][j] = table[i][j - 1] + 1
        // "horse" vs. "ro", then insert "s"

        b. Deletion: table[i][j] = table[i - 1][j] + 1
        // "hors" vs. "ros", then delete "e"

        c. Replace: table[i][j] = table[i - 1][j - 1] (+ 1) or (+ 0) depending 
        on the last character
        // "hors" vs. "ro", add 1 if next characters are not the same (need a replace)
        
    Difficulty: Hard

*/
class Solution {
    public int minDistance(String word1, String word2) {
        
        if (word1.length() == 0) return word2.length();
        if (word2.length() == 0) return word1.length();
        
        int[][] table = new int[word1.length()][word2.length()];
        
        
        int prev = 0;
        boolean seen = false;
        if (word1.charAt(0) == word2.charAt(0)) {
            table[0][0] = 0;
            seen = true;
        }
        else {
            table[0][0] = 1;
            prev = 1;
        }
        
        for (int i = 1; i < word2.length(); i ++) {
            if (word1.charAt(0) == word2.charAt(i) && !seen) {
                table[0][i] = prev;
                seen = true;
            }
            else {
                table[0][i] = ++prev;
            }
        }
        
        prev = 0;
        seen = false;
        if (word1.charAt(0) == word2.charAt(0)) {
            table[0][0] = 0;
            seen = true;
        }
        else {
            table[0][0] = 1;
            prev = 1;
        }
        
        for (int i = 1; i < word1.length(); i ++) {
            if (word1.charAt(i) == word2.charAt(0) && !seen) {
                table[i][0] = prev;
                seen = true;
            }
            else {
                table[i][0] = ++prev;
            }
        }
        
        for (int i = 1; i < word1.length(); i ++) {
            for (int j = 1; j < word2.length(); j ++) {
                int add = 0;
                if (word1.charAt(i) != word2.charAt(j)) add = 1;
                
                table[i][j] = Math.min(1 + table[i - 1][j], Math.min(1 + table[i][j - 1], add + table[i - 1][j - 1]));
            }
        }
        
        return table[word1.length() - 1][word2.length() - 1];
    }
}