class Solution {
    public int subarraySum(int[] nums, int k) {
        if(nums == null || nums.length ==0) {
            return 0;
        }
        int count = 0;
        Map<Integer, Integer> sumMap = new HashMap<Integer, Integer>();
        int runingsum = 0;
        sumMap.put(runingsum, 1);

        for(int i=0; i < nums.length; i++){
            runingsum+=nums[i];
            if(sumMap.containsKey(runingsum-k)){
                count+=sumMap.get(runingsum-k);
            }
            sumMap.put(runingsum,sumMap.getOrDefault(runingsum, 0)+1);
        }
        return count;
    }
}
