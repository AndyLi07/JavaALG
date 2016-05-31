package ladder.binarytreeanddivideconquer;

public class LowestCommonAncestor {
    /**
     * @param root: The root of the binary search tree.
     * @param A and B: two nodes in a Binary.
     * @return: Return the least common ancestor(LCA) of the two nodes.
     */
    
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode A, TreeNode B) {
    	// 以root为根的二叉树里找A和B的LCA
    	// 如果只碰到A or B之一，则返回该node
    	// 如果都没有 返回null
    	if (root == null || root == A || root == B) {
            return root;
        }
        TreeNode left = lowestCommonAncestor(root.left, A, B);
        TreeNode right = lowestCommonAncestor(root.right, A, B);
        if (left != null && right != null) {
            return root;
        }
        if (left != null) {
            return left;
        }
        if (right != null) {
            return right;
        }
        return null;
    }
}
