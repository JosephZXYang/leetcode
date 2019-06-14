/** 

Key points: 

    1. Use StringBuffer instead of String to save time updating stored
    row String in each iteration.
    2. StringBuffer.append()

Difficulty: Medium

*/


class Solution {
	public String convert(String s, int numRows) {
        if (s.length() == 0 || s.length() <= numRows || numRows < 2) {
        	return s;
        }
        StringBuffer[] rows = new StringBuffer[numRows];
        for (int z = 0; z < numRows; z++) {
            rows[z] = new StringBuffer();
        }
        for (int i = 0; i < s.length(); i++) {
            int j = i % (2 * (numRows - 1)); 
            if (j < numRows) {
                rows[j].append(s.charAt(i));
            }
            else {
                int index = (numRows - 2) - (j - numRows);
                rows[index].append(s.charAt(i));
            }
        }
        for (int j = 1; j < rows.length; j++) {
            rows[0].append(rows[j]);
        }
        return rows[0].toString();
    }
}