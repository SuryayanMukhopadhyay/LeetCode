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
    public long kthLargestLevelSum(TreeNode root, int k) {
        Queue<TreeNode> Q = new LinkedList<>();
        PriorityQueue<Long> PQ = new PriorityQueue<>((x, y) -> Long.compare(y, x));
        Q.offer(root);
        while(!Q.isEmpty()) {
            int size = Q.size();
            long sum = 0;
            for(int i = 0; i < size; i++) {
                TreeNode temp = Q.poll();
                sum += (long)temp.val;
                if(temp.left != null) {
                    Q.offer(temp.left);
                }
                if(temp.right != null) {
                    Q.offer(temp.right);
                }
            }
            PQ.add(sum);
        }
        while(!PQ.isEmpty()) {
            long temp = PQ.poll();
            k--;
            if(k == 0) {
                return temp;
            }
        }
        return -1;
    }
}