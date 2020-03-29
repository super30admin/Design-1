class Solution {
    public int minCost(int[][] costs) {
        
        // Edge case
        
        if (costs == null || costs.length == 0)
            return 0;
        
        int n = costs.length;
        
        //Construct a dp matrix
        int[][] dp = new int[n][3];
        
        // Fill the first row
        for (int i = 0; i < 3; i++){
            dp[0][i] = costs[0][i];
        }
        
        // Start filling the dp matrix from the 2nd row onwards
        
        for (int i = 1; i < n; i++){
            
            //Choose RED
            dp[i][0] = costs[i][0] + Math.min(dp[i-1][1],dp[i-1][2]);
            
            //Choose GREEN
            dp[i][1] = costs[i][1] + Math.min(dp[i-1][0],dp[i-1][2]);
            
            //Choose RED
            dp[i][2] = costs[i][2] + Math.min(dp[i-1][0],dp[i-1][1]);
        
        }
        
        return Math.min(dp[n-1][0], Math.min(dp[n-1][1],dp[n-1][2]));
        
    }
}