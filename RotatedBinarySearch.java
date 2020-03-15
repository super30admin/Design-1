
public class RotatedBinarySearch {
	
	public static int rotatedBinarySearch(int[] nums, int target){
		int low = 0;
		int high = nums.length - 1;
		
		while (low <= high){
			int mid = (high + low)/2;
			
			if (target == nums[mid]){
				return mid;
			}
			
			if (nums[low] <= nums[mid]){
				if (nums[low] <= target && target <= nums[mid]){
					high = mid -1;
				} else {
					low = mid + 1;
				}
			} else {
				if (target >= nums[mid] && target <= nums[high]){
					low = mid + 1;
				} else {
					high = mid -1;
				}
			}
		}
		
		return -1;
	}
	
	public static void main(String[] args){
		int nums[] = {4,5,6,1,2,3};
		int pos = RotatedBinarySearch.rotatedBinarySearch(nums,9);
		
		System.out.println(pos);
	}

}
