class Solution {
    public int longestPalindrome(String s) {
        
        // edge case
        
        if (s == null || s.length() == 0  ){
            return 0;
        }
        
        HashSet<Character> hashSet = new HashSet<>();
        
        int max = 0;
        
        for (int i = 0; i < s.length(); i++){
            Character ch = s.charAt(i);
            
            if (hashSet.contains(ch)){
                max += 2;
                hashSet.remove(ch);
            } else {
                hashSet.add(ch);
            }
        }
        
        if (!hashSet.isEmpty())
            return max + 1;
        else
            return max;
        
    }
}