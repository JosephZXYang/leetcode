/**

Key points:

    1. Greedy.

    2. endPtr keeps track of incoming earliest end time.

    3. For each start time, we just need to check whether it starts before endPtr (the current
    EET upcoming). If so, we need one more room, since no room is available right now. If not,
    we just increment EET pointer, since former EET already ended and thus one room is available now. 
    In this case, no need to add a new room.

Difficulty: Medium

*/
class Solution {
    public int minMeetingRooms(int[][] intervals) {
        if (intervals.length < 1) {
            return 0;
        }
        
        int[] start = new int[intervals.length];
        int[] end = new int[intervals.length];
        
        for (int i = 0; i < intervals.length; i ++) {
        	start[i] = intervals[i][0];
        	end[i] = intervals[i][1];
        }
        
        Arrays.sort(start);
        Arrays.sort(end);
        
        int numRooms = 0;
        
        for (int i = 0, endPtr = 0; i < intervals.length; i ++) {
        	if (start[i] < end[endPtr]) {
        		numRooms ++;
        	}
        	else {
        		endPtr ++;
        	}
        }
        
        return numRooms;
	}
}