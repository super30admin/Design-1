/*
 * Time Complexity - O(log m + log n)
 * Space Complexity - O(1) 
 * Approach - It is clear from description that the entire matrix is sorted array
 * if we traverse left to right from one row to another.
 * 			  Solution - perform binary search on the first column to get the row
 * 						 in which the target could potentially be present.
 * 						 Perform binary search on the identifed row to check if 
 * 						 the target is present in the matrix or not.				
 */
package com.sivakami.leetcode.solutions;

public class Search2dMatrix {

    public boolean searchMatrix(int[][] matrix, int target) {
    	
        if (matrix.length  == 0 || matrix[0].length == 0)
            return false;
        
        int row = binSearch(matrix, target);
        if (row == -1)    
            return false;
        
        int col = binSearchCol(matrix, target, row);
        return col != -1;
    }
    
    //search first column. row wise search
    public int binSearch(int [][]matrix, int target) {
    	
        int l = 0;
        int h = matrix.length;
        while(l <= h && h >= 0 && l < matrix.length) {
            int m = (h + l) / 2;  
            if (matrix[m][0] <= target && matrix[m][matrix[m].length - 1] >= target)
                return m;
            if (matrix[m][0] > target)
                h = m - 1;
            else
                l = m + 1;
        }
        return -1;
    }
    
    //Search rth row. Column wise search.
    public int binSearchCol(int [][]matrix, int target, int r) {
    	
        int l = 0;
        int h = matrix[0].length;
        while(l <= h && h >= 0 && l < matrix[r].length) {
            int m = (h + l) / 2;  
            if (matrix[r][m] == target)
                return m;
            if (matrix[r][m] > target)
                h = --m;
            else
                l = ++m;
        }
        return -1;
    }
    
    public static void main() {
    	
    	int[][] matrix = {{1,3,5,7},{10,11,16,20},{23,30,34,60}};
    	int target = 13;
    	Search2dMatrix searchObj = new Search2dMatrix();
    	boolean result = searchObj.searchMatrix(matrix, target);
    	System.out.println(result);
    }
}