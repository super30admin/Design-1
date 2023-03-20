// Time Complexity :
// Space Complexity :
// Did this code successfully run on Leetcode :
// Any problem you faced while coding this :


// Your code here along with comments explaining your approach
// Time Complexity :O(1)
// Space Complexity :O(1)
// Did this code successfully run on Leetcode :Yes
// Any problem you faced while coding this :No

// Your code here along with comments explaining your approach
//created array of array (2d array) to eliminate collision
// Problem 1:(https://leetcode.com/problems/design-hashset/)
class MyHashSet:

    def __init__(self):
       self.Hashset = 1000 ## square root of 10^3 
       self.Hashset_1 = 1000 ## square root of 10^3
       self.storage = [None]*self.Hashset
    def getKey(self, key:int) -> int:
       return key % self.Hashset 
    def getItemKey(self, key:int) -> int:
        return key // self.Hashset_1
    def add(self, key: int) -> None:
       Bucket = self.getKey(key)
       Bucket_Item = self.getItemKey(key)
       if self.storage[Bucket] == None:
           if  Bucket == 0:
               self.storage[Bucket] = [False]* (self.Hashset_1+1)
           else:
               self.storage[Bucket] = [False]* self.Hashset_1
       self.storage[Bucket][Bucket_Item] = True

    def remove(self, key: int) -> None:
       Hashset = self.getKey(key)
       Hashset_1 = self.getItemKey(key)
       if self.storage[Hashset] ==None:
               return
       self.storage[Hashset][Hashset_1] = False # assign it false, if we remove the key 

    def contains(self, key: int) -> bool:
        Hashset = self.getKey(key)
        Hashset_1 = self.getItemKey(key)
        if self.storage[Hashset] == None:
            return
        
        return self.storage[Hashset][Hashset_1]

// Time Complexity :O(1)
// Space Complexity :O(1)
// Did this code successfully run on Leetcode :Yes
// Any problem you faced while coding this :No

// Your code here along with comments explaining your approach
// created one single stack, updating the min value when ever the element pushed is less than present min.
// pushing the present min into stack and updating the min and then pushing the updated min to the stack.
// Design MinStack (https://leetcode.com/problems/min-stack/)
class MinStack:

    def __init__(self):
       self.stack = []
       self.min = int(sys.maxsize)
    def push(self, val: int) -> None:
           if val <= self.min :
               self.stack.append(self.min)
               self.min = val
           self.stack.append(val)
    def pop(self) -> None:
        element = self.stack.pop()
        if element == self.min:
            self.min = self.stack.pop()
    def top(self) -> int:
        return self.stack[-1]

    def getMin(self) -> int:
        return self.min
