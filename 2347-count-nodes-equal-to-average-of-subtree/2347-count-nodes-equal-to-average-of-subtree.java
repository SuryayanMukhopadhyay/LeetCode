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
    int nodes = 0;
    Pair<Integer, Integer> getAverage(TreeNode root) {
        if(root == null) return new Pair<>(0, 0);
        Pair<Integer, Integer> l = getAverage(root.left);
        Pair<Integer, Integer> r = getAverage(root.right);
        int sum = root.val + l.getKey() + r.getKey();
        int count = 1 + l.getValue() + r.getValue();
        Pair<Integer, Integer> curr = new Pair<>(sum, count);
        
        if(sum / count == root.val) {
            nodes++;
        }
        return curr;
    }
    public int averageOfSubtree(TreeNode root) {
        getAverage(root);
        return nodes;
    }
}