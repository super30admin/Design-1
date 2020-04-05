class Solution {
    public int minFallingPathSum(int[][] A) {
        
        // Edge case
        
        if (A == null || A.length == 0){
            return 0;
        }
        
        int n = A.length;
        int m = A[0].length;
        
        for (int i = 1; i < n; i++){
            for (int j = 0; j < m; j++){
                
                if (j == 0){ // 1st column
                    A[i][j] = A[i][j] + Math.min(A[i-1][j],A[i-1][j+1]);
                    
                }else if (j == m-1){ // last column
                    A[i][j]= A[i][j] + Math.min(A[i-1][j],A[i-1][j-1]);
                }else {// middle column
                    A[i][j]=A[i][j] + Math.min(A[i-1][j],Math.min(A[i-1][j-1],A[i-1][j+1]));
                }
            }
        }
        
        int min = Integer.MAX_VALUE;
        
        for (int j = 0; j < m; j++){
            min = Math.min(min, A[n-1][j]);
        }
        
        return min; 
        
    }
}