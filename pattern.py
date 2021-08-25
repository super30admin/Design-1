class Solution:
    def wordPattern(self, pattern: str, s: str) -> bool:
        mapping, seen, s = {}, set(), s.split()
        
        if len(s) != len(pattern):
            return False
        
        for idx, word in enumerate(s):
            c = pattern[idx]
            
            if word not in mapping and c not in seen:
                mapping[word] = c
                seen.add(c)
                continue
            
            if word in mapping and mapping[word] == c:
                continue
            
            if word in mapping and mapping[word] != c:
                return False
            
            return False
        
        return True