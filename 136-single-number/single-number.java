class Solution {
    public int singleNumber(int[] nums) {
        int result = 0;

        for (int num : nums) {
            result ^= num;
        }

        return result;
    }
}

public class Main {
    public static void main(String[] args) {
        Solution solution = new Solution();

        int[] nums1 = {2, 2, 1};
        int output1 = solution.singleNumber(nums1);
        System.out.println("Example 1: " + output1);  

        int[] nums2 = {4, 1, 2, 1, 2};
        int output2 = solution.singleNumber(nums2);
        System.out.println("Example 2: " + output2); 

        int[] nums3 = {1};
        int output3 = solution.singleNumber(nums3);
        System.out.println("Example 3: " + output3); 
    }
}
