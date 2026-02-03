''' 
Time Complexity : O(1)
Space Complexity : O(n)
Did this code successfully run on Leetcode : Yes
Any problem you faced while coding this :  No
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
print(obj.add(10))
print(obj.add(40))
print(obj.contains(10))
print(obj.contains(30))
print(obj.add(40))
print(obj.contains(40))
print(obj.remove(40))
print(obj.contains(40))