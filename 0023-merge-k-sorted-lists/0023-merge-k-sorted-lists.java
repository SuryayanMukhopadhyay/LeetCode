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
    // public ListNode merge(ListNode l1, ListNode l2) {
    // ListNode prehead = new ListNode(-1);
    // ListNode cur = prehead;
    // while (l1 != null && l2 != null) {
    // if (l1.val <= l2.val) {
    // cur.next = l1;
    // l1 = l1.next;
    // } else {
    // cur.next = l2;
    // l2 = l2.next;
    // }
    // cur = cur.next;
    // }
    // cur.next = l1 == null ? l2 : l1;
    // return prehead.next;
    // }

    public ListNode mergeKLists(ListNode[] lists) {
        PriorityQueue<ListNode> PQ = new PriorityQueue<>((x, y) -> x.val - y.val);
        ListNode list = null;
        if (lists.length == 0) {
            return list;
        }
        if (lists.length == 1) {
            return lists[0];
        }
        for (ListNode l : lists) {
            while(l != null) {
                PQ.offer(l);
                l = l.next;
            }
        }
        ListNode prev = null;
        while (!PQ.isEmpty()) {
            ListNode l = PQ.poll();
            l.next = null;
            if(list == null) {
                list = l;
                prev = list;
            }
            else {
                prev.next = l;
                prev = l;
            }
        }
        return list;
    }
}