/**

Key points:

    1. Do NOT solve this problem using String! Use math operations instead.

    2. Casting integer to String and casting it back at the end takes unnecessary 
    extra time.

Difficulty: Easy

*/

class Solution {
	public int reverse(int x) {
        int reversed = 0;
        while (x != 0) {
        	int remainder = x % 10;
        	x /= 10;
        	if (reversed > Integer.MAX_VALUE / 10 || (reversed == Integer.MAX_VALUE
        			&& remainder == 7)) {
        		return 0;
        	}
        	if (reversed < Integer.MIN_VALUE / 10 || (reversed == Integer.MIN_VALUE
        			&& remainder == -8)) {
        		return 0;
        	}
        	reversed = reversed * 10 + remainder;
        }
        return reversed;
    }
}