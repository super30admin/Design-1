# Using double hashing to create equally distributed collisions
# Creating a 2d matrix;

class MyHashSet:
    def __init__(self):
        self.storage = [None] * 1000

    def add(self, key: int) -> None:
        index1 = self.hashFn1(key)
        index2 = self.hashFn2(key)

        if self.storage[index1]:
            self.storage[index1][index2] = True 
        else:
            # if no array at the given index; handling edge case key = 1000000
            self.storage[index1] = [False] * (1001 if index1 == 0 else 1000)
            self.storage[index1][index2] = True


    def remove(self, key: int) -> None:
        index1 = self.hashFn1(key)
        index2 = self.hashFn2(key)

        # return if arr does not exist at the index1
        if not self.storage[index1]:
            return
        self.storage[index1][index2] = False 
            
    def contains(self, key: int) -> bool:
        index1 = self.hashFn1(key)
        index2 = self.hashFn2(key)

        # return False if arr does not exist at the index1 or return the value at the given index
        return False if not self.storage[index1] else self.storage[index1][index2]
    
    def hashFn1(self, key: int) -> int:
        return key % 1000
    
    def hashFn2(self, key: int) -> int:
        return key // 1000