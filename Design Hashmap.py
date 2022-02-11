class Bucket:
    def __init__(self):
        self.bucket = [ ]
        
    def insert(self, key, value):
        Found = False
        for i, k in enumerate(self.bucket):
            if key == k[0]:
                self.bucket[i][1] = value
                Found = True
                break
        if not Found:
            self.bucket.append([key,value])
    
    def find(self, key):
        for i, k in enumerate(self.bucket):
            if key == k[0]:
                return self.bucket[i][1]
        return -1
    
    def delete(self, key):
        for i, k in enumerate(self.bucket):
            if key == k[0]:
                del self.bucket[i]
        
    
#Time Complexity :
#Space Complexity :
#Did this code successfully run on Leetcode :

class MyHashMap:

    def __init__(self):
        self.base_modulo = 3119
        self.hash_key_arr = [Bucket() for i in range(self.base_modulo)]
        
    def put(self, key: int, value: int) -> None:
        hash_key = key % self.base_modulo
        self.hash_key_arr[hash_key].insert(key,value)
        
    def get(self, key: int) -> int:
        hash_key = key % self.base_modulo
        return self.hash_key_arr[hash_key].find(key)
        
    def remove(self, key: int) -> None:
        hash_key = key % self.base_modulo
        self.hash_key_arr[hash_key].delete(key)
        


# Your MyHashMap object will be instantiated and called as such:
# obj = MyHashMap()
# obj.put(key,value)
# param_2 = obj.get(key)
# obj.remove(key)