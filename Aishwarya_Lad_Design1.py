# // Time Complexity :
# // Space Complexity :
# // Did this code successfully run on Leetcode :
# // Any problem you faced while coding this :


# // Your code here along with comments explaining your approach
"""
Time complexity of Hash Set with a perfect hashing function is O(1),
but to save space, we create lists to avoid occurences of collision,
hence the time complexity is O(n) in worst case scenario, here it is O(1000)
"""
class MyHashSet:

    def __init__(self):
        self.hash_arr = [[] for i in range(0, 1000)]

    def hash_one(self, key):
        return key%1000

    def hash_two(self, key):
        return key//1000

    def add(self, key: int) -> None:
        if not self.contains(key):
            key_1 = self.hash_one(key)
            key_2 = self.hash_two(key)
            self.hash_arr[key_1].append(key)

    def remove(self, key: int) -> None:
        if self.contains(key):
            key_1 = self.hash_one(key)
            key_2 = self.hash_two(key)
            self.hash_arr[key_1].remove(key)

    def contains(self, key: int) -> bool:
        key_1 = self.hash_one(key)
        key_2 = self.hash_two(key)
        if key in self.hash_arr[key_1]:
            return True
        else:
            return False


hashSet = MyHashSet()
hashSet.add(1)
hashSet.add(2)
print(hashSet.contains(1))    # returns true
print(hashSet.contains(3))    # returns false (not found)
hashSet.add(2)
print(hashSet.contains(2))   # returns true
hashSet.remove(2);          
hashSet.contains(2); 
