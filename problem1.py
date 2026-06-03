# Design-1

## Problem 1:(https://leetcode.com/problems/design-hashset/)

# Time Complexity : O(1)
# Space Complexity : O(n)
# Did this code successfully run on Leetcode : yes
# Any problem you faced while coding this :no


# Your code here along with comments explaining your approach


class MyHashSet:
    # bruteforce have an array of 10**6 each item  will be added to idx = func(item % 10 ** 6)
    # q1 what ds and size-> explain concept of hashing -> linear probing, double hashing , chaining 
    # why double hashing is good and not linear probing othat meand if collision go store in nearst empty not # good chaining also doent mean const lookup , why double hashing and also why dividing both arrays in wual is best 
    # this is double hashing where first has gives bucket and second hash gives the loc of idx in that bucket not initializing all to 10^6 spaces 10^3 primary array and then each contain null only when value arrives expanf each bucket to point to 10^3 array 

    def __init__(self):
        self.size = 1000
        self.arr = [None for _ in range(self.size)]
        
    def getBucket(self,key: int) -> int:
        return key % self.size
    
    def getSecondArrPos(self,key:int) -> int:
        return key // self.size

    def add(self, key: int) -> None:
        idx = self.getBucket(key)
        arrPos = self.getSecondArrPos(key)
        if self.arr[idx] is None:
            self.arr[idx] = [False] * self.size if idx != 0 else [False] * (self.size+1)
        self.arr[idx][arrPos] = True
        return
        
    def remove(self, key: int) -> None:
        idx = self.getBucket(key)
        if self.arr[idx] is None:
            return
        arrPos = self.getSecondArrPos(key)
        self.arr[idx][arrPos] = False
        return
        
    def contains(self, key: int) -> bool:
        idx = self.getBucket(key)
        if self.arr[idx] is None:
            return False
        arrPos = self.getSecondArrPos(key)
        return self.arr[idx][arrPos] == True
        

# Your MyHashSet object will be instantiated and called as such:
# obj = MyHashSet()
# obj.add(key)
# obj.remove(key)
# param_3 = obj.contains(key)