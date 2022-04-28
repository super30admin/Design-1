# Time: O(1)
# Space: O(n)
# Executed successfully on Leetcode (after the class session)
# No challenges faced

class MyHashSet:

    def __init__(self):
        self.arr = [None for _ in range(1000)]
    
    def get_hash_pri(self, key):
        return key % 1000

    def get_hash_sec(self, key):
        return key // 1000

    def add(self, key: int) -> None:
        ph = self.get_hash_pri(key)
        if self.arr[ph] is None:
            if ph == 0:
                self.arr[ph] = [False for i in range(1001)]
            else:
                self.arr[ph] = [False for i in range(1000)]
        sh = self.get_hash_sec(key)
        self.arr[ph][sh] = True
            
        

    def remove(self, key: int) -> None:
        ph = self.get_hash_pri(key)
        if self.arr[ph] is not None:
            sh = self.get_hash_sec(key)
            self.arr[ph][sh] = False
        

    def contains(self, key: int) -> bool:
        ph = self.get_hash_pri(key)
        if self.arr[ph] is not None:
            sh = self.get_hash_sec(key)
            if self.arr[ph][sh] == True:
                return True
        return False
        


# Your MyHashSet object will be instantiated and called as such:
# obj = MyHashSet()
# obj.add(key)
# obj.remove(key)
# param_3 = obj.contains(key)