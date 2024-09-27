public class Solution {
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        if (inorder == null || postorder == null || inorder.length == 0 || postorder.length == 0) {
            return null;
        }

        return buildTreeHelper(inorder, postorder, 0, inorder.length - 1, 0, postorder.length - 1);
    }

    private TreeNode buildTreeHelper(int[] inorder, int[] postorder, int inStart, int inEnd, int postStart, int postEnd) {
        if (inStart > inEnd || postStart > postEnd) {
            return null;
        }

        int rootVal = postorder[postEnd];
        TreeNode root = new TreeNode(rootVal);

        int rootIndexInorder = findRootIndexInorder(inorder, rootVal, inStart, inEnd);

        int rightSubtreeSize = inEnd - rootIndexInorder;

        root.left = buildTreeHelper(inorder, postorder, inStart, rootIndexInorder - 1, postStart, postEnd - rightSubtreeSize - 1);
        root.right = buildTreeHelper(inorder, postorder, rootIndexInorder + 1, inEnd, postEnd - rightSubtreeSize, postEnd - 1);

        return root;
    }

    private int findRootIndexInorder(int[] inorder, int rootVal, int start, int end) {
        for (int i = start; i <= end; i++) {
            if (inorder[i] == rootVal) {
                return i;
            }
        }
        return -1; 
    }
}
