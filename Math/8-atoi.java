/**

Key points:
    
    Edge cases!!!!!!!!

    1. positive overflow
    2. negative overflow


    First cast to long then we could increment Integer.MAX_VALUE. Otherwise 
    would Integer.MAX_VALUE + 1 = 0.

    Need to use in this way:

    (long)Integer.MAX_VALUE + 1        // That's the absolute value
                                          of Integer.MIN_VALUE that we want

Difficulty: Medium

*/

class Solution {
    public int myAtoi(String str) {
        String s = str.trim();
        long myInt = 0;
        boolean sign = true;
        int currentDigit = 0;
        if (s.length() < 1) {
        	return 0;
        }
        if (s.charAt(0) == '-') {
        	sign = false;
        }
        else if (s.charAt(0) == '+') {
        	sign = true;
        }
        else if (s.charAt(0) - '0' >= 0 && s.charAt(0) - '0' <= 9) {
        	currentDigit = s.charAt(0) - '0';
        	myInt += currentDigit;
        }
        else {
        	return 0;
        }
        for (int i = 1; i < s.length(); i++) {
        	if (s.charAt(i) - '0' >= 0 && s.charAt(i) - '0' <= 9) {
        		currentDigit = s.charAt(i) - '0';
        		myInt = myInt * 10 + currentDigit;
        		if (sign && myInt >= Integer.MAX_VALUE) {
        			return Integer.MAX_VALUE;
        		}
        		if (!sign && myInt >= ((long)Integer.MAX_VALUE+1)) {
        			return Integer.MIN_VALUE;
        		}
        	}
        	else {
        		break;
        	}
        }
        if (sign && myInt >= Integer.MAX_VALUE) {
			return Integer.MAX_VALUE;
		}
		if (!sign && myInt >= (long)(Integer.MAX_VALUE)+1) {
			return Integer.MIN_VALUE;
		}
		if (sign) {
            return (int)myInt;
        }
        else {
            return (int)-myInt;
        }
    }
}