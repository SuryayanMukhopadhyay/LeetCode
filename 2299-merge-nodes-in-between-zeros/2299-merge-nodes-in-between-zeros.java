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
    public ListNode mergeNodes(ListNode head) {
        ListNode temp = head;
        while(temp != null) {
            if(temp.val == 0) {
                ListNode nonzero = temp.next;
                int sum = 0;
                if(temp.next != null) {
                    while(nonzero.val != 0) {
                        sum += nonzero.val;
                        nonzero = nonzero.next;
                    }
                    temp.next.val = sum;
                    temp.next.next = nonzero;    
                }
            }
            temp = temp.next;
        }

        ///                1 3 4 0
        temp = head;
        ListNode prev = temp;
        while(temp != null) {
            if(temp.val == 0) {
                if(temp == head) {
                    head = head.next;
                    temp = head;
                    prev = temp;
                }
                else {
                    if(temp.next != null) {
                        temp = temp.next;
                        prev.next = temp;
                    }
                    else {
                        prev.next = null;
                        break;
                    }
                }
            }
            else {
                prev = temp;
                temp = temp.next;
            }

        }
        return head;
    }
}