# // Time Complexity :
# // Space Complexity :
# // Did this code successfully run on Leetcode :
# // Any problem you faced while coding this :


# // Your code here along with comments explaining your approach
"""
Time complexity of Hash Set with a perfect hashing function is O(1),
but to save space, we create double hashing to avoid occurences of collision, constant access time
and less wastage of memory, so Space complexity is O(n^(1/2))
"""
class MyHashSet:

    def __init__(self):
        self.hash_arr = [None for i in range(0, 1000)]

    def hash_one(self, key):
        return key%1000

    def hash_two(self, key):
        return key//1000

    def add(self, key: int) -> None:
        key_1 = self.hash_one(key)
        key_2 = self.hash_two(key)
        if not self.hash_arr[key_1]:
            if key_1 == 0:
                # Edge case to handle 10^3 index, as range would be from 0-999, 10^3 will be 
                # stored at 1001th position of secondary array
                bucket_items = [False for i in range(0, 1001)]
            else:
                bucket_items = [False for i in range(0, 1000)]
            bucket_items[key_2] = True
            self.hash_arr[key_1] = bucket_items
        self.hash_arr[key_1][key_2] = True

    def remove(self, key: int) -> None:
        key_1 = self.hash_one(key)
        key_2 = self.hash_two(key)

        if self.hash_arr[key_1]:
            self.hash_arr[key_1][key_2] = False
        else:
            return

    def contains(self, key: int) -> bool:
        key_1 = self.hash_one(key)
        key_2 = self.hash_two(key)

        if self.hash_arr[key_1]:
            return self.hash_arr[key_1][key_2]
        else:
            return False


hashSet = MyHashSet()
hashSet.add(1)
hashSet.add(2)
hashSet.add(1001)
hashSet.add(2001)
hashSet.add(2002)
hashSet.add(1200)
print(hashSet.contains(1))    # returns true
print(hashSet.contains(3))    # returns false (not found)
hashSet.add(2)
print(hashSet.contains(2))   # returns true
hashSet.remove(2)
hashSet.contains(2)
