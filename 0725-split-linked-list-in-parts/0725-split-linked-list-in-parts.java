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
    public ListNode[] splitListToParts(ListNode head, int k) {
        ListNode[] nodes = new ListNode[k];
        Arrays.fill(nodes, null);
        int n = 0;
        for(ListNode temp = head; temp != null; temp = temp.next) {
            n++;
        }
        int size = n / k;
        int first = n % k;
        int i = 1;
        ListNode temp = head, prev = null;
        nodes[0] = head;
        int x = 0;
        while(temp != null) {
            if(first > 0 && x == size + 1) {
                nodes[i] = temp;
                if(prev != null) {
                    prev.next = null;
                }
                i++;
                first--;
                x = 0;
            }
            else if(first == 0 && x == size) {
                nodes[i] = temp;
                if(prev != null) {
                    prev.next = null;
                }
                i++;
                x = 0;
            }
            else {
                prev = temp;
                temp = temp.next;
                x++;
            }
        }
        return nodes;
    }
}