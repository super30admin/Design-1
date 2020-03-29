class Solution {
    public int findMaxLength(int[] nums) {
        
        // Edge case
        
        if (nums == null || nums.length == 0){
            return 0;
        }
        
        // Key - runningCount Value - Index
        HashMap<Integer,Integer> hashMap = new HashMap<>();
        
        int max = 0;
        int runningSum = 0;
        
        // One previous element before starting of array
        hashMap.put(0,-1);
        
        for (int i = 0; i < nums.length; i++){
            
            if (nums[i] == 0){
                runningSum -= 1;
            } else {
                runningSum += 1;
            }
            
            if (hashMap.containsKey(runningSum)){
                max = Math.max(max, i - (hashMap.get(runningSum)));
            } else {
                hashMap.put(runningSum, i);
            }
            
        }
        
        return max;
    }
}