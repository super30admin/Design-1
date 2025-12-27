/**
 * I am using binary search on this rotated sorted array
 * Mid formula makes sure that integer over flow is not happening
 * Checking if the left side of the array is sorted or not, if yes i am checking if the target is in the range, if yes high is moving to left, else low is moving to right;
 * Else if the right side is sorted check if the target is in range and move the low and high accordingly.
 */
var search = function(nums, target) {
    let low = 0, high = nums.length-1;
    while(low <= high) {
        const mid = Math.floor(
            low + (high - low)/2
        );
        if(nums[mid] === target) return mid;
        else if(nums[mid] >= nums[low]) {
          nums[low] <= target && target < nums[mid] ? high = mid-1 : low = mid + 1;
        } else nums[mid] < target && target <= nums[high] ? low = mid + 1 :  high = mid-1;
    }
    return -1;
};