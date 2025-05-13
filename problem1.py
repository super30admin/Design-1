# // Time Complexity : Auxiliary constant time is constant but worst case O(1) 
# // Space Complexity : O(n)
# // Did this code successfully run on Leetcode : Yes
# // Any problem you faced while coding this : No
# Approach: A simple hashing function -> modulus by the size of the array which gives the index to insert
class MyHashSet:

    def __init__(self):
        self.size = 1000
        self.array = [None] * self.size

    def add(self, key: int) -> None:
        index = (key % self.size)
        if not self.array[index]:
            self.array[index] = [key]
        
        if key in self.array[index]:
            return 
        self.array[index].append(key)

    def remove(self, key: int) -> None:
        index = (key % self.size)
        if not self.array[index]:
            return 
        for i in range(len(self.array[index])):
            if key == self.array[index][i]:
                self.array[index].pop(i)
                return
        

    def contains(self, key: int) -> bool:
        index = (key % self.size)
        if not self.array[index]:
            return False
        if key in self.array[index]:
            return True
        return False


# Your MyHashSet object will be instantiated and called as such:
# obj = MyHashSet()
# obj.add(key)
# obj.remove(key)
# param_3 = obj.contains(key)