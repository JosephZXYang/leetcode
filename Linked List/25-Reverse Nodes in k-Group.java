/** 

Key points:

    1. Recursive approach with k pointers per recursive
    call would cause memory limit exceeded.

    2. Use iterative approach with constant number of 
    pointers instead.

    3. Need a pointer for every possible assignment.

Difficulty: Hard

*/

/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public ListNode reverseKGroup(ListNode head, int k) {
        
        if (head == null) return head;
        if (head.next == null) return head;
        
        ListNode last = head;
        ListNode current = head;
        ListNode next = head.next;
        
        for (int i = 0; i < k - 1; i++) {
            ListNode tmp = current;
            current = next;
            next = next.next;
            current.next = tmp;
        }
        
        head = current;
        last.next = next;
        ListNode previousEnd = last;
        
        
        while (true) {
            ListNode tmp = last.next;
            for (int i = 0; i < k; i++) {
                if (tmp == null) return head;
                tmp = tmp.next;
            }
            
            last = last.next;
            current = last;
            next = current.next;
            
            for (int i = 0; i < k - 1; i++) {
                ListNode tmp1 = current;
                current = next;
                next = next.next;
                current.next = tmp1;
            }
            last.next = next;
            previousEnd.next = current;
            previousEnd = last;
        }
    }
}