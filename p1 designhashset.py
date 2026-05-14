class MyHashSet:

    def __init__(self):
        self.primaryBuckets = 1000
        self.secondaryBuckets = 1000
        # Initialize storage with None to save memory (Lazy Loading)
        self.storage = [None] * self.primaryBuckets
    
    def primaryHash(self, key):
        return key % self.primaryBuckets

    def secondaryHash(self, key):
        return key // self.secondaryBuckets

    def add(self, key: int) -> None:
        pIdx = self.primaryHash(key)
        sIdx = self.secondaryHash(key)
        
        if self.storage[pIdx] is None:
            # For the 0th index, we need 1001 to accommodate key 1,000,000
            if pIdx == 0:
                self.storage[pIdx] = [False] * (self.secondaryBuckets + 1)
            else:
                self.storage[pIdx] = [False] * self.secondaryBuckets
        
        self.storage[pIdx][sIdx] = True

    def remove(self, key: int) -> None:
        pIdx = self.primaryHash(key)
        sIdx = self.secondaryHash(key)
        
        if self.storage[pIdx] is not None:
            self.storage[pIdx][sIdx] = False

    def contains(self, key: int) -> bool:
        pIdx = self.primaryHash(key)
        sIdx = self.secondaryHash(key)
        
        if self.storage[pIdx] is None:
            return False
        return self.storage[pIdx][sIdx]

# --- Example Execution ---
if __name__ == "__main__":
    hashSet = MyHashSet()
    print("Action: add(1), add(2)")
    hashSet.add(1)
    hashSet.add(2)
    
    print(f"contains(1): {hashSet.contains(1)}") # True
    print(f"contains(3): {hashSet.contains(3)}") # False
    
    print("Action: remove(2)")
    hashSet.remove(2)
    print(f"contains(2): {hashSet.contains(2)}") # False