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
    public static ListNode reverse(ListNode node) {
        ListNode prev = null, curr = node;
        while(curr != null) {
            ListNode newnode = curr.next;
            curr.next = prev;
            prev = curr;
            curr = newnode;
        }
        return prev;
    }
    public ListNode reverseBetween(ListNode head, int left, int right) {
        if(head == null) return null;
        if(left == right) return head;
        ListNode temp = head, prev = null,nextnode = null;
        for(int i = 1; i < right; i++) {
            if(i == left - 1) {
                prev = temp;
            }
            temp = temp.next;
        }
        if(left == 1) {
            nextnode = temp.next;
            temp.next = null;
            head = reverse(head);
            while(temp.next!=null) {
                temp = temp.next;
            }
            temp.next = nextnode;
        }
        else {
            nextnode = temp.next;
            temp.next = null;
            temp = reverse(prev.next);
            prev.next = temp;
            while(temp.next!=null) {
                temp = temp.next;
            }
            temp.next = nextnode;
        }
        return head;
    }
}