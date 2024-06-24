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
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        Deque<TreeNode> DQ = new ArrayDeque<TreeNode>();
        List<List<Integer>> list = new LinkedList<List<Integer>>();
        int level = 0;
        if(root == null) return list;
        DQ.addLast(root);
        while(!DQ.isEmpty()) {
            int levelsize = DQ.size();
            List<Integer> templist = new LinkedList<Integer>();
            for(int i = 0; i < levelsize; i++) {
                if(level%2==0) {
                    TreeNode temp = DQ.removeFirst();
                    templist.add(temp.val);
                    if(temp.left!=null) {
                        DQ.addLast(temp.left);
                    }
                    if(temp.right!=null) {
                        DQ.addLast(temp.right);
                    }
                }
                else {
                    TreeNode temp = DQ.removeLast();
                    templist.add(temp.val);
                    if(temp.right!=null) {
                        DQ.addFirst(temp.right);
                    }
                    if(temp.left!=null) {
                        DQ.addFirst(temp.left);
                    }
                }
                if(i==levelsize - 1) {
                    level++;
                }
            }
            list.add(templist);
        }
        return list;
    }
}