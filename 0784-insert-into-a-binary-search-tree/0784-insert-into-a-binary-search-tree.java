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
    public TreeNode insertIntoBST(TreeNode root, int val) {
        TreeNode newnode = new TreeNode(val);
        if(root == null) {
            root = newnode;
            return root;
        }
        TreeNode temp = root, prev = null;
        boolean l = true;
        while(temp!=null) {
            if(val > temp.val) {
                prev = temp;
                temp = temp.right;
                l = false;
            }
            else {
                prev = temp;
                temp = temp.left;
                l = true;
            }
        }
        if(l) prev.left = newnode;
        else prev.right = newnode;
        return root;
    }
}