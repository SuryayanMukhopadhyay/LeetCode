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
    public ListNode partition(ListNode head, int x) {
        if(head == null || head.next == null) return head;
        ListNode less = null, more = null, temp = head, lessHead = null, moreHead = null;
        while(temp != null) {
            if(temp.val < x) {
                if(less == null) {
                    less = new ListNode(temp.val);
                    lessHead = less;
                }
                else {
                    ListNode nextNode = new ListNode(temp.val);
                    less.next = nextNode;
                    less = nextNode;
                }
            }
            else {
                if(more == null) {
                    more = new ListNode(temp.val);
                    moreHead = more;
                }
                else {
                    ListNode nextNode = new ListNode(temp.val);
                    more.next = nextNode;
                    more = nextNode;
                }
            }
            temp = temp.next;
        }
        if(less == null) {
            return moreHead;
        }
        less.next = moreHead;
        return lessHead;
    }
}