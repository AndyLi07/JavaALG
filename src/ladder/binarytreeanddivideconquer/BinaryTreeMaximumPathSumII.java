package ladder.binarytreeanddivideconquer;

public class BinaryTreeMaximumPathSumII {
    /**
     * @param root the root of binary tree.
     * @return an integer
     */
    public int maxPathSum2(TreeNode root) {
        // Write your code here
        if (root == null) {
            return Integer.MIN_VALUE;
        }
        int left = maxPathSum2(root.left);
        int right = maxPathSum2(root.right);
        // root to leaf
        // return root.val + Math.max(left, right);
        
        // root to any node
        return root.val + Math.max(0, Math.max(left, right));
    }
}
