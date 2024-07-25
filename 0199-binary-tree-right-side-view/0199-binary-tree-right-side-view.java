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
    public List<Integer> rightSideView(TreeNode root) {
        Queue<TreeNode> Q = new LinkedList<>();
        Q.offer(root);
        List<Integer> list = new LinkedList<>();
        if(root == null) return list;
        while(!Q.isEmpty()) {
            int size = Q.size();
            for(int i = 0; i < size; i++) {
                TreeNode temp = Q.poll();
                if(i == size - 1) {
                    list.add(temp.val);
                }
                if(temp.left != null) {
                    Q.offer(temp.left);
                }
                if(temp.right != null) {
                    Q.offer(temp.right);
                }
            }
        }
        return list;
    }
}