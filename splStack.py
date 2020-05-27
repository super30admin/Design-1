'''
 Design a SplStack that supports all the stack operations push, pop, isEmpty, isFull and an operation getMin() which should return minimum element from the SplStack. All these operations must be O(1). To implement this, you should only use standard Stack data structure.
'''
# Time Complexity : O(1)
# Space Complexity : O(n)
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : Yes

'''
I have used 2 stacks - one to act as a regular stack and the other one to hold only the minimum element by comparing each element as they come in with the top element.
'''

from collections import deque
import sys

class MinStack():

    def __init__(self):
        self.stack1 = deque()
        self.stack2 = deque()
        

    def push(self, x):

        if self.stack2:
            if x <= self.peep(self.stack2):
                self.stack2.append(x)         
        else:
            self.stack2.append(x)
            
        self.stack1.append(x)
        

    def pop(self):
        
        if self.stack1:
            popped_element = self.stack1.pop()
        
            if self.stack2 and popped_element == self.peep(self.stack2):
                _ = self.stack2.pop()
            
            return popped_element

    def peep(self, stack):
        if stack:
            return stack[-1]
    
    def isEmpty(self):
        return True if self.stack1 else False


    def top(self):
        if self.stack1:
            return self.stack1[-1]

    def getMin(self):
        if self.stack2:
            return self.stack2[-1]


