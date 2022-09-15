// tc - o(n)
//sc -o(1)
// ran in leetcode - yes


class Solution {
    public int longestPalindrome(String s) {
        if(s == null || s.length() == 0){
            return  0;
        }

        HashSet<Character> charSet = new HashSet<Character>();
        int len =0;

        for(int i=0;i< s.length();i++){
            char c = s.charAt(i);
            if(charSet.contains(c)){
                len = len+2;
                charSet.remove(c);
            }else{
                charSet.add(c);
            }
        }
        if(! charSet.isEmpty()){
            len = len+1;
        }
        return len;
    }
}
