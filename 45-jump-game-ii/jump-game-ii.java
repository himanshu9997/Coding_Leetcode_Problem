public class Solution {
    public int jump(int[] nums) {
        int n = nums.length;
        if (n == 1) {
            return 0;
        }

        int jumps = 0;
        int currentMaxReach = 0;
        int nextMaxReach = 0;

        for (int i = 0; i < n - 1; i++) {
            nextMaxReach = Math.max(nextMaxReach, i + nums[i]);

            if (i == currentMaxReach) {
                jumps++;
                currentMaxReach = nextMaxReach;
            }
        }

        return jumps;
    }


}
