public class Solution {
    int max = Integer.MIN_VALUE;
    
    public int maxPathSum(TreeNode root) {
        helper(root);
        return max;
    }
    
    // helper returns the max branch 
    // plus current node's value
    int helper(TreeNode root) {
        if(root == null) return 0;
        int l = Math.max(helper(root.left), 0);
        int r = Math.max(helper(root.right), 0);
        max = Math.max(max, l + r + root.val);
        return root.val + Math.max(l, r);
    }
}