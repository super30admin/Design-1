# // Time Complexity : O(1)
# // Space Complexity : O(n)
# // Did this code successfully run on Leetcode : Yes
# // Any problem you faced while coding this : None

class MyHashMap:

    def __init__(self):
        self.buckets = 1000
        self.bucketList = 1000
        self.storage = [None] * self.buckets
        
    def bucketHash(self, key):
        return key % self.buckets
    
    def bucketlistHash(self, key):
        return key // self.bucketList
        
    def put(self, key: int, value: int) -> None:
        bucketIdx = self.bucketHash(key)
        if self.storage[bucketIdx] is None:
            if bucketIdx == 0:
                self.storage[bucketIdx] = [None] * (self.bucketList + 1)
            else : 
                self.storage[bucketIdx] = [None] * self.bucketList
        bucketlistIdx = self.bucketlistHash(key)
        self.storage[bucketIdx][bucketlistIdx] = value

    def get(self, key: int) -> int:
        bucketIdx = self.bucketHash(key)
        bucketlistIdx = self.bucketlistHash(key)
        
        if self.storage[bucketIdx] is None or self.storage[bucketIdx][bucketlistIdx] is None:
            return -1
    
        return self.storage[bucketIdx][bucketlistIdx] 

    def remove(self, key: int) -> None:
        bucketIdx = self.bucketHash(key)
        bucketlistIdx = self.bucketlistHash(key)
        
        if self.storage[bucketIdx] is None:
            return
    
        self.storage[bucketIdx][bucketlistIdx] = None

        


# Your MyHashMap object will be instantiated and called as such:
# obj = MyHashMap()
# obj.put(key,value)
# param_2 = obj.get(key)
# obj.remove(key)
