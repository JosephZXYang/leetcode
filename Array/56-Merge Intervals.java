/**

Key points:

	1. First we sort start and end of all intervals.

	2. In the loop, note that for a distinct interval,
	start[i+1] > end[i], and the interval has

		start: start[j]
		end: end[i]

	after this iteration, j = i + 1;

Difficulty: Medium

*/
class Solution {
    public int[][] merge(int[][] intervals) {
        if (intervals.length < 2) {
        	return intervals;
        }
        
        int[] start = new int[intervals.length];
        int[] end = new int[intervals.length];
        
        for (int i = 0; i < intervals.length; i ++) {
        	start[i] = intervals[i][0];
        	end[i] = intervals[i][1];
        }
        
        Arrays.sort(start);
        Arrays.sort(end);
        
        List<int[]> arr = new ArrayList<int[]>();
        
        for (int i = 0, j = 0; i < intervals.length; i ++) {
        	if (i == intervals.length - 1 || start[i+1] > end[i]) {
        		int[] elt = new int[2];
        		elt[0] = start[j];
        		elt[1] = end[i];
        		arr.add(elt);
                j = i + 1;
        	}
        }
        
        int[][] result = new int[arr.size()][];
        
        for (int i = 0; i < arr.size(); i ++) {
        	result[i] = arr.get(i);
        }
        
        return result;
    }
}