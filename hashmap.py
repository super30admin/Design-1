"""
Runtime Complexity:
O(1) - as we just append the tuple(key,value) to the array if its not found or just update it. 
- The get(),update(),remove() takes O(1) time as it is not stored contiguously like arrays do. Because we hash and create index for each elements to be added.
So all these operations don't traverse contiguous memory locations. It works same as linked list in terms of memory storage and takes overall of O(1) because we refer to each element with
respect to its hashed index.

-Yes, the code worked on leetcode
"""


class Bucket:
    def __init__(self):
        self.bucket = []
        
    def get(self,key):
        for (k,v) in self.bucket:
            if k==key:
                return v
        return -1
    
    def update(self,key,value):
        found= False
        for i,kv in enumerate(self.bucket):
            if kv[0] == key:
                self.bucket[i] = (key,value)
                found =True
                break
        if not found:
            self.bucket.append((key,value))
                
    def remove(self,key):
        for i,kv in enumerate(self.bucket):
            if kv[0] ==key:
                del self.bucket[i]
class MyHashMap:

    def __init__(self):
         self.size = 199
         self.hash_table =[Bucket() for i in range(self.size)]   
        
        

    def put(self, key: int, value: int) -> None:
        hash_key = key % self.size
        self.hash_table[hash_key].update(key,value)
        

    def get(self, key: int) -> int:
        hash_key = key % self.size
        return self.hash_table[hash_key].get(key)
        

    def remove(self, key: int) -> None:
        hash_key = key %self.size
        self.hash_table[hash_key].remove(key)
        


# Your MyHashMap object will be instantiated and called as such:
# obj = MyHashMap()
# obj.put(key,value)
# param_2 = obj.get(key)
# obj.remove(key)
