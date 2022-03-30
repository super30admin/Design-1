class MyHashSet:

    def __init__(self):
        self.s = []
        

    def add(self, key: int) -> None:
        self.s.append(key)
        

    def remove(self, key: int) -> None:
        count = 0
        for i in range(len(self.s)):
            if self.s[i] == key:
                count += 1
        for _ in range(count):
            self.s.remove(key)
        

    def contains(self, key: int) -> bool:
        if key in self.s:
            return True
        else:
            return False
        
'''// Time Complexity :O(N)
// Space Complexity :O(N)
// Did this code successfully run on Leetcode :Yes
// Any problem you faced while coding this :No'''

# Your MyHashSet object will be instantiated and called as such:
# obj = MyHashSet()
# obj.add(key)
# obj.remove(key)
# param_3 = obj.contains(key)
