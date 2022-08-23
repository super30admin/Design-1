# Time Complexity : O(1) for all operations


# Your code here along with comments explaining your approach

class MyHashSet:

    def __init__(self):
        self.hashSet = [None] * 100
        self.buckets = 100
        self.bucketItems = 100
        
    def hashfunc1(self, value):
        return value % self.buckets
    def hashfunc2(self, value):
        return value // self.bucketItems

    def add(self, key: int) -> None:
        hash1 = self.hashfunc1(key)
        if self.hashSet[hash1] == None:
            self.hashSet[hash1] = [None] * self.bucketItems
            
        hash2 = self.hashfunc2(key)
        self.hashSet[hash1][hash2] = True

    def remove(self, key: int) -> None:
        hash1 = self.hashfunc1(key)
        if self.hashSet[hash1] == None:
            return
        hash2 = self.hashfunc2(key)
        self.hashSet[hash1][hash2] = False
                

    def contains(self, key: int) -> bool:
        hash1 = self.hashfunc1(key)
        hash2 = self.hashfunc2(key)
        return self.hashSet[hash1] != None and self.hashSet[hash1][hash2]

# Your MyHashSet object will be instantiated and called as such:
# obj = MyHashSet()
# obj.add(key)
# obj.remove(key)
# param_3 = obj.contains(key)

if __name__ == "__main__":
	hashSet = MyHashSet()
	hashSet.add(1)
	hashSet.add(2)
	print(hashSet.contains(1))    # returns true
	print(hashSet.contains(3))    # returns false (not found)
	hashSet.add(2)
	print(hashSet.contains(2))    # returns true
	hashSet.remove(2)
	print(hashSet.contains(2))    # returns false (already removed)