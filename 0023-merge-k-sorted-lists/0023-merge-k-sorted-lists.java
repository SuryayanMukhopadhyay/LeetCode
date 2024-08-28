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
    public ListNode merge(ListNode l1, ListNode l2) {
        ListNode prehead = new ListNode(-1);
        ListNode cur = prehead;
        while (l1 != null && l2 != null) {
            if (l1.val <= l2.val) {
                cur.next = l1;
                l1 = l1.next;
            } else {
                cur.next = l2;
                l2 = l2.next;
            }
            cur = cur.next;
        }
        cur.next = l1 == null ? l2 : l1;
        return prehead.next;
    }

    public ListNode mergeKLists(ListNode[] lists) {
        PriorityQueue<ListNode> PQ = new PriorityQueue<>((x, y) -> x.val - y.val);
        ListNode list = null;
        if(lists.length == 0) {
            return list;
        }
        if(lists.length == 1) {
            return lists[0];
        }
        for(ListNode l : lists) {
            if(l != null) {
                PQ.offer(l);
            }
        }
        while(!PQ.isEmpty()) {
            ListNode l1 = PQ.poll();
            if(!PQ.isEmpty()) {
                ListNode l2 = PQ.poll();
                ListNode temp = merge(l1, l2);
                PQ.offer(temp);
            }
            list = l1;
        }
        return list;
    }
}