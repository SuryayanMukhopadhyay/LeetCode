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
    public int[] nextLargerNodes(ListNode head) {
        ListNode temp = head;
        int n = 0;
        while(temp != null) {
            n++;
            temp = temp.next;
        }
        int[] arr = new int[n];
        temp = head;
        for(int i = 0; temp != null; temp = temp.next, i++) {
            arr[i] = temp.val;
        }
        Stack<Integer> stack = new Stack<>();
        int[] res = new int[n];
        for(int i = n - 1; i>= 0; i--) {
            while(!stack.isEmpty() && stack.peek() <= arr[i]) {
                stack.pop();
            }
            if(stack.isEmpty()) {
                res[i] = 0;
            }
            else {
                res[i] = stack.peek();
            }
            stack.push(arr[i]);
        }
        return res;
    }
}