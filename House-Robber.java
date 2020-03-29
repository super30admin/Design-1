class Solution {
    public int rob(int[] nums) {
        
        // Edge Case
        if (nums == null || nums.length == 0)
            return 0;
        
        int R = 0;
        int DR = 0;
        
        for (int i = 0; i < nums.length; i++){
            
            int temp = R;
            R = nums[i] + DR;
            DR = Math.max(temp,DR);
        }
        
        return Math.max(R,DR);
    }
}