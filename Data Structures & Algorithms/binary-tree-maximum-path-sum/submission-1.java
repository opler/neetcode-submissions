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
    public int maxPathSum(TreeNode root) {
        int[] max = new int[]{root.val};
        dfs(root, max);
        return max[0];
    }

    public int dfs(TreeNode root, int[] max) {
        if (root == null) return 0;

        int leftMaxSum = Math.max(dfs(root.left, max), 0);
        int rightMaxSum = Math.max(dfs(root.right, max), 0);

        int currSum = leftMaxSum+rightMaxSum+root.val;
        max[0] = Math.max(max[0], currSum);
        return Math.max(leftMaxSum, rightMaxSum) + root.val;
    }
}
