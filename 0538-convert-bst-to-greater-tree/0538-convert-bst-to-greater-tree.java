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
    public TreeNode convertBST(TreeNode root) {
        int sum = 0;
        TreeNode temp = root;
        Stack<TreeNode> stack = new Stack<>();
        while(true) {
            while(root != null) {
                stack.push(root);
                root = root.right;
            }
            if(stack.isEmpty()) break;
            root = stack.pop();
            sum += root.val;
            root.val = sum;
            root = root.left;
        }
        return temp;
    }
}