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
    public int[][] spiralMatrix(int m, int n, ListNode head) {
        int[][] matrix = new int[m][n];
        int bottom = m, right = n;
        int left = 0, top = 0;
        ListNode temp = head;
        while (left < right && top < bottom) {
            for (int i = left; i < right; i++) {
                if(temp != null) {
                    matrix[top][i] = temp.val;
                    temp = temp.next;
                }
                else {
                    matrix[top][i] = -1;
                }
            }
            top++;
            for (int i = top; i < bottom; i++) {
                if(temp != null) {
                    matrix[i][right - 1] = temp.val;
                    temp = temp.next;
                }
                else {
                    matrix[i][right - 1] = -1;
                }
            }
            right--;
            if (!(left < right) && !(top < bottom)) {
                break;
            }
            if (top < bottom) {
                for (int i = right - 1; i >= left; i--) {
                    if(temp != null) {
                        matrix[bottom - 1][i] = temp.val;
                        temp = temp.next;
                    }
                    else {
                        matrix[bottom - 1][i] = -1;
                    }
                }
            }
            bottom--;
            if (left < right) {
                for (int i = bottom - 1; i >= top; i--) {
                    if(temp != null) {
                        matrix[i][left] = temp.val;
                        temp = temp.next;
                    }
                    else {
                        matrix[i][left] = -1;
                    }
                }
            }
            left++;
        }
        return matrix;
    }
}