

class MyHashSet:

    def __init__(self):
        self.arr = [ [] for i in range(1000) ]
        self.h1 = 1000
        self.h2 = 1000

    def add(self, key: int) -> None:
        hash1 = key % self.h1

        if not self.arr[hash1]:
            if hash1 == 0:
                self.arr[hash1] = [0]*1001
            else:
                self.arr[hash1] = [0]*1000
        hash2 = key // self.h2
        self.arr[hash1][hash2] = 1            

    def remove(self, key: int) -> None:
        hash1 = key % self.h1 
        hash2 = key // self.h2 
        if self.arr[hash1]:
            self.arr[hash1][hash2] = 0

    def contains(self, key: int) -> bool:
        hash1 = key % self.h1 
        hash2 = key // self.h2 
        return False if not self.arr[hash1] else self.arr[hash1][hash2] 
            
