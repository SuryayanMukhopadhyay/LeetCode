/**
 * Definition for a binary tree node.
 * public class TreeNode {
 * int val;
 * TreeNode left;
 * TreeNode right;
 * TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    public static void bfs(TreeNode root, HashMap<TreeNode, TreeNode> map) {
        Queue<TreeNode> Q = new LinkedList<>();
        Q.offer(root);
        while (!Q.isEmpty()) {
            TreeNode temp = Q.poll();
            if (temp.left != null) {
                Q.offer(temp.left);
                map.put(temp.left, temp);
            }
            if (temp.right != null) {
                Q.offer(temp.right);
                map.put(temp.right, temp);
            }
        }
    }

    public List<Integer> distanceK(TreeNode root, TreeNode target, int k) {
        Queue<TreeNode> Q = new LinkedList<>();
        HashMap<TreeNode, TreeNode> map = new HashMap<>();
        HashMap<TreeNode, Boolean> visited = new HashMap<>();
        List<Integer> list = new ArrayList<>();
        bfs(root, map);
        int distance = 0;
        Q.offer(target);
        visited.put(target, true);
        while (!Q.isEmpty()) {
            int size = Q.size();
            if (distance == k)
                break;
            distance++;
            for (int i = 0; i < size; i++) {
                TreeNode temp = Q.poll();
                if (temp.left != null && visited.get(temp.left) == null) {
                    Q.offer(temp.left);
                    visited.put(temp.left, true);
                }
                if (temp.right != null && visited.get(temp.right) == null) {
                    Q.offer(temp.right);
                    visited.put(temp.right, true);
                }
                if (map.get(temp) != null && visited.get(map.get(temp)) == null) {
                    Q.offer(map.get(temp));
                    visited.put(map.get(temp), true);
                }
            }
        }
        while (!Q.isEmpty()) {
            TreeNode temp = Q.poll();
            list.add(temp.val);
        }
        return list;
    }
}