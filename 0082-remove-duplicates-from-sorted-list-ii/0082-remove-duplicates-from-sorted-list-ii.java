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
        if(head == null || head.next == null) return head;
        ListNode prev = null, curr = head;
        while(curr != null) {
            if(curr.next == null) {
                break;
            }
            if(curr.val == curr.next.val) {
                int value = curr.val;
                while(curr != null && curr.val == value) {
                    curr = curr.next;
                }
                if(prev != null) {
                    prev.next = curr;
                }
                else {
                    head = curr;
                }
            }
            else {
                prev = curr;
                curr = curr.next;
            }
        }
        return head;
    }
}