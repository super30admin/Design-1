"""
Problem 1
705. Design HashSet
Time Complexity : 
    All operation is O(1)

Space Complexity : O(N) 

Did this code successfully run on Leetcode : yes

The bucket size is decided in a way that the elements in the array gets divided equally

Bucket size is calculated using Sqrt of the size


The place to add the value is decided based on the below hash function:
    hash1 = % bucketsize
    hash2 = / bucketsize 

Execption Case: Since the modulus of last value gives 0 the bucketsize is added +1


    

@name: Rahul Govindkumar_RN27JUL2022
"""


class MyHashSet:

    def __init__(self):
        self.bucketsize=1000
        self.bucket= [None] * self.bucketsize
        
        
    def hash_fn1(self, key):
        return key % self.bucketsize
    
    def hash_fn2(self, key):
        return key // self.bucketsize

    def add(self, key: int) -> None:
        hash1 = self.hash_fn1(key)
        hash2 = self.hash_fn2(key)

        
        if self.bucket[hash1]==None:
            if hash1 == 0:
                self.bucket[hash1]=[False]* (self.bucketsize+1)
            else:
                self.bucket[hash1]=[False]* (self.bucketsize)
 
        self.bucket[hash1][hash2] = True
    

    def remove(self, key: int) -> None:
        hash1 = self.hash_fn1(key)
        hash2 = self.hash_fn2(key)
        
        if self.bucket[hash1] != None:
            self.bucket[hash1][hash2]= False
        
        return
            
        

    def contains(self, key: int) -> bool:
        hash1 = self.hash_fn1(key)
        hash2 = self.hash_fn2(key)
        
        if self.bucket[hash1] == None :
            return False
        return self.bucket[hash1][hash2]
            
        
        


# Your MyHashSet object will be instantiated and called as such:
# obj = MyHashSet()
# obj.add(key)
# obj.remove(key)
# param_3 = obj.contains(key)


"""
Method 2

Did this code successfully run on Leetcode : yes

Time Complexity : 
    All operation is O(1)

Space Complexity : O(N) 

"""

class MyHashSet:

    def __init__(self):
        self.bucketsize=10000
        self.bucket= [None] * self.bucketsize
        
        
    def hash_fn(self, key):
        return key % self.bucketsize

    def add(self, key: int) -> None:
        i = self.hash_fn(key)
        
        if self.bucket[i]==None:
            self.bucket[i]=[key]
        else:
            self.bucket[i].append(key)
        

    def remove(self, key: int) -> None:
        i = self.hash_fn(key)
        
        if self.bucket[i] != None:
            while key in self.bucket[i]:
                self.bucket[i].remove(key)
        

    def contains(self, key: int) -> bool:
        i = self.hash_fn(key)
        
        if self.bucket[i]!=None:
            if key in self.bucket[i]:
                return True
        return False
            
        
        


# Your MyHashSet object will be instantiated and called as such:
# obj = MyHashSet()
# obj.add(key)
# obj.remove(key)
# param_3 = obj.contains(key)