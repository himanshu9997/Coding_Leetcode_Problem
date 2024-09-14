class Solution {
    public int countHillValley(int[] nums) {
        int n = nums.length;
        int count = 0;

        for(int i = 1;i < n-1;i++) {
            if(nums[i] == nums[i - 1]) {
                continue;
            }

            int leftHills = nums[i - 1];
            int rightHills = nums[i + 1];

            int j = i + 1;
            while(j < n && nums[j] == nums[i]) {
                j++;
            }
            if(j < n) { 
                rightHills = nums[j];
            }

            if((nums[i] > leftHills && nums[i] > rightHills) || (nums[i] < leftHills && nums[i] < rightHills)) {
                count++;
            }
        }
        return count;
    }
}