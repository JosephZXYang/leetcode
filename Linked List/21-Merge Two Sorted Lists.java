/** 

Key points:

    1. Take care of edge cases.

    2. Recursive approach.

Difficulty: Easy

*/
class Solution {
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode result = new ListNode(0);
        result = helper(l1, l2, result);
        return result.next;
    }
    
    private ListNode helper(ListNode l1, ListNode l2, ListNode result) {
        if (l1 == null) {
            result.next = l2;
        }
        else if (l2 == null) {
            result.next = l1;
        }
        else {
            ListNode next;
            if (l1.val <= l2.val) {
                next = new ListNode(l1.val);
                result.next = helper(l1.next, l2, next);
            }
            else {
                next = new ListNode(l2.val);
                result.next = helper(l1, l2.next, next);
            }
        }
        return result;
    }
}