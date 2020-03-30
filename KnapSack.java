class Solution {
    public static int knapSack(int[] value, int[] weights, int capacity) {

        int[][] dp = new int[value.length + 1][capacity + 1];

        // 1st column all 0
        for (int i = 0; i < dp.length; i++){
            dp[i][0] = 0;
        }

        // 1st row all 0
        for(int j = 0; j < dp[0].length; j++){
            dp[0][j]=0;
        }

        for (int i = 0; i < dp.length; i++){
            for (int j = 0; j <dp[0].length; j++){

                // Not choose and keep the prev selection

                dp[i][j]= dp[i-1][j];

                // Modify the above in case weight is greater than the weight of prev

                if (j >= weights[i - 1]){
                    // Take the max from the no selection value and newly computed value

                    dp[i][j]= Math.max(dp[i][j], value[i-1]+ dp[i-1][j-weights[i-1]]);
                }

            }
            //pick the last element in the matrix
            return dp[value.length][capacity];
        }
    }
}