class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        // Calculate ID for a String
        // Create a HashMap key Long and Values List<String>
        //return HashMap values
        
        if (strs == null || strs.length == 0){
            return new ArrayList<>();
        }
        
        Map<Long,List<String>> hashMap = new HashMap<>();
        
        for (String str : strs){
            long ID = calculateID(str);            
            if (!hashMap.containsKey(ID)){
                hashMap.put(ID, new ArrayList<>());
            }
            hashMap.get(ID).add(str);
        }
        return new ArrayList<>(hashMap.values());
    }
    
    private Long calculateID(String str){
        
        int[] primes = {2, 3, 5, 7, 11, 13, 17, 19, 23, 29, 31, 37, 41, 43, 47, 53, 59, 61, 67, 71, 73, 79, 83, 89, 97, 101};
        
        long retVal = 1;
        
        for (int i = 0; i < str.length(); i++){
            Character ch = str.charAt(i);
            retVal = retVal * primes[ch - 'a'];
        }
        return retVal;
    }
}