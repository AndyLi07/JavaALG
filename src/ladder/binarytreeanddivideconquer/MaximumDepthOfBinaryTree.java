package ladder.binarytreeanddivideconquer;

public class MaximumDepthOfBinaryTree {
    /**
     * @param root: The root of binary tree.
     * @return: An integer.
     */
    public int maxDepth(TreeNode root) {
    	// divide and conquer
    	if (root == null) {
    		return 0;
    	}
    	int left = maxDepth(root.left);
    	int right = maxDepth(root.right);
    	return Math.max(left, right) + 1;
    }

    private int max;
    public int maxDepth(TreeNode root) {
    	this.max = 0;
    	// traverse method: need return void
    	max = traverse(root, 1);
    	return this.max;
    }

    private void traverse(TreeNode root, int depth) {
    	if (root == null) {
    		return;
    	}
    	if (depth > this.max) {
    		this.max = depth;
    	}
    	traverse(root.left, depth + 1);
    	traverse(root.right, depth + 1);
    }
}
