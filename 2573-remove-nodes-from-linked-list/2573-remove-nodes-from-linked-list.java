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
    public ListNode reverse(ListNode head) {
        ListNode prev = null, curr = head;
        while(curr != null) {
            ListNode nextNode = curr.next;
            curr.next = prev;
            prev = curr;
            curr = nextNode;
        }
        return prev;
    }
    public ListNode removeNodes(ListNode head) {
        head = reverse(head);
        ListNode rev = head;
        Stack<Integer> stack = new Stack<>();
        ArrayList<Integer> list = new ArrayList<>();
        for(rev = head; rev != null; rev = rev.next) {
            while(!stack.isEmpty() && stack.peek() <= rev.val) {
                stack.pop();
            }
            if(stack.isEmpty()) {
                list.add(-1);
            }
            else {
                list.add(stack.peek());
            }
            stack.push(rev.val);
        }
        Collections.reverse(list);
        head = reverse(head);
        ListNode prev = null, curr = head;
        int i = 0;
        while(curr != null) {
            if(list.get(i) != -1) {
                if(prev != null) {
                    prev.next = curr.next;
                    curr = prev.next;
                }
                else {
                    head = head.next;
                    curr = head;
                }
            }
            else {
                prev = curr;
                curr = curr.next;
            }
            if(curr == null) {
                break;
            }
            i++;
        }
        return head;
    }
}