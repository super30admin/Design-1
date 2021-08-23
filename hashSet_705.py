


###########################Double hashing method#########################################
'''
adding - O(1)
removing - O(1)
searching - O(1)

space - O(n)

'''
#########################################################################################
import math

class MyHashSet:
    
    def __init__(self):
        """
        Initialize your data structure here.
        """
        
        self.bucketSize = 1000
        self.bucketItems = 1000
        self.mainBucket = [None for i in range(self.bucketSize)]

    def hashValue(self,key:int) -> int:
        return key%self.bucketSize #returns index

    def bucketItemValue(self,key:int) -> int:
        return math.floor(key/(self.bucketSize))  #returns actual val
        
    def add(self, key: int) -> None:
        hashVal = self.hashValue(key)
        bucketItemVal = self.bucketItemValue(key)
        
        if(self.mainBucket[hashVal]== None):
            if(hashVal== 0):
                self.mainBucket[hashVal] = [None for i in range(self.bucketItems + 1)]
            else:
                 self.mainBucket[hashVal] = [None for i in range(self.bucketItems)]
            
            self.mainBucket[hashVal][bucketItemVal] = True

        else:
            self.mainBucket[hashVal][bucketItemVal] = True


    def remove(self, key: int) -> None:
        hashVal = self.hashValue(key)
        bucketItemVal = self.bucketItemValue(key)
        
        if(self.mainBucket[hashVal]!= None):
            self.mainBucket[hashVal][bucketItemVal] = False
        else:
            return
        

    def contains(self, key: int) -> bool:
        """
        Returns true if this set contains the specified element
        """
        hashVal = self.hashValue(key)
        bucketItemVal = self.bucketItemValue(key)
        
        if(self.mainBucket[hashVal]== None):
            return False
        else:
            return self.mainBucket[hashVal][bucketItemVal]
        
# Your MyHashSet object will be instantiated and called as such:
obj = MyHashSet()
print(obj.hashValue(0))
print(obj.bucketItemValue(0))
obj.add(0)
# obj.remove(key)
# param_3 = obj.contains(key)

print(obj.mainBucket)