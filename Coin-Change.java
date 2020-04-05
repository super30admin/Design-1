class Solution {
    public int coinChange(int[] coins, int amount) {
        
        // Edge case
        
        if (coins == null && coins.length == 0){
            return -1;
        }
        
        // Intialize dp matrix
        
        int[][] dp = new int[coins.length + 1][amount + 1];
        
        // Fill up the 1st column
        for (int i = 0; i < dp.length; i++){
            dp[i][0] = 0;
        }
        
        // Fill up the 1st row
        for (int j = 1; j < dp[0].length; j++){
            dp[0][j] = 99999;
        }
        
        // Processing the zero case and choose case
        
        for (int i = 1; i < dp.length; i++){
            for (int j = 1; j < dp[0].length; j++){
                
                // zero case
                if (j < coins[i-1]){
                    dp[i][j] = dp[i-1][j];
                } else { //choose case
                    dp[i][j] = Math.min(dp[i-1][j], dp[i][j-coins[i-1]] + 1);
                } 
            }
        }
        
        int result = dp[dp.length - 1][dp[0].length - 1]; // Search the last array i,j
        
        if (result >= 99999){
            return -1;
        } else {
            return result;
        }
    }
}