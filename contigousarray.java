// tc - o(n)
//sc - 0(n)
// ran in leetcode - yes

class Solution {
    public int findMaxLength(int[] nums) {
        if(nums == null || nums.length == 0){
            return 0;
        }
        HashMap<Integer,Integer> map = new HashMap<>();
        int len =0;
        int rsum = 0;
        map.put(0,-1);
        for(int i=0;i<nums.length;i++){
            if(nums[i] == 1){
                rsum = rsum+1;
            }else{
                rsum = rsum -1;
            }
            if(map.containsKey(rsum)){
                len = Math.max(len, i - map.get(rsum));
            }
            else{
                map.put(rsum,i);
            }
        }
        return len;
    }
}
