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
    public void dfs(TreeNode root, int pathMax, int[] arr) {
        if(root == null) {
            return;
        }
        if(root.val >= pathMax) {
            arr[0] += 1;
            pathMax = root.val;
        }
        dfs(root.left, pathMax, arr);
        dfs(root.right, pathMax, arr);
    }
    public int goodNodes(TreeNode root) {
        if(root == null) return 0;
        int[] arr = new int[1];
        arr[0] = 0;
        dfs(root, root.val, arr);
        return arr[0];
    }
}