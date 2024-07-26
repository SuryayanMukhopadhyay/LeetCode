/**
 * Definition for a binary tree node.
 * public class TreeNode {
 * int val;
 * TreeNode left;
 * TreeNode right;
 * TreeNode(int x) { val = x; }
 * }
 */
public class Codec {

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        if (root == null)
            return "";
        StringBuilder str = new StringBuilder();
        Queue<TreeNode> Q = new LinkedList<>();
        Q.offer(root);
        while (!Q.isEmpty()) {
            TreeNode temp = Q.poll();
            if (temp == null) {
                str.append("null ");
                continue;
            }
            str.append(temp.val + " ");
            Q.offer(temp.left);
            Q.offer(temp.right);
        }
        return str.toString();
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        if (data.equals(""))
            return null;
        String[] values = data.split(" ");
        Queue<TreeNode> Q = new LinkedList<>();
        TreeNode root = new TreeNode(Integer.parseInt(values[0]));
        Q.offer(root);
        int size = values.length;
        for (int i = 1; i < size; i++) {
            TreeNode temp = Q.poll();
            if (!values[i].equals("null")) {
                TreeNode leftNode = new TreeNode(Integer.parseInt(values[i]));
                temp.left = leftNode;
                Q.offer(leftNode);
            }
            if (!values[++i].equals("null")) {
                TreeNode rightNode = new TreeNode(Integer.parseInt(values[i]));
                temp.right = rightNode;
                Q.offer(rightNode);
            }
        }
        return root;
    }
}

// Your Codec object will be instantiated and called as such:
// Codec ser = new Codec();
// Codec deser = new Codec();
// String tree = ser.serialize(root);
// TreeNode ans = deser.deserialize(tree);
// return ans;