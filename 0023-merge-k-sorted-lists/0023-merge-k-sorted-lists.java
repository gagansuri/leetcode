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
     // merging 2 lists
     // option is mergin2 list and then next and so on 
     // N elements in the list - and there are M lists
     // merging will happen in MN time
     if(lists == null || lists.length == 0) return null;
     return mergeKLists(lists, 0 , lists.length - 1);   
    }

    public ListNode mergeKLists(ListNode[] lists, int start, int end) {
     // merging 2 lists
     // option is mergin2 list and then next and so on 
     // N elements in the list - and there are M lists
     // merging will happen in MN time
       
        if(start == end) return lists[start];
        int mid = start + (end - start)/2;
        ListNode left = mergeKLists(lists, start, mid); // mid not included
        ListNode right = mergeKLists(lists, mid + 1, end);
        return  merge2Lists(left, right);
}

public ListNode merge2Lists(ListNode l1, ListNode l2) {
    ListNode root = new ListNode();
    ListNode dummy = root;
    while(l1 != null && l2 != null) {
        if(l1.val < l2.val) {
           ListNode t = new ListNode(l1.val);
           dummy.next = t;
           dummy = dummy.next; 
           l1 = l1.next;    
        } else {
            ListNode t = new ListNode(l2.val);
            dummy.next = t;
            dummy = dummy.next;
            l2 = l2.next;
        }
    }

    if(l1 != null) {
        dummy.next = l1;
    }

    
    if(l2 != null) {
        dummy.next = l2;
    }

    return root.next;
}
}