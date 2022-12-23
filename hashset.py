# HASHSET: 
# First according to the data, square root of the number or nearest square root of the number is taken. 
# After that I have implemented the hash function which afterwards find empty bucket in a row and places the 
# key in that bucket or if not empty creates new nested array and puts the key there. 

class MyHashSet:

    def __init__(self):
        self.buckets = 1000 #row
        self.bucketItems = 1000
        self.storage =[None for i in range(self.buckets)]
        print(self.storage)


    def hash1(self, key):
        return (key%self.buckets)

    def hash2(self, key):
        return (key//self.bucketItems)

    def add(self, key: int) -> None:
        i = self.hash1(key)
        j = self.hash2(key)
        if (self.storage[i] == None):
            if (i == 0):
                self.storage[i] = [False for i in range(self.bucketItems + 1)]
            else:
                self.storage[i] = [False for i in range(self.bucketItems)]
        self.storage[i][j] = True


    def remove(self, key: int) -> None:
        i = self.hash1(key)
        j = self.hash2(key)
        if (self.storage[i] == None):
            return
        self.storage[i][j] = False

    def contains(self, key: int) -> bool:
        i = self.hash1(key)
        j = self.hash2(key)
        if (self.storage[i] == None):
            return False
        return self.storage[i][j]
        


# Your MyHashSet object will be instantiated and called as such:
# obj = MyHashSet()
# obj.add(key)
# obj.remove(key)
# param_3 = obj.contains(key)