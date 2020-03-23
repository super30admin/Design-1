public int findMinInSortedArray(int[] nums) {
    // find low and high
    // find mid
    // nums[low] < nums[high] return low
    // nums[mid] < num[mid-1] && nums[mid] < nums[mid+1] return mid
    // nums[mid] > nums[high] RHS ; nums[low] > nums[mid] LHS;
    
    
    int low = 0;
    int high = nums.length - 1;
    
    while (low < high){
        int mid = low + (high - low)/2;
        
        if (mid == 0 && nums[mid] < nums[mid + 1]){
            return nums[mid];
        } 
        
        if (mid == nums.length - 1  || nums[mid] > nums[mid + 1] ){
            return nums[mid + 1];
        } 
        
        if (nums[mid] < nums[mid - 1]  && nums[mid] < nums[mid + 1] ){
            return nums[mid];
        } else if (nums[low] < nums[high]) {
            return nums[low];
        }
        else if (nums[mid] > nums[high]){
            low = mid + 1;
        } else {
            high = mid - 1;
        }
    }
    return nums[low];
}