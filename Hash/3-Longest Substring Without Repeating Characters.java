/**

Key points:

1. No need to update entire HashMap in each iteration.
In order to get the correct start index, use Math.max().
2. Note that all elements in the map records the last 
occurrence index of corresponding key value.

*/

import java.util.*;

class Solution {
	public int lengthOfLongestSubstring(String s) {
		HashMap<Character, Integer> map = new HashMap<Character, Integer>();
		int maxLength = 0;
		int start = 0;
		for (int end = 0; end < s.length(); end++) {
            if (map.containsKey(s.charAt(end))) {
                start = Math.max(map.get(s.charAt(end)) + 1, start);
            }
            maxLength = Math.max(end - start + 1, maxLength);
            map.put(s.charAt(end), end);
        }
		return maxLength;
	}
}