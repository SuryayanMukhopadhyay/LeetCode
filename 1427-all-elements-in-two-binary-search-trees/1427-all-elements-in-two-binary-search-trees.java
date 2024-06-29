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
    public List<Integer> getAllElements(TreeNode root1, TreeNode root2) {
        Stack<TreeNode> st1 = new Stack<>();
        Stack<TreeNode> st2 = new Stack<>();
        
        List<Integer> res = new ArrayList<>();
        
        while(root1 != null || root2 != null || !st1.empty() || !st2.empty()){
            while(root1 != null){
                st1.push(root1);
                root1 = root1.left;
            }
            while(root2 != null){
                st2.push(root2);
                root2 = root2.left;
            }
            if(st2.empty() || (!st1.empty() && st1.peek().val <= st2.peek().val)){
                root1 = st1.pop();
                res.add(root1.val);
                root1 = root1.right;
            }
            else{
                root2 = st2.pop();
                res.add(root2.val);
                root2 = root2.right;
            }
        }
        return res;
    }
}
// class Solution {
//     public static ArrayList<Integer> getNodes(TreeNode root, ArrayList<Integer> list) {
//         Stack<TreeNode> stack = new Stack<>();
//         while(true) {
//             while(root != null) {
//                 stack.push(root);
//                 root = root.left;
//             }
//             if(stack.isEmpty()) break;
//             root = stack.pop();
//             list.add(root.val);
//             root = root.right;
//         }
//         return list;
//     }
//     public List<Integer> getAllElements(TreeNode root1, TreeNode root2) {
//         ArrayList<Integer> list1 = new ArrayList<>();
//         ArrayList<Integer> list2 = new ArrayList<>();
//         list1 = getNodes(root1, list1);
//         list2 = getNodes(root2, list2);
//         list1.addAll(list2);
//         Collections.sort(list1);
//         return list1;
//     }
// }