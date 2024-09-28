class Solution {
    List<Double> sums = new ArrayList<>();
    List<Integer> counts = new ArrayList<>();
    public List<Double> averageOfLevels(TreeNode root) {
        helper(root,0);
        List<Double> avg = new ArrayList<>();
        for(int i = 0;i<sums.size();i++){
            avg.add(sums.get(i)/counts.get(i));
        }

        return avg;
    }

    public void helper(TreeNode root,int level){
        if(root==null) return;
        if(sums.size()>level){
            Double sum=sums.get(level);
            int count=counts.get(level);
            sums.set(level,sum+((Integer)root.val).doubleValue());
            counts.set(level,count+1);
        }
        else{
            sums.add(((Integer)root.val).doubleValue());
            counts.add(1);
        }
        helper(root.left,level+1);
        helper(root.right,level+1);
    }
}