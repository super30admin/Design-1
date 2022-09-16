class Solution {
    public boolean wordPattern(String pattern, String s) {
        String[] strArray = s.split(" ");
        if(pattern.length() != strArray.length){
            return false;
        }
        HashMap<Character,String> map = new HashMap<>();
        HashSet<String> set = new HashSet<>();
        for(int i=0; i<pattern.length(); i++){
            String str = strArray[i];
            char c = pattern.charAt(i);
            if(map.containsKey(c)){
                if(!str.equals(map.get(c))){
                    return false;
                }
            }else{
                if(set.contains(str)){
                    return false;
                }
                map.put(c,str);
                set.add(str);
            }
        }
        return true;
    }
}
