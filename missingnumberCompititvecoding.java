
// solution tc - O(logn) , sc - O(1)


public class missingnumberwithsortedarray {
    public static int missingNumber(int[] nums) {
        int low = 0;
        int high = nums.length-1;
        while(high-low > 1){
            int mid = low + (high-low)/2;
            // if these two are not equal then thats were element is missing
            if((mid - low) != ((nums[mid]) - (nums[low]))){
                high = mid;
            }else{
                low = mid;
            }
        }
        if(high-low == 1){
            return nums[low]+1;
        }
        return -1;
    }
    public static void main(String[] args) {
        int [] nums = new int[]{1,2,3,5,6,7,8};
        int [] nums1 = new int[]{-3,-2,-1,0,1,2,4};
        int [] nums2 = new int [] {-3,-1,0,1,2};
        int [] nums3 = new int [] {-53,-52,-50,-49,-48};
        int [] nums4 = new int[] {-3,-2,-1,0,1,3,4,5,6,7,8};
        System.out.println("missing number is 4 and we got"+ missingNumber(nums));
        System.out.println("missing number is 3 and we got"+ missingNumber(nums1));
        System.out.println("missing number is -2 and we got"+ missingNumber(nums2));
        System.out.println("missing number is -51 and we got"+ missingNumber(nums3));
        System.out.println("missing number is 2 and we got"+ missingNumber(nums4));
    }
}
