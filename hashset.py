'''
Optimal approach : Using double hashing to avoid collisions
'''
class MyHashSet:

    def __init__(self):
        self.bucket_size_1 = 10**3
        self.bucket_size_2 = 10**3
        self.bucket = [None] * self.bucket_size_1
        
    def hashkeyrow(self, key):
        return key % self.bucket_size_1
    
    def hashkeycol(self,key):
        return key // self.bucket_size_2
        
    def add(self, key: int) -> None:
        row = self.hashkeyrow(key)
        col = self.hashkeycol(key)
        
        if not self.bucket[row] and key == 10**6:
            self.bucket[row] = [False] * (self.bucket_size_1 + 1)
        elif not self.bucket[row]:
            self.bucket[row] = [False] * self.bucket_size_2
            
        self.bucket[row][col] = True
        
    def remove(self, key: int) -> None:
        row = self.hashkeyrow(key)
        col = self.hashkeycol(key)
        
        if self.bucket[row]:
            self.bucket[row][col] = False
            
    def contains(self, key: int) -> bool:
        row = self.hashkeyrow(key)
        col = self.hashkeycol(key)
        
        if self.bucket[row]:
            return self.bucket[row][col]
        


# Your MyHashSet object will be instantiated and called as such:
# obj = MyHashSet()
# obj.add(key)
# obj.remove(key)
# param_3 = obj.contains(key)

''' 
Brute Force Approach : Using an array

1. Initialize the array with all the elements set to False
2. After Inserting the element, set the values to True

Here the elements are directly used as indices.

Time complexity for CRUD : 0(1)
Space complexity is 0(N) where N is the size of the elements

class MyHashSet:
    size = 10**6 + 1
    array = [False] * size
    
    def __init__(self):
        self.array = MyHashSet.array

    def add(self, key: int) -> None:
        self.array[key] = True

    def remove(self, key: int) -> None:
        self.array[key] = False
        
    def contains(self, key: int) -> bool:
        print(self.array[key])
        
    def show(self):
        print(self.array)
        
'''
