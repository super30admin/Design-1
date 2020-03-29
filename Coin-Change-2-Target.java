class Solution {
    public int change(int amount, int[] coins) {
        
        // Edge case
        if (coins == null)
            return 0;
        
        int n = coins.length + 1;
        int m = amount + 1;
        
        // Intialize dp array
        
        int[][] dp = new int[n][m];
        
        // Fill (0,0)
        
        dp[0][0] = 1;
        
        // Remaining of 1st row has become default 0
        
        for (int i = 1; i < n; i++){
            for (int j = 0; j < m; j++){
                int coin = coins[i - 1];
                
                if (j < coin){
                    dp[i][j] = dp[i-1][j];
                } else {
                    dp[i][j] = dp[i-1][j] + dp[i][j-coin];
                }
            }
        }
        
        return dp[n-1][m-1];
    }
}