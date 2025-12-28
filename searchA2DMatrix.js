/**
 * @param {number[][]} matrix
 * @param {number} target
 * @return {boolean}
 * 
 * Intution:
 * Here we are imagining a 2d matrix as an array and performing the binary search
 * I set the left to the first index and set the right to the last index 
 * Inside the while loop,  we are deriving the row col based on two formulas, and performing the binary search.
 */
var searchMatrix = function(matrix, target) {
    // Set left to the first element of the array
    let left = 0; 
    const totalCols = matrix[0].length;
    // Set right to the last element of the array
    let right = (matrix.length * matrix[0].length) - 1;

    while(left <= right) {
        const mid = Math.floor(left + (right-left)/2);
        // formula to find the row number
        const row = Math.floor(mid / totalCols);
        // formula to find the col number
        const col = Math.floor(mid % totalCols);
        const currVal = matrix[row][col];
        if(currVal === target) {
            // return true if element is found
            return true;
        }else if(currVal < target) {
            left = mid + 1;
        }else {
            right = mid - 1;
        }
    }
    // return false if nothing is found
    return false;
};