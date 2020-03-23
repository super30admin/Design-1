class Solution {
    public boolean isIsomorphic(String s, String t) {
        
        // length check
        // Two Hashmap
        
        if (s.length() != t.length()){
            return false;
        }
        
        Map<Character,Character> hashMap1 = new HashMap<>();
        Map<Character,Character> hashMap2 = new HashMap<>();
        
        
        for (int x = 0; x < s.length(); x++){
            Character charOfs = s.charAt(x);
            Character charOft = t.charAt(x);
            
            if (hashMap1.containsKey(charOfs)){
                
                if (hashMap1.get(charOfs) != charOft ){
                    return false;
                }
                
            } else {
                hashMap1.put(charOfs, charOft);
            }
        }
        
        for (int x = 0; x < t.length(); x++){
            Character charOfs = s.charAt(x);
            Character charOft = t.charAt(x);
            
            if (hashMap2.containsKey(charOft)){
                
                if (hashMap2.get(charOft) != charOfs ){
                    return false;
                }
                
            } else {
                hashMap2.put(charOft, charOfs);
            }
        }
     return true;   
    }
}