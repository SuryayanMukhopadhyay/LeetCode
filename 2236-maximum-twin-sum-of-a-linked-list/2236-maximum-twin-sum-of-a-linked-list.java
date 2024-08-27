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
    public int pairSum(ListNode head) {
        int size = 0;
        for(ListNode temp = head; temp != null; temp = temp.next) {
            size++;
        }
        int[] arr = new int[size / 2];
        ListNode temp = head;
        int i = 0;
        while(i < size / 2) {
            arr[i] = temp.val;
            temp = temp.next;
            i++;
        }
        i = size/2 - 1;
        while(i >= 0) {
            arr[i] += temp.val;
            temp = temp.next;
            i--;
        }
        int max = Integer.MIN_VALUE;
        for(int j = 0; j < size / 2; j++) {
            max = Math.max(max, arr[j]);
        }
        return max;
    }
}