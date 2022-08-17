#Time Complexity : O(N/K) where N is the number of all possible values and K is the number of predefined buckets, which is 1000
#Space Complexity : O(1)
#Did this code successfully run on Leetcode : Yes
#Any problem you faced while coding this :

class MyHashSet:

    def __init__(self):
        self.hashset = [[] for index in range(1000)]

    def add(self, key: int) -> None:
        subkey = key%1000
        if not self.contains(key):
            self.hashset[subkey].append(key)

    def remove(self, key: int) -> None:
        subkey = key % 1000
        if self.contains(key):
            self.hashset[subkey].remove(key)
            
    def contains(self, key: int) -> bool:
        subkey = key%1000
        return key in self.hashset[subkey]


# Your MyHashSet object will be instantiated and called as such:
# obj = MyHashSet()
# obj.add(key)
# obj.remove(key)
# param_3 = obj.contains(key)