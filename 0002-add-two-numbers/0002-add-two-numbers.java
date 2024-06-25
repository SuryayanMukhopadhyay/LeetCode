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
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode head = null, N = null;
        int carry = 0;
        ListNode temp1 = l1, temp2 = l2;
        while(temp1!=null || temp2!=null) {
            if(temp1==null) {
                int value = carry + temp2.val;
                if(value > 9) {
                    value = value % 10;
                    carry = 1;
                }
                else carry = 0;
                if(head == null) {
                    N = new ListNode(value);
                    head = N;
                }
                else {
                    ListNode M = new ListNode(value);
                    N.next = M;
                    N = M;
                }
                temp2 = temp2.next;
            }
            else if(temp2==null) {
                int value = carry + temp1.val;
                if(value > 9) {
                    value = value % 10;
                    carry = 1;
                }
                else carry = 0;
                if(head == null) {
                    N = new ListNode(value);
                    head = N;
                }
                else {
                    ListNode M = new ListNode(value);
                    N.next = M;
                    N = M;
                }
                temp1 = temp1.next;
            } 
            else {
                int value = carry + temp1.val + temp2.val;
                if(value > 9) {
                    value = value % 10;
                    carry = 1;
                }
                else carry = 0;
                if(head == null) {
                    N = new ListNode(value);
                    head = N;
                }
                else {
                    ListNode M = new ListNode(value);
                    N.next = M;
                    N = M;
                }
                temp1 = temp1.next;
                temp2 = temp2.next;
            }
        }   
        if(carry == 1) {
            ListNode M = new ListNode(1);
            N.next = M;
            M.next = null;
        }
        return head;    
    }
}