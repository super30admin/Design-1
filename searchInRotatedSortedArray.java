// tc - o(logn)
//sc - o(1)
//ran in leetcode : yes


class Solution {
  public int search(int[] nums, int target) {
    int start = 0, end = nums.length - 1;
    while (start <= end) {
      int mid = start + (end-start)  / 2;
    // int mid = (start + end) / 2;
      if (nums[mid] == target) return mid;
      else if (nums[mid] >= nums[start]) { // rotation not happend
          // check in first half
        if (target >= nums[start] && target < nums[mid]) end = mid - 1;
        else start = mid + 1;
      }
      else { // rotation happend
          // check in second half
        if (target <= nums[end] && target > nums[mid]) start = mid + 1;
        else end = mid - 1;
      }
    }
    return -1;
  }
}
