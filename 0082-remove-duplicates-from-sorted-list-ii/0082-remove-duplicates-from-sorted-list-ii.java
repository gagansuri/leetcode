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
    public ListNode deleteDuplicates(ListNode head) {
        ListNode dummy = new ListNode();
        dummy.next = head;
        ListNode pre = dummy;
        ListNode curr = head;

        while(curr != null) {
            if(curr.next != null && curr.val == curr.next.val) {
                // keep the pre and move on curr till curr and next dont match
                while(curr.next != null && curr.val == curr.next.val) curr = curr.next;
                pre.next = curr.next;
                curr = curr.next;
            } else {
                pre = curr;
                curr = curr.next;
            }
        }
        return dummy.next;

    }
}