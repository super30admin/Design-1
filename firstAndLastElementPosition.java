// tc - o(logN)
// sc - 0 (n)
// ran in leetcode -yes

class Solution {
    public int[] searchRange(int[] nums, int target) {
        if(nums == null || nums.length == 0){
            return new int[] {-1,-1};
        }

        if(target < nums[0] || target > nums[nums.length -1]){
            return new int[] {-1,-1};
        }

        int firstOccurense = binarySearchFirst(nums,target);
        int lastOccurense = binarySearchLast(nums,target, firstOccurense);

        return new int[] {firstOccurense,lastOccurense};
    }

    private int binarySearchFirst(int[] nums, int target){
        int low =0;
        int high = nums.length-1;

        while(low <= high){
            int mid = low + (high-low) / 2;

            if(nums[mid] == target){
                if(mid ==0 || nums[mid -1] < nums[mid]){
                    return mid;
                }
                high = mid -1;
            } else if (target < nums [mid]){
                high = mid -1;
            }
            else{
                low = mid +1;
            }
        }
        return -1;
    }

    private int binarySearchLast(int[] nums, int target, int bound){
        int low = bound;
        int high = nums.length -1;
        while(low <= high){
            int mid = low + (high-low) / 2;

            if(nums[mid] == target){
                if(mid == nums.length-1 || nums[mid + 1] > nums[mid]){
                    return mid;
                }
                low = mid + 1;
            } else if (target < nums[mid]){
                high = mid - 1;
            } else{
                low = mid +1;
            }
        }
        return -1;
    }
}
