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
    public int amountOfTime(TreeNode root, int start) {
        HashMap<TreeNode, TreeNode> parent = new HashMap<>();
        Queue<TreeNode> Q = new LinkedList<>();
        Q.offer(root);
        parent.put(root, null);
        TreeNode startNode = null;
        while(!Q.isEmpty()) {
            int size = Q.size();
            for(int i = 0; i < size; i++) {
                TreeNode temp = Q.poll();
                if(temp.val == start) {
                    startNode = temp;
                }
                if(temp.left != null) {
                    parent.put(temp.left, temp);
                    Q.offer(temp.left);
                }
                if(temp.right != null) {
                    parent.put(temp.right, temp);
                    Q.offer(temp.right);
                }
            }
        }
        int minutes = -1;
        Q.offer(startNode);
        HashMap<TreeNode, Boolean> infected = new HashMap<>();
        infected.put(startNode, true);
        while(!Q.isEmpty()) {
            int size = Q.size();
            for(int i = 0; i < size; i++) {
                TreeNode temp = Q.poll();
                if(temp.left != null && !infected.containsKey(temp.left)) {
                    Q.offer(temp.left);
                    infected.put(temp.left, true);
                }
                if(temp.right != null && !infected.containsKey(temp.right)) {
                    Q.offer(temp.right);
                    infected.put(temp.right, true);
                }
                if(parent.get(temp) != null && !infected.containsKey(parent.get(temp))) {
                    Q.offer(parent.get(temp));
                    infected.put(parent.get(temp), true);
                }
            }
            minutes++;
        }
        return minutes;
    }
}