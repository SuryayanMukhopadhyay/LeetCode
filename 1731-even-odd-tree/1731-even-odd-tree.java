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
    public boolean isEvenOddTree(TreeNode root) {
        Queue<TreeNode> Q = new LinkedList<>();
        Q.offer(root);
        int level = 0;
        while(!Q.isEmpty()) {
            int size = Q.size();
            int val = 0;
            if(level % 2 == 0) {
                val = Integer.MIN_VALUE;
            }
            else {
                val = Integer.MAX_VALUE;
            }
            for(int i = 0; i < size; i++) {
                TreeNode temp = Q.poll();
                if(level % 2 == 0) {
                    if(temp.val <= val || temp.val % 2 == 0) {
                        return false;
                    }
                    val = temp.val;
                }
                if(level % 2 != 0) {
                    if(temp.val >= val || temp.val % 2 != 0) {
                        return false;
                    }
                    val = temp.val;
                }
                if(temp.left != null) {
                    Q.offer(temp.left);
                }
                if(temp.right != null) {
                    Q.offer(temp.right);
                }
            }
            level++;
        }
        return true;
    }
}