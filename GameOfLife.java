class Solution {
    public void gameOfLife(int[][] board) {
        
        //Edge case
        
        if (board == null || board.length == 0){
            return;
        }
        
        // Length of row and column of matrix
        int n = board.length;
        int m = board[0].length;
        
        // 5 -: prev alive now dead
        //3 -: prev dead now alive
        
        
        for (int i = 0; i < n; i++){
            for (int j = 0; j < m; j++){
                
                int countLive = countLive(board,i,j,n,m);
                
                // Check live case <2 or >3- 0
                // ==2 || ==3 - remains 1 - no need to check
                
                if (board[i][j] == 1 && (countLive < 2 || countLive > 3)){
                    board[i][j] = 5;
                }
                
                // Check dead case ==3 -> 1
               
                else if (board[i][j] == 0 && countLive == 3){
                    board[i][j] = 3;
                }
            }
        }
        
        for (int i = 0; i < n; i++){
            for (int j = 0; j < m; j++){
               if (board[i][j] == 5){
                   board[i][j] = 0;
               }
               else if (board[i][j] == 3){
                   board[i][j] = 1;
               }  
            }
        }
    }
    
    private int countLive (int[][] board, int i, int j, int n, int m){
        
        int[][] dirs = new int[][]{{0,1},{1,0},{0,-1},{-1,0},{1,1},{-1,1},{-1,-1},{1,-1}};
        int count = 0;
        
        for(int[] direction: dirs){
            int r = i + direction[0];
            int c = j + direction[1];
            
            if ( r >= 0 && r < n && c>=0 && c < m && (board[r][c] == 1 || board[r][c]==5)){
                count +=1;
            }
        }
        return count;
    }
}