class MyHashSet:
    #Space O(N)
    #Time O(1) for each operation

    def __init__(self):
        """
        Initialize your data structure here.
        """
        self.last = False
        self.bucket = [[None for i in range(1000)]for j in range(1000)]
        
    def valid_key(self, key):
        if key <0 or key >1000000:
            return False
        return True
    def add(self, key: int) -> None:
        if self.valid_key(key):
            if key == 1000000:
                self.last = True
            else:
                self.bucket[key//1000][key%1000]=True
        

    def remove(self, key: int) -> None:
        if self.valid_key(key):
            if key == 1000000:
                self.last = False
            else:
                self.bucket[key//1000][key%1000]=False
        

    def contains(self, key: int) -> bool:
        if self.valid_key(key):
            if key == 1000000:
                return self.last
            return self.bucket[key//1000][key%1000]
        """
        Returns true if this set contains the specified element
        """
        


# Your MyHashSet object will be instantiated and called as such:
# obj = MyHashSet()
# obj.add(key)
# obj.remove(key)
# param_3 = obj.contains(key)