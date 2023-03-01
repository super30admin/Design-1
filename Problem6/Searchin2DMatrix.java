package Problem6;

public class Searchin2DMatrix {

    public boolean searchMatrix(int[][] matrix, int target) {
        int row=0;
        int col=matrix.length-1;
        while(row<= matrix.length-1 && col>=0){
            if(matrix[row][col]==target){
                return true;
            }
            if(matrix[row][col] < target){
                row++;
            }
            else{
                col--;
            }


        }

        return false;
    }
}
