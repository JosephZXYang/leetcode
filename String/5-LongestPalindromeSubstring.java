/**

Key points:

	1. Since we are looking for palindromes, in each iteration, 
	we can start at an index and extend to both directions.

	2. This implementation does not need extra memory for 
	array/table/set storage

*/

class Solution {
    public String longestPalindrome(String s) {
		String longest = "";
		for (int i = 0; i < s.length(); i++) {
			String s1 = extendPalindrome(s, i, i+1);
			String s2 = extendPalindrome(s, i, i);
			String longer = "";
			if (s1.length() > s2.length()) {
				longer = s1;
			}
			else {
				longer = s2;
			}
			if (longer.length() > longest.length()) {
				longest = longer;
			}
		}
		return longest;
	}

	private String extendPalindrome(String s, int i, int j) {
		while (i >= 0 && j < s.length()) {
			if (s.charAt(i) != s.charAt(j)) {
				break;
			}
			i --;
			j ++;
		}
		return s.substring(i + 1, j);
	}
}