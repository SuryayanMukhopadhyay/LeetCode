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
    public ListNode swapNodes(ListNode head, int k) {
        ListNode temp = head;
        while(k > 1) {
            temp = temp.next;
            k--;
        }
        ListNode left = temp, right = head;
        while(temp.next != null) {
            temp = temp.next;
            right = right.next;
        }
        int value = left.val;
        left.val = right.val;
        right.val = value;
        return head;
    }
}