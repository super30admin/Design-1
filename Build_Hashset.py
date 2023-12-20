'''

Time Complexity : O(1) time complexity using primary and secondary arrays
Space Complexity : O(n) since I'm using two arrays
Did this code successfully run on Leetcode : Yes
Any problem you faced while coding this : No issues faced

'''



class MyHashSet:

    def __init__(self):
        self.map = [[False] * 1001  for _ in range(1001)]

    def hash(self,key):
        pri = key % len(self.map)
        sec = key // len(self.map)
        return [pri,sec]

    def add(self, key: int) -> None:
        keys = self.hash(key)
        self.map[keys[0]][keys[1]] = True
        return

    def remove(self, key: int) -> None:
        keys = self.hash(key)
        self.map[keys[0]][keys[1]] = False
        return

    def contains(self, key: int) -> bool:
        keys = self.hash(key)
        if self.map[keys[0]][keys[1]] == True:
            return True
        return False



# Your MyHashSet object will be instantiated and called as such:
# obj = MyHashSet()
# obj.add(key)
# obj.remove(key)
# param_3 = obj.contains(key)