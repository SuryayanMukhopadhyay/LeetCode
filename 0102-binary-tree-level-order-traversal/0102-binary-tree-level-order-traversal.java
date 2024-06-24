/**
 * Definition for a binary tree node.
 * public class TreeNode {
 * int val;
 * TreeNode left;
 * TreeNode right;
 * TreeNode() {}
 * TreeNode(int val) { this.val = val; }
 * TreeNode(int val, TreeNode left, TreeNode right) {
 * this.val = val;
 * this.left = left;
 * this.right = right;
 * }
 * }
 */
class Solution {
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> list = new LinkedList<List<Integer>>();
        Queue<TreeNode> Q = new LinkedList<TreeNode>();
        if (root == null)
            return list;
        Q.offer(root);
        while(!Q.isEmpty()){
            int levelsize = Q.size();
            List<Integer> templist = new LinkedList<Integer>();
            for(int i = 0; i < levelsize; i++) {
                TreeNode temp = Q.poll();
                templist.add(temp.val);
                if(temp.left!=null){
                    Q.offer(temp.left);
                }
                if(temp.right!=null){
                    Q.offer(temp.right);
                }
            }
            list.add(templist);
        }
        return list;

    }
}