class Solution {
    private int count = 0;  
    private int result = -1; 

    public int kthSmallest(TreeNode root, int k) {
        inorderTraversal(root, k);
        return result;
    }

    private void inorderTraversal(TreeNode node, int k) {
        if (node == null) {
            return;
        }

        inorderTraversal(node.left, k);
        
        count++;
        
        if (count == k) {
            result = node.val;
            return;
        }

        inorderTraversal(node.right, k);
    }
}
