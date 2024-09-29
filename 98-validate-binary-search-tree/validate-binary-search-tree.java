public class Solution {
    public boolean isValidBST(TreeNode root) {
        return isValidBST(root, null, null);
    }

    private boolean isValidBST(TreeNode node, Integer lowerLimit, Integer upperLimit) {
        if (node == null) {
            return true;
        }

        int val = node.val;

        if ((lowerLimit != null && val <= lowerLimit) || (upperLimit != null && val >= upperLimit)) {
            return false;
        }

        return isValidBST(node.left, lowerLimit, val) && isValidBST(node.right, val, upperLimit);
    }

}
