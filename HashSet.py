# Time Complexity :O(n) for all the function due to the checking the key if its present in the list
# Space Complexity : O(1) for all the functions add, remove and contains, however, core its O(n) since we are using a list
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : No

class MyHashSet:

    def __init__(self):
        self.hash_set = []

    def add(self, key: int) -> None:
        if key in self.hash_set:
            return
        self.hash_set.append(key)

    def remove(self, key: int) -> None:
        if key not in self.hash_set:
            return
        self.hash_set.remove(key)

    def contains(self, key: int) -> bool:
        if key in self.hash_set:
            return True
        return False

# Your MyHashSet object will be instantiated and called as such:
obj = MyHashSet()
obj.add(5)
obj.add(6)
obj.add(7)
obj.remove(6)
param_3 = obj.contains(7)
print(param_3)