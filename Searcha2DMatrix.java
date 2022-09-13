// tc - O(logN)
// sc = O(1)
// ram in leetcode - yes

class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int m = matrix.length;
        if(m == 0){
            return false;
        }
        int n = matrix[0].length;
        int start =0, end = m * n -1;
        while(start <= end){
            int mididx = (start + end) / 2;
            int  midElement = matrix[mididx/n][mididx%n];
            if (midElement == target){
                return true;
            }else {
                if(target < midElement){
                    end = mididx -1;
                }else{
                    start = mididx +1;
                }
            }
        }
        return false;
    }
}
