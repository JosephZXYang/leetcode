/**

Key points:

    1. Simple String problem. EZAF. Just follow instructions.

Difficulty: Easy

*/

class Solution {
    public String longestCommonPrefix(String[] strs) {
        String result = "";
        if (strs.length == 0) {
            return result;
        }
        int shortestLength = Integer.MAX_VALUE;
        
        for (String s : strs) {
            shortestLength = Math.min(shortestLength, s.length());
        }
        
        for (int i = 0; i < shortestLength; i++) {
            boolean foundDifferent = false;
            char c = strs[0].charAt(i);
            for (String s : strs) {
                if (s.charAt(i) != c) {
                    foundDifferent = true;
                    break;
                }
            }
            if (foundDifferent) {
                break;
            }
            else {
                result += c;
            }
        }
        return result;
    }
}