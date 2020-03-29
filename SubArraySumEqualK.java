class Solution {
    public int subarraySum(int[] nums, int k) {
        
        //Edge case
        
        if (nums == null || nums.length == 0)
            return 0;
        
        // Key - runningSum Value - Count
        HashMap<Integer, Integer> hashMap = new HashMap<>();
        
        int retVal = 0;
        int runningSum = 0;
        
        hashMap.put(0,1);
        
        for (int i = 0; i < nums.length; i++ ){
            runningSum += nums[i];
            
            if (hashMap.containsKey(runningSum-k)){
                retVal += hashMap.get(runningSum - k);
            }
            
            if (hashMap.containsKey(runningSum)){
                hashMap.put(runningSum, hashMap.get(runningSum) +1);
            } else {
                hashMap.put(runningSum,1);
            }
            
        }
        
        return retVal;
        
    }
}