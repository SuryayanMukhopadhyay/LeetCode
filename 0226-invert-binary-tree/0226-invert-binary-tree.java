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
    // public static TreeNode invert(TreeNode root) {
    //     if(root == null) return null;
    //     root.left = invert(root.left);
    //     root.right = invert(root.right);
    //     TreeNode temp = root.left;
    //     root.left = root.right;
    //     root.right = temp;
    //     return root;
    // }
    public TreeNode invertTree(TreeNode root) {
        if(root == null || (root.left == null && root.right == null)) return root;
        // if(root.left == null) {
        //     root.left = root.right;
        //     root.right = null;
        //     return root;
        // }
        // if(root.right == null) {
        //     root.right = root.left;
        //     root.left = null;
        //     return root;
        // }
        root.left = invertTree(root.left);
        root.right = invertTree(root.right);
        TreeNode temp = root.left;
        root.left = root.right;
        root.right = temp;
        return root;

    }
}