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
    public static int getDeepestLevel(TreeNode root) {
        Queue<TreeNode> Q = new LinkedList<>();
        Q.offer(root);
        int level = 0;
        while(!Q.isEmpty()) {
            int size = Q.size();
            for(int i = 0; i < size; i++) {
                TreeNode temp = Q.poll();
                if(temp.left != null) Q.offer(temp.left);
                if(temp.right != null) Q.offer(temp.right);
            }
            level++;
        }
        return level;
    }
    public int deepestLeavesSum(TreeNode root) {
        if(root.left == null && root.right == null) {
            return root.val;
        }
        int level = getDeepestLevel(root);
        Queue<TreeNode> Q = new LinkedList<>();
        Q.offer(root);
        int depth = 0;
        int sum = 0;
        while(!Q.isEmpty()) {
            int size = Q.size();
            for(int i = 0; i < size; i++) {
                TreeNode temp = Q.poll();
                if(temp.left != null) Q.offer(temp.left);
                if(temp.right != null) Q.offer(temp.right);
            }
            depth++;
            if(depth == level - 1) {
                int newSize = Q.size();
                for(int i = 0; i < newSize; i++) {
                    TreeNode temp = Q.poll();
                    sum += temp.val;
                }
                break;
            }
        }
        return sum;
    }
}


// class Solution {
    
//    private int maxLevel = 0;
//     private int sum = 0;
    
//     public int deepestLeavesSum(TreeNode root) {
//         if(root == null) return 0;
//         calculateSumAtLevel(root,0);
//         return sum;
        
//     }
    
//     private void calculateSumAtLevel(TreeNode root,int level){
        
//        if(root == null) return;
//         if(level > maxLevel){
//             sum = 0;
//             maxLevel = level;
//         }
//         if(level == maxLevel){
//             sum = sum + root.val;
//         }
//         calculateSumAtLevel(root.left,level+1);
//         calculateSumAtLevel(root.right,level+1);
//     }
// }