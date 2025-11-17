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
    public ListNode mergeKLists(ListNode[] lists) {
        if(lists == null || lists.length == 0) return null;
        return mergeKLists(lists, 0 , lists.length - 1);
    }

    public ListNode mergeKLists(ListNode[] lists, int start, int end) {
        
        if(start == end) return lists[start];

        int mid = start + (end - start)/2;
        ListNode left = mergeKLists(lists, start, mid);    
        ListNode right = mergeKLists(lists, mid + 1, end);
        return merge2Lists(left, right);
        }

    private ListNode merge2Lists(ListNode n1, ListNode n2) {
        ListNode head = new ListNode(-1);
        ListNode dummy = head;
        while(n1 !=null && n2 !=null) {
            if(n1.val < n2.val) {
                ListNode temp = new ListNode(n1.val);
                head.next = temp;
                head = temp;
                n1 = n1.next;    
            } else {
                ListNode temp = new ListNode(n2.val);
                head.next = temp;
                head = temp;
                n2 = n2.next;
            }

        }
        if(n1 != null) {
            head.next = n1;
        }
        if(n2 != null) {
            head.next = n2;
        }

    return dummy.next;
    }
}