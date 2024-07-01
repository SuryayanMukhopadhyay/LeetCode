/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    public int kthSmallest(TreeNode root, int k) {
        int kth = 0;
        Stack<TreeNode> stack = new Stack<>();
        TreeNode temp = root;
        while(true) {
            while(temp!=null) {
                stack.push(temp);
                temp = temp.left;
            }
            if(stack.isEmpty()) break;
            temp = stack.pop();
            kth = temp.val;
            k--;
            if(k == 0) break;
            temp = temp.right;
        }
        return kth;
    }
}