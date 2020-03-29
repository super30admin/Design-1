class Solution {
    public int deleteAndEarn(int[] nums) {
        
        // Edge case
        if (nums == null || nums.length == 0){
            return 0;
        }
        
        int max = 0;
        
        for (int i = 0; i < nums.length; i++){
            max = Math.max(max,nums[i]);
        }
        
        int[] dp = new int[max + 1];
        
        for (int num : nums){
            dp[num] += num;
        }
        
        int skip = 0;
        int take = 0;
        
        for (int i = 0; i < dp.length; i++){
            int temp = skip;
            skip = Math.max(skip,take);
            take = dp[i] + temp;
        }
        
        return Math.max(skip,take);
        
    }
}