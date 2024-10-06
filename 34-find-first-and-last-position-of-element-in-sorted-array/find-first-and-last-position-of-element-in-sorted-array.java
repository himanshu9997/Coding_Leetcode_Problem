class Solution {
    public int[] searchRange(int[] nums, int target) {
        int[] result = {-1, -1};

        result[0] = binarySearch(nums, target, true);

        result[1] = binarySearch(nums, target, false);

        return result;
    }

    private int binarySearch(int[] nums, int target, boolean firstOccurrence) {
        int index = -1;
        int left = 0;
        int right = nums.length - 1;

        while (left <= right) {
            int mid = left + (right - left) / 2;

            if (nums[mid] == target) {
                index = mid;
                if (firstOccurrence) {
                    right = mid - 1; 
                } else {
                    left = mid + 1; 
                }
            } else if (nums[mid] < target) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }

        return index;
    }
}
