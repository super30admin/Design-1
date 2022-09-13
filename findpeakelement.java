// tc - o(logn)
// sc - o(n)
// ran in lc - yes


class Solution {
    public int findPeakElement(int[] nums) {
        if(nums == null || nums.length == 0){
            return -1;
        }

        int n = nums.length;
        int low =0;
        int high = n-1;

        while(low <= high){
            int mid = low + (high - low)/2;
            if((mid == low || nums[mid] > nums[mid -1]) && (mid == high || nums[mid] > nums[mid + 1])){
                return mid;
            }
            else if (mid ==n || nums[mid +1] > nums[mid]){
                low = mid +1;
            }else {
                high = mid -1;
            }
        }
        return 355454;
    }
}
