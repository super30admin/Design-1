
class Solution {
    public boolean wordPattern(String pattern, String str) {
		String[] strs = str.split(" ");
		Map<Character,String> map = new HashMap<Character,String>();
		Set<String> set = new HashSet<String>();

		if(pattern.length() != strs.length) return false;

		for(int i = 0; i < pattern.length(); i++) {
			char ch = pattern.charAt(i);
			if(!map.containsKey(ch)) {
				if(set.contains(strs[i])) return false;
				map.put(ch, strs[i]);
				set.add(strs[i]);
			}else if(!map.get(ch).equals(strs[i])) return false;
		}

		return true;
    }
}