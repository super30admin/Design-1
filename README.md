Explain your approach in **three sentences only** at top of your code

# Design-1

## Problem 1:(https://leetcode.com/problems/design-hashset/)

# Time Complexity : O(K) where k represents the time for any bucket with largest amount of collisions otherwise assuming there are no collisions this would be O(1)
# Space Complexity : O(N)
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : No but would have been helpful to have a function pre defined for implementing the hash function
# This hashset implementation is utilizing seperate chaining where each bucket in the hashset is a dynamic list that can store multiple elements, in any of our operations 
# we calculate the the bucket index first and then once this is determined we can execute the operation on the list in that given bucket



class MyHashSet:

    def __init__(self):
        self.size = 500
        self.buckets = [[] for x in range(self.size)] # creating a seperate list for each possible hash value
    
    def hash_val(self,key):
        return key % self.size # seeting our hash function

    def add(self, key: int) -> None:
        index_of_bucket = self.hash_val(key) # generating hash value for the given key
        if key not in self.buckets[index_of_bucket]: # if key does not exsist append it to the list at the bucket index
            self.buckets[index_of_bucket].append(key) # if a collision occurs both values will be in the same bucket but will be 2 different distinct elements in our list

    def remove(self, key: int) -> None:
        index_of_bucket = self.hash_val(key)
        if key in self.buckets[index_of_bucket]: # generating hash value and then searching within that bucket location to see if the key exsists
            self.buckets[index_of_bucket].remove(key) # removes the key from the specified bucket

    def contains(self, key: int) -> bool:
        index_of_bucket = self.hash_val(key)
        return key in self.buckets[index_of_bucket] # generating hash value and then searching within that bucket location to see if the key exsists


# Your MyHashSet object will be instantiated and called as such:
# obj = MyHashSet()
# obj.add(key)
# obj.remove(key)
# param_3 = obj.contains(key)

## Problem 2:
Design MinStack (https://leetcode.com/problems/min-stack/)

# Time Complexity : O(1) for all operations
# Space Complexity : O(N)
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : No
# We are using a double stack approach one which will act as our primary stack and the other which will only update when a minimum value is introduce or removed this allows use to keep the stacks in sync so we can utilize any operation in O(1) time
class MinStack:

    def __init__(self):
        self.stack = []
        self.min_stack = []

    def push(self, val: int) -> None:
        self.stack.append(val) # when we append we also check to see if our min stack is empty or if the value we appended is smaller then the current val in our min stack if so append the val to min stack
        if not self.min_stack or val <= self.min_stack[-1]:
            self.min_stack.append(val)
    def pop(self) -> None:
        if self.stack:
            if self.stack[-1] == self.min_stack[-1]: # if the top index in our min stack is equal to the top val in our stack we remove both otherwise we only remove from the main stack
                self.min_stack.pop()
            self.stack.pop()
        else:
            return None
    def top(self) -> int:
        if self.stack:
            return self.stack[-1] # return the last element in our list which is the first element in our stack
        else:
            return None

    def getMin(self) -> int:
        if self.min_stack:
            return self.min_stack[-1] # returns lowest val in our minstack which will be the last element in the list 
        else:
            return None

