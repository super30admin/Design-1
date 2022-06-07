# Same approach as HashSet but with values instead of boolean, use -1 to specify missing key, else a value would be present
class MyHashMap:

    def __init__(self):
        self.bucket = 1000
        self.bucketItems = 1000
        self.list = [None] * self.bucket   # init an empty list with None values

    def hash1(self, key):
        return key % self.bucket
    
    def hash2(self, key):
        return key // self.bucketItems # use integer division


    def put(self, key: int, value: int) -> None:
        h1 = self.hash1(key)
        h2 = self.hash2(key)
        if not self.list[h1]:  # meaning its None
            self.list[h1] = [-1] * self.bucketItems
            if h1 == 0: # handle edge case where we can get 1001 items but bucket is only 1000
                self.list[h1].append(-1)
        
        self.list[h1][h2] = value

        
    def get(self, key: int) -> int:
        h1 = self.hash1(key)
        h2 = self.hash2(key)
        if self.list[h1]:
            if self.list[h1][h2] != -1:
                return self.list[h1][h2]
        return -1
        


    def remove(self, key: int) -> None:
        h1 = self.hash1(key)
        h2 = self.hash2(key)
        if self.list[h1]:
            self.list[h1][h2] = -1


# Your MyHashMap object will be instantiated and called as such:
# obj = MyHashMap()
# obj.put(key,value)
# param_2 = obj.get(key)
# obj.remove(key)