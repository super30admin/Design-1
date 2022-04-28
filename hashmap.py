# Time: O(1)
# Space: O(n)
# Executed successfully on Leetcode (after the class session)
# No challenges faced

class MyHashMap:

    def __init__(self):
        self.arr = [None for _ in range(1000)]
    
    def get_hash_pri(self, key):
        return key % 1000

    def get_hash_sec(self, key):
        return key // 1000
        
    def put(self, key: int, value: int) -> None:
        ph = self.get_hash_pri(key)
        if self.arr[ph] is None:
            if ph == 0:
                self.arr[ph] = [None for i in range(1001)]
            else:
                self.arr[ph] = [None for i in range(1000)]
        sh = self.get_hash_sec(key)
        self.arr[ph][sh] = value
            
        

    def get(self, key: int) -> int:
        ph = self.get_hash_pri(key)
        if self.arr[ph] is not None:
            sh = self.get_hash_sec(key)
            if self.arr[ph][sh] is not None:
                return self.arr[ph][sh]
        return -1
        

    def remove(self, key: int) -> None:
        ph = self.get_hash_pri(key)
        if self.arr[ph] is not None:
            sh = self.get_hash_sec(key)
            self.arr[ph][sh] = None
                
        
        


# Your MyHashMap object will be instantiated and called as such:
# obj = MyHashMap()
# obj.put(key,value)
# param_2 = obj.get(key)
# obj.remove(key)