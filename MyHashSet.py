''' Time Complexity : O(1) for all the operations
    Space Complexity : O(n) ; where n is no of elements will be added to the hashset
    Did this code successfully run on Leetcode : Yes
    Any problem you faced while coding this :  No


   Your code here along with comments explaining your approach

   Approach : First, initialized the storage with primary array and boolean array, then 
              implemented the first and second hash function. 
'''

class MyHashSet:

    def __init__(self):
        self.bucket = 1000
        self.bucketItem = 1001
        self.storage = [[] for i in range(self.bucket)]

    def add(self, key: int) -> None:
        
        index = key%self.bucket
        if self.storage[index] == []:
            self.storage[index] = [False for i in range(self.bucketItem)]

        index2 = key//self.bucketItem
        self.storage[index][index2] = True
        
    def remove(self, key: int) -> None:
        index = key%self.bucket
        if self.storage[index]:
            index2 = key//self.bucketItem
            self.storage[index][index2] = False

    def contains(self, key: int) -> bool:
        index = key%self.bucket
        index2 = key//self.bucketItem
        if self.storage[index] != []: 
            return self.storage[index][index2]   
        else:
            return False

obj = MyHashSet()
print(obj.add(1))
print(obj.add(2))
print(obj.contains(1))
print(obj.contains(3))
print(obj.add(2))
print(obj.contains(2))
print(obj.remove(2))
print(obj.contains(2))
