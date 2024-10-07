class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int n1 = nums1.length;
        int n2 = nums2.length;
        int n = n1 + n2;
        int[] nums = new int[n];
        int k=0;
        int i=0;
        int j=0;
        while(i<n1 && j<n2)
        {
            if(nums1[i] <= nums2[j])
            {
                nums[k++] = nums1[i++];
            }
            else
            {
                nums[k++] = nums2[j++];
            }
        }
        if(i < n1)
        {
            System.arraycopy(nums1, i, nums, k, n1 - i);
        }
        else
        {
            System.arraycopy(nums2, j, nums, k, n2 - j);
        }
        if(n % 2 == 1)
        {
            return nums[n/2];
        }
        else
        {
            return ((double)(nums[n/2-1]+nums[n/2])) / 2;
        }
    }
}