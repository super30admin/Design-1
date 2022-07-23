#Time Complexity:: push() - O(1), pop - O(1), top() - O(1), getMin() - O(1)
#Space Complexity:: O(n) where n is the maximum number of elements in the stack 
#Did this code successfully run on Leetcode : Yes
#Any problem you faced while coding this : No


import collections
class MinStack(object):    
    def __init__(self):
        self.min_ = collections.deque()  #min_ is our minimum stack
        self.nums = collections.deque()  #nums is our normal stack

    def push(self, val):
        self.nums.append(val)   #always append the value in nums stack
        if not self.min_ or val <= self.min_[-1]: #if there is no value in min_ stack or the last element in the min stack is greater than current incoming val, append the val to minstack
            self.min_.append(val)
        
    def pop(self):
        val = self.nums.pop()   #assign last element in nums stack to val
        if val == self.min_[-1]:  #if the value is equal to the last element in min stack, remove it
            self.min_.pop()

    def top(self):
        return self.nums[-1] #top means the last element from nums stack

    def getMin(self):
        return self.min_[-1] #get min means the last element from the min stack