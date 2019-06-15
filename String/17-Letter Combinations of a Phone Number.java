/** 

Key points:

    1. Write a helper function to cover all cases by recursive 
    calls.

Difficulty: Medium

*/

import java.util.*;

class Solution {
    public List<String> letterCombinations(String digits) {
        List<String> list = new ArrayList<String>();
        if (digits.length() == 0) {
            return list;
        }
        helper(list, "", digits);
        return list;
    }
    
    private void helper(List<String> list, String s, String remaining) {
        if (remaining.length() == 0) {
            list.add(s);
        }
        
        else {
            char c = remaining.charAt(0);
            
            if (c == '2') {
                helper(list, s + "a", remaining.substring(1));
                helper(list, s + "b", remaining.substring(1));
                helper(list, s + "c", remaining.substring(1));
            }
            
            else if (c == '3') {
                helper(list, s + "d", remaining.substring(1));
                helper(list, s + "e", remaining.substring(1));
                helper(list, s + "f", remaining.substring(1));
            }
            
            else if (c == '4') {
                helper(list, s + "g", remaining.substring(1));
                helper(list, s + "h", remaining.substring(1));
                helper(list, s + "i", remaining.substring(1));
            }
            
            else if (c == '5') {
                helper(list, s + "j", remaining.substring(1));
                helper(list, s + "k", remaining.substring(1));
                helper(list, s + "l", remaining.substring(1));
            }
            
            else if (c == '6') {
                helper(list, s + "m", remaining.substring(1));
                helper(list, s + "n", remaining.substring(1));
                helper(list, s + "o", remaining.substring(1));
            }
            
            else if (c == '7') {
                helper(list, s + "p", remaining.substring(1));
                helper(list, s + "q", remaining.substring(1));
                helper(list, s + "r", remaining.substring(1));
                helper(list, s + "s", remaining.substring(1));
            }
            else if (c == '8') {
                helper(list, s + "t", remaining.substring(1));
                helper(list, s + "u", remaining.substring(1));
                helper(list, s + "v", remaining.substring(1));
            }
            else if (c == '9') {
                helper(list, s + "w", remaining.substring(1));
                helper(list, s + "x", remaining.substring(1));
                helper(list, s + "y", remaining.substring(1));
                helper(list, s + "z", remaining.substring(1));
            }
        }
    }
}