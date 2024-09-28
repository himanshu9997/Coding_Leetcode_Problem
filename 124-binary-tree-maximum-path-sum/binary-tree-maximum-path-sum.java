class Solution {
     int max= Integer.MIN_VALUE;
    public int maxPathSum(TreeNode root) {

        if(root==null)
        return 0;

        sum(root);
        return max;
    
    }

    public int sum(TreeNode root)
    {
        if(root==null)
        return 0;
        int lsum= Math.max(sum(root.left),0);
        int rsum= Math.max(sum(root.right),0);
        
        int self= root.val+rsum+lsum; 
        max= Math.max(max,self);
        return Math.max(rsum,lsum)+root.val;
    }
}