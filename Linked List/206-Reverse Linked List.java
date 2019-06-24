/**

Key points:

    1. Construct 2 pointers.

    2. One points to part of list that have already been reversed.

    3. The other points to the part of list remaining to be reversed.

Difficulty: Easy

*/
class Solution {
    public ListNode reverseList(ListNode head) {
        if (head == null) {
            return head;
        }
        else if (head.next == null) {
            return head;
        }
        else {
            ListNode remains = head.next;
            ListNode current = head;
            ListNode finished = null;
            
            while (remains != null) {
                current.next = finished;
                finished = current;
                current = remains;
                remains = remains.next;
            }
            
            current.next = finished;
            
            return current;
            
        }
    }
}