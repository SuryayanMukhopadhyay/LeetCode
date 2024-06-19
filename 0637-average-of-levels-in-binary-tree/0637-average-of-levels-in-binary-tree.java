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
    public List<Double> averageOfLevels(TreeNode root) {
        Queue<TreeNode> Q = new LinkedList<>();
        List<Double> list = new ArrayList<>();
        int n = 0;
        double avg = 0.00;
        Q.offer(root);
        while(!Q.isEmpty()) {
            avg = 0.00;
            n = Q.size();
            for(int i = 0; i < n; i++) {
                TreeNode temp = Q.poll();
                avg += (double)temp.val;
                if(temp.left != null) Q.offer(temp.left);
                if(temp.right != null) Q.offer(temp.right);
            }
            avg/=(double)n;
            list.add(avg);
        }
        return list;
    }
}