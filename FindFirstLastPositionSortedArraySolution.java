class FindFirstLastPositionSortedArraySolution {
    public int[] searchRange(int[] nums, int target) {
        int n = nums.length;
        int low = 0;
        int high = n - 1;
        if (n == 0 || nums == null || target < nums[low] || target > nums[high]) {
            return new int[] { -1, -1 };
        }
        int first = binarySearchFirst(nums, target);
        if (first == -1) {
            return new int[] { -1, -1 };
        }
        int last = binarySearchLast(nums, target);
        return new int[] { first, last };
    }

    private int binarySearchFirst(int[] nums, int target) {
        int low = 0;
        int high = nums.length - 1;
        while (low <= high) {
            int mid = low + (high - low) / 2;
            int midValue = nums[mid];
            if (midValue == target) {
                if (mid == 0 || (midValue != nums[mid - 1])) {
                    return mid;
                }
                high = mid - 1;
            } else if (midValue < target) {
                // look right
                low = mid + 1;
            } else {
                // look left
                high = mid - 1;
            }
        }
        return -1;
    }

    private int binarySearchLast(int[] nums, int target) {
        int low = 0;
        int high = nums.length - 1;
        while (low <= high) {
            int mid = low + (high - low) / 2;
            int midValue = nums[mid];
            if (midValue == target) {
                if ((mid == high) || (midValue != nums[mid + 1])) {
                    return mid;
                }
                low = mid + 1;
            } else if (midValue < target) {
                // look right
                low = mid + 1;
            } else {
                // look left
                high = mid - 1;
            }
        }
        return -1;
    }

}