/**

Key points:

	1. This is a typical divide and conquer problem.

	2. Basic DAC steps:

		a. Pair up k lists and merge all pairs.

		b. After this merge process, we have k/2 sorted lists.
		Keep pairing and merging until we only have 1 list left.

		c. Return the remaining list.

	3. This problem could also be solved by Priority Queue, but 
	divide and conquer has much better time complexity.
	Priority Queue solution: 57ms
	Divide and Conquer solution: 3ms

Difficulty: Hard

*/
class Solution {

	// Main function, calls helper function.
    public ListNode mergeKLists(ListNode[] lists) {
        if (lists == null || lists.length < 1) {
        	return null;
        }
        
        else {
        	return mergehelper(lists, 0, lists.length - 1);
        }
    }

    // Helper function that perform the divide and conquer split step.
	private ListNode mergehelper(ListNode[] lists, int start, int end) {
		if (start > end) {
			return null;
		}
		if (start == end) {
			return lists[start];
		}
		int mid = (start + end) / 2;
		ListNode leftHalf = mergehelper(lists, start, mid);
		ListNode rightHalf = mergehelper(lists, mid+1, end);
		
		return binaryMerge(leftHalf, rightHalf);
	}

	// Helper function that merges two listnodes.
	private ListNode binaryMerge(ListNode left, ListNode right) {
		if (left == null) {
			return right;
		}
		else if (right == null) {
			return left;
		}
		
		ListNode l;
		if (left.val <= right.val) {
			l = new ListNode(left.val);
			l.next = binaryMerge(left.next, right);
		}
		else {
			l = new ListNode(right.val);
			l.next = binaryMerge(left, right.next);
		}
		return l;
	}
}