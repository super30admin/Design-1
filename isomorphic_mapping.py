class Solution:
    def isIsomorphic(self, s: str, t: str) -> bool:
        mapping = {}
        mapped = set()
        n = len(s)
        for i in range(n):
            if s[i] not in mapping:
                if t[i] not in mapped:
                    mapping[s[i]] = t[i]
                    mapped.add(t[i])
                else:
                    return False
            else:
                if mapping[s[i]] != t[i]:
                    return False

        return True