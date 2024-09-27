public class Solution {
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        return buildTreeHelper(preorder, inorder, 0, 0, inorder.length - 1);
    }

    private TreeNode buildTreeHelper(int[] preorder, int[] inorder, int preIndex, int inStart, int inEnd) {
        if (preIndex >= preorder.length || inStart > inEnd) {
            return null;
        }

        TreeNode root = new TreeNode(preorder[preIndex]);

        int inIndex = 0;
        for (int i = inStart; i <= inEnd; i++) {
            if (inorder[i] == root.val) {
                inIndex = i;
                break;
            }
        }

        root.left = buildTreeHelper(preorder, inorder, preIndex + 1, inStart, inIndex - 1);
        root.right = buildTreeHelper(preorder, inorder, preIndex + inIndex - inStart + 1, inIndex + 1, inEnd);

        return root;
    }

    private void inorderTraversal(TreeNode root) {
        if (root != null) {
            inorderTraversal(root.left);
            System.out.print(root.val + " ");
            inorderTraversal(root.right);
        }
    }

    public static void main(String[] args) {

        Solution solution = new Solution();

        int[] preorder1 = {3, 9, 20, 15, 7};
        int[] inorder1 = {9, 3, 15, 20, 7};
        TreeNode result1 = solution.buildTree(preorder1, inorder1);
        solution.inorderTraversal(result1);

        System.out.println();
        int[] preorder2 = {-1};
        int[] inorder2 = {-1};
        TreeNode result2 = solution.buildTree(preorder2, inorder2);
        solution.inorderTraversal(result2); 
    }
}
