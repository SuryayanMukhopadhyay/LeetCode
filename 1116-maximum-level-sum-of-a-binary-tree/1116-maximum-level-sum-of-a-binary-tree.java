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
    public int maxLevelSum(TreeNode root) {
        Queue<TreeNode> Q = new LinkedList<>();
        Q.offer(root);
        int max = Integer.MIN_VALUE;
        int level = 1;
        int ans = 0;
        while(!Q.isEmpty()) {
            int size = Q.size();
            int sum = 0;
            for(int i = 0; i < size; i++) {
                TreeNode temp = Q.poll();
                sum += temp.val;    
                if(temp.left != null) {
                    Q.offer(temp.left);
                }
                if(temp.right != null) {
                    Q.offer(temp.right);
                }
            }
            if(sum > max) {
                max = sum;
                ans = level;
            }
            level++;
        }
        return ans;
    }
}