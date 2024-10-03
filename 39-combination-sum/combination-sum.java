class Solution {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> result = new ArrayList<>();
        Arrays.sort(candidates); 
        backtrack(result, new ArrayList<>(), candidates, target, 0);
        return result;
    }

    private void backtrack(List<List<Integer>> result, List<Integer> currentList, int[] candidates, int target, int start) {
        if (target < 0) {
            return; 
        } else if (target == 0) {
            result.add(new ArrayList<>(currentList)); 
        } else {
            for (int i = start; i < candidates.length; i++) {
                currentList.add(candidates[i]); 
                backtrack(result, currentList, candidates, target - candidates[i], i); 
                currentList.remove(currentList.size() - 1); 
            }
        }
    }
}