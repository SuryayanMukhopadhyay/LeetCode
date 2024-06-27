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
            ListNode nextnode = curr.next;
            curr.next = prev;
            prev = curr;
            curr = nextnode;
        }
        return prev;
    }
    public static ListNode traversetoK(ListNode node, int k) {
        for(int i = 0; i < k-1; i++) {
            if(node == null) return null;
            node = node.next;
        }
        return node;
    }
    public ListNode reverseKGroup(ListNode head, int k) {
        if(head == null) return null;
        ListNode temp = head;
        temp = traversetoK(temp, k);
        if(temp == null) return head;
        temp = head;
        ListNode kth = traversetoK(temp, k);
        ListNode nextnode = kth.next;
        kth.next = null;
        temp = reverse(temp);
        head = temp;
        ListNode lastnode = traversetoK(temp, k);
        lastnode.next = nextnode;
        temp = nextnode;
        while(temp != null) {
            kth = traversetoK(temp, k);
            if(kth == null) break;
            nextnode = kth.next;
            lastnode.next = null;
            kth.next = null;
            temp = reverse(temp);
            lastnode.next = temp;
            lastnode = traversetoK(temp, k);
            lastnode.next = nextnode;
            temp = nextnode;
        }
        return head;
    }
}