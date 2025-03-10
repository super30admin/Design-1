class FindMinRotatedSortedArraySolution {
    public int findMin(int[] nums) {
        int n = nums.length;
        if (n == 0) {
            return nums[0];
        }
        int low = 0;
        int high = n - 1;
        while (low <= high) {
            if (nums[low] <= nums[high]) {// check if entire array is sorted
                return nums[low];
            }
            int mid = low + (high - low) / 2;
            int midValue = nums[mid];

            if (((mid == 0) || (midValue < nums[mid - 1])) && ((mid == high) || (midValue < nums[mid + 1]))) {
                return midValue;
            }

            if (nums[low] <= midValue) {// sorted
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        return 1;// never reach
    }
}