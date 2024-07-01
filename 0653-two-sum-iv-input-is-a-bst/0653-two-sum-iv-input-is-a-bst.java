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
    public boolean findTarget(TreeNode root, int k) {
        if(root.left == null && root.right == null) return false;
        HashSet<Integer> set = new HashSet<>();
        Queue<TreeNode> Q = new LinkedList<>();
        Q.offer(root);
        while(!Q.isEmpty()) {
            int size = Q.size();
            for(int i = 0; i < size; i++) {
                TreeNode temp = Q.poll();
                set.add(temp.val);
                if(temp.left != null) Q.offer(temp.left);
                if(temp.right != null) Q.offer(temp.right);
            }
        }
        Q.offer(root);
        while(!Q.isEmpty()) {
            int size = Q.size();
            for(int i = 0; i < size; i++) {
                TreeNode temp = Q.poll();
                if(set.contains(k - temp.val) && temp.val != k/2) return true;
                if(temp.left != null) Q.offer(temp.left);
                if(temp.right != null) Q.offer(temp.right);
            }
        }
        return false;
    }
}