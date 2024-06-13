/**
 * Definition for singly-linked list.
 * public class ListNode {
 * int val;
 * ListNode next;
 * ListNode() {}
 * ListNode(int val) { this.val = val; }
 * ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public static ListNode reverse(ListNode node) {
        ListNode prev = null, curr = node;
        while (curr != null) {
            ListNode nextnode = curr.next;
            curr.next = prev;
            prev = curr;
            curr = nextnode;
        }
        return prev;
    }

    public ListNode swapPairs(ListNode head) {
        if (head == null || head.next == null)
            return head;
        ListNode temp = head, prev = null;
        head = null;
        while (temp != null && temp.next != null) {
            ListNode nextnode = temp.next.next;
            temp.next.next = null;
            temp = reverse(temp);
            if (head == null) {
                head = temp;                
            }
            if(prev != null)
                prev.next = temp;
            prev = temp.next;                
            prev.next = nextnode;
            temp = nextnode;
        }
        return head;
    }
}