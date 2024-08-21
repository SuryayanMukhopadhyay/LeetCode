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
class Pair {
    TreeNode node;
    int index;
    Pair(TreeNode _node, int _index) {
        this.node = _node;
        this.index = _index;
    }
}
class Solution {
    public int widthOfBinaryTree(TreeNode root) {
        if(root == null) return 0;
        Queue<Pair> Q = new LinkedList<>();
        Q.offer(new Pair(root, 0));
        int maxWidth = Integer.MIN_VALUE;
        while(!Q.isEmpty()) {
            int size = Q.size();
            int idxMin = Q.peek().index;
            int min = 0, max = 0;
            for(int i = 0; i < size; i++) {
                TreeNode tempNode = Q.peek().node;
                int idx = Q.peek().index - idxMin;
                Q.poll();
                if(i == 0) {
                    min = idx;
                }
                if(i == size - 1) {
                    max = idx;
                }
                if(tempNode.left != null) {
                    Q.offer(new Pair(tempNode.left, (2 * idx + 1)));
                }
                if(tempNode.right != null) {
                    Q.offer(new Pair(tempNode.right, (2 * idx + 2)));
                }
            }
            maxWidth = Math.max(maxWidth, (max - min) + 1);
        }
        return maxWidth;
    }
}