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
    public ListNode modifiedList(int[] nums, ListNode head) {
        HashSet<Integer> set = new HashSet<>();
        int n = nums.length;
        for(int i = 0; i < n; i++) {
            set.add(nums[i]);
        }
        while(set.contains(head.val)) {
            head = head.next;
        }
        ListNode temp = head, prev = null;
        while(temp.next != null) {
            if(set.contains(temp.val)) {
                if(prev == null) {
                    prev = temp;
                }
                prev.next = temp.next;
                temp = prev.next;
            }
            else {
                prev = temp;
                temp = temp.next;
            }
            if(prev == null) {
                prev = temp;
                temp = temp.next;
            }   
        }
        if(set.contains(temp.val)) {
            prev.next = null;
        }
        return head;
    }
}