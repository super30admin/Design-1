class Solution {
    public int[] searchRange(int[] nums, int target) {
        
        int left = leftBS(nums, target);
        int right = rightBS(nums,target);
        
        return new int[]{left, right};
        
    }
    
    private int leftBS(int[] nums, int target ){
        
        int low = 0;
        int high = nums.length - 1;
        
        while (low <= high){
            int mid = low + (high-low)/2;
            
            if (nums[mid] == target){
                if (mid == low || nums[mid - 1] != target){
                    return mid;
                } else {
                    high = mid - 1;
                }
            } else if (nums[mid] > target){
                high = mid -1;
            } else {
                low = mid + 1;
            }
        }
        
        return -1;
    }
    
    private int rightBS(int[] nums, int target ){
        
        int low = 0;
        int high = nums.length - 1;
        
        while (low <= high){
            int mid = low + (high-low)/2;
            
            if (nums[mid] == target){
                if (mid == high || nums[mid + 1] != target){
                    return mid;
                } else {
                    low = mid + 1;
                }
            } else if (nums[mid] > target){
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        
        return -1;
    }
}