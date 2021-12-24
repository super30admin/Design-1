# avg time complexity O(n)
# space complexity O(n * n) 
class MyHashMap:

    def __init__(self):
        self.bucket1 = 1000
        self.bucket2 = 1000
        self.arr = [[] for i in range(1000)]
        

    def put(self, key: int, value: int) -> None:
        
        hash1 = key % self.bucket1
        hash2 = key // self.bucket2
        
        if not self.arr[hash1]:
            if hash1 == 0:
                self.arr[hash1] = [-1 for i in range(1001)]
            else:
                self.arr[hash1] = [-1 for i in range(1000)]
                
        self.arr[hash1][hash2] = value 
            

    def get(self, key: int) -> int:
        
        hash1 = key % self.bucket1
        hash2 = key // self.bucket2
        if self.arr[hash1]:
            return self.arr[hash1][hash2]
        else:
            return -1

    def remove(self, key: int) -> None:
        hash1 = key % self.bucket1
        hash2 = key // self.bucket2
        if self.arr[hash1]:
            self.arr[hash1][hash2] = -1
        


# Your MyHashMap object will be instantiated and called as such:
# obj = MyHashMap()
# obj.put(key,value)
# param_2 = obj.get(key)
# obj.remove(key)

