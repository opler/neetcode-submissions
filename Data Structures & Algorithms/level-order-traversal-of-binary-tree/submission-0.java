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
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> output = new ArrayList<>();
        Deque<TreeNode> q = new ArrayDeque<>();

        if (root != null) {
            q.add(root);
        }

        while (!q.isEmpty()) {
            List<Integer> levelList = new ArrayList<>();
            int levels = q.size();
            for (int i = 0; i < levels; i++) {
                TreeNode node = q.poll();
                levelList.add(node.val);
                if (node.left != null) {
                    q.add(node.left);
                }
                if (node.right != null) {
                    q.add(node.right);
                }
            }
            output.add(levelList);
        }
        return output;
    }
}
