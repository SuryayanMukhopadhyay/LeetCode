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
    public int gcd(int a, int b) {
        int n = 0;
        if(a > b) {
            n = b;
        }
        else {
            n = a;
        }
        for(int i = n; i > 1; i--) {
            if(a % i == 0 && b % i == 0) {
                return i;
            }
        }
        return 1;
    }
    public ListNode insertGreatestCommonDivisors(ListNode head) {
        if(head == null || head.next == null) return head; 
        ListNode temp = head;
        while(temp != null) {
            if(temp.next == null) {
                break;
            }
            ListNode newNode = new ListNode(gcd(temp.val, temp.next.val));
            ListNode nextNode = temp.next;
            temp.next = newNode;
            newNode.next = nextNode;
            temp = nextNode;
        }
        return head;
    }
}