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
    public boolean hasCycle(ListNode head) {
        if(head == null) { return false; }
        
        boolean start = false;
        ListNode f = head;
        ListNode s = head;

        while(f != null || f.next != null) {
            if(start && f == s) {
                return true;
            }

            f = f.next;
            if(f != null && f.next != null) { f = f.next; }
            else { return false; }

            s = s.next;
            start = true;
        }

        return false;
    }
}
