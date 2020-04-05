class Solution {
    public int[] productExceptSelf(int[] nums) {
        
        // Edege case
        
        if (nums == null || nums.length == 0){
            return new int[0];
        }
        
        // Caculate the left Product
        
        int temp = 1;
        int runningProduct = 1;
        
        int[] result = new int[nums.length];
        
        for (int i = 0; i < nums.length; i++){
            runningProduct = runningProduct * temp;
            result[i] = runningProduct;
            temp = nums[i];
        }
        
        // Calculate the final result using original array and left product
        
        temp = 1;
        runningProduct = 1;
        
        for (int i = nums.length -1; i>=0; i--){
            runningProduct = runningProduct * temp;
            result[i] = runningProduct * result[i];
            temp = nums[i];
        }
       return result; 
    }
}