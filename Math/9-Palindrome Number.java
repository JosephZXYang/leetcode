/**

Key points: None

Difficulty: Easy

*/

class Solution {
    public boolean isPalindrome(int x) {
        if (x < 0) {
            return false;
        }
        int copy = x;
        int reversed = 0;
        while (copy != 0) {
        	int digit = copy % 10;
        	copy /= 10;
        	reversed = reversed * 10 + digit;
        }
        if (reversed == x) {
        	return true;
        }
        else {
        	return false;
        }
    }
}