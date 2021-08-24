class Solution:
    def groupAnagrams(self, strs: List[str]) -> List[List[str]]:
	    
        hashmap = {}
        while strs:
            strS = "".join(sorted(strs[-1]))  
            if strS in hashmap:
                hashmap[strS].append(strs.pop())
                continue
            hashmap[strS]=[strs.pop()]

        return list(hashmap.values())    