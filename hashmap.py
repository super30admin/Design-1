#Time complexity: O(1)
#Space complexity: O(n)
class MyHashMap:

    def __init__(self):
        self.storage = [None]*1000
        self.bucket = 1000
        self.bucketItems = 1000
        
    def hashKey(self,key):
        return key%self.bucket
    
    def nestedhashKey(self,key):
        return key//self.bucketItems
    

    def put(self, key: int, value: int) -> None:
        i = self.hashKey(key)
        if self.storage[i] == None:
            if i == 0:
                self.storage[i] = [None]*((self.bucketItems)+1)
            else:
                self.storage[i] = [None]*(self.bucketItems)
        j = self.nestedhashKey(key)
        self.storage[i][j] = value
       
                

    def get(self, key: int) -> int:
        i = self.hashKey(key)
        if self.storage[i] == None:
            return -1
        else:
            j = self.nestedhashKey(key)
            if self.storage[i][j] == None:
                return -1
            else:
                return self.storage[i][j]

    def remove(self, key: int) -> None:
        i = self.hashKey(key)
        if self.storage[i] == None:
            return
        else:
            j = self.nestedhashKey(key)
            self.storage[i][j] = -1

        
        
