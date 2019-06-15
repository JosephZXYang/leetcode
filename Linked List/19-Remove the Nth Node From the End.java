/**

Key point:

    1. Instead of traverse and then find the last n element from 
    the end, first maintain a constant gap of between the two pointers,
    then move the two pointers to the end, (Very brilliant approach!)

*/

class Solution {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode fastPointer = dummy;
        ListNode slowPointer = dummy;
        
        for (int i = 1; i <= n; i++) {
            fastPointer = fastPointer.next;
        }
        
        while (fastPointer.next != null) {
            fastPointer = fastPointer.next;
            slowPointer = slowPointer.next;
        }
        
        slowPointer.next = slowPointer.next.next;
        
        return dummy.next;
    }
}