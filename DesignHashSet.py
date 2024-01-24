'''
Initialized a range to determine the size of primary and 
    nested secondary arrays - used sqrt to determine the size of arrays
Computed hash functions for both primary and secondary array to find the 
    position of the keys added or removed
Coded the implementation based on array properties to get the results
    of individual operations.
TC: add: O(1), remove: O(1), contains: O(1)
SC: O(n) n is the number of elements
'''

class MyHashSet:
    def __init__(self):
        self.primary = [None for i in range(1000)]
        self.secondary = [None for i in range(1000)]

    def hash1(self, key):
        return key%1000

    def hash2(self, key):
        return key//1000
        
    def add(self, key: int) -> None:
        primaryIndex = self.hash1(key)
        secondaryIndex = self.hash2(key)
        if primaryIndex == 0:
            if self.primary[primaryIndex] == None:
                arr = self.secondary.copy()
                arr.extend([None])
                self.primary[primaryIndex] = arr
                if key == 1000000:
                    self.primary[primaryIndex][-1] = True
                    return
        if self.primary[primaryIndex] != None:
            self.primary[primaryIndex][secondaryIndex] = True
        else:
            self.primary[primaryIndex] = self.secondary.copy()
            self.primary[primaryIndex][secondaryIndex] = True
        
    def remove(self, key: int) -> None:
        primaryIndex = self.hash1(key)
        secondaryIndex = self.hash2(key)
        if key == 1000000:
            self.primary[primaryIndex][-1] = False
            return None
        if self.primary[primaryIndex] != None:
            self.primary[primaryIndex][secondaryIndex] = False
        
    def contains(self, key: int) -> bool:
        primaryIndex = self.hash1(key)
        secondaryIndex = self.hash2(key)
        if self.primary[primaryIndex] != None:
            if key == 1000000:
                return self.primary[primaryIndex][-1]
            else:
                return self.primary[primaryIndex][secondaryIndex]
        return False
        
# Your MyHashSet object will be instantiated and called as such:
obj = MyHashSet()
val = 8
obj.add(val)
obj.remove(val)
param_3 = obj.contains(val)
print(f"Does the hashset contain {val}: {param_3}")
val = 1000000
obj.add(val)
param_3 = obj.contains(val)
print(f"Does the hashset contain {val}: {param_3}")
val = 0
obj.add(val)
param_3 = obj.contains(val)
print(f"Does the hashset contain {val}: {param_3}")
obj.remove(0)
param_3 = obj.contains(val)
param_4 = obj.contains(1000000)
print(f"Does the hashset contain 0: {param_3}")
print(f"Does the hashset contain 1000000: {param_4}")