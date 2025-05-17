# Problem 1 : Implementing Hashset Using Double Hashing

# First and Second has functions were chosen in such a way that they ensure the collisions are uniform.

# Time Complexity : 
#   add()     -> O(1)
#   remove()  -> O(1)
#   contains()-> O(1)
# Space Complexity : O(N)
# Did this code successfully run on Leetcode : Yes
class MyHashSet:

    def __init__(self):
        self.buckets=1000
        self.bucketItems=1000
        self.storage= [None]*self.buckets
    
    def hash1(self, key: int) -> int:
        return int(key%1000)
    
    def hash2(self, key: int) -> int:
        return int(key/1000)

    def add(self, key: int) -> None:
        idx1=self.hash1(key)
        if self.storage[idx1] is None:
            if idx1==0:
                self.storage[idx1]=[False]*(self.bucketItems+1)
            else:
                self.storage[idx1]=[False]*self.bucketItems
        idx2=self.hash2(key)
        self.storage[idx1][idx2]= True

    def remove(self, key: int) -> None:
        idx1=self.hash1(key)
        if self.storage[idx1] is None:
            return
        idx2=self.hash2(key)
        self.storage[idx1][idx2]=False

    def contains(self, key: int) -> bool:
        idx1=self.hash1(key)
        if self.storage[idx1] is None:
            return False
        idx2=self.hash2(key)
        if self.storage[idx1][idx2] == True:
            return True
        else:
            return False


# Problem 2 : Min-Stack

# A separate array was created just for storing the minimum elements, so O(1) time for getting minimum element was possible

# Time Complexity : 
#   push()    -> O(1)
#   pop()     -> O(1)
#   top()     -> O(1)
#   getMin()  -> O(1)
# Space Complexity : O(N)
# Did this code successfully run on Leetcode : Yes
class MinStack:

    def __init__(self):
        self.stack=[]
        self.minstack=[]

    def push(self, val: int) -> None:
        if not self.minstack or val <= self.minstack[-1]:
            self.minstack.append(val)
        self.stack.append(val)

    def pop(self) -> None:
        if self.stack:
            v=self.stack.pop()
            if v == self.minstack[-1]:
                self.minstack.pop()


    def top(self) -> int:
        if self.stack:
            return self.stack[-1]

    def getMin(self) -> int:
        return self.minstack[-1]


