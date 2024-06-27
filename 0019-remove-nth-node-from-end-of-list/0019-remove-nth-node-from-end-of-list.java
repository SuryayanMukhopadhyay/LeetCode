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
    public ListNode removeNthFromEnd(ListNode head, int n) {
        int size = 0;
        for(ListNode temp = head; temp!=null; temp=temp.next)
        {
            size++;
        }
        if(size==n)
        {
            head=head.next;
            return head;
        }
        int i=1;
        ListNode temp=null;
        for(temp = head; i<size-n; i++, temp=temp.next);
        temp.next = temp.next.next;
        return head;
    }
}