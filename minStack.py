# Time Complexity : 
#   push(): O(1)
#   pop(): O(1) 
#   getMin(): O(1) 
#   top(): O(1)

# Space Complexity :
#   Required Stack: O(N)
#   Minimum Stack: O(N) in the worst case when the data stream is in reverse order

# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : No


class MinStack:

    def __init__(self):
        self.stack = [] #Contains all the data
        self.minStack = [] #The minimum element in the data steam will always be on the top of minStack
    
    def push(self, val: int) -> None:
        ''' Always push to self.stack
            If self.stack is empty, i.e., self.minStack is also empty. Push to minStack.
            If val is less than or equal to top(minStack). Push to minStack.
        '''
        if not self.stack:
            self.minStack.append(val)
        elif val <= self.minStack[-1]:
            self.minStack.append(val)
        self.stack.append(val)
        
    def pop(self) -> None:
        '''
            Always pop from self.stack
            If popped element is also on top of self.minStack. Pop minStack.
        '''
        poppedEle = self.stack.pop()
        if poppedEle == self.minStack[-1]:
            self.minStack.pop()

    def top(self) -> int:
        return self.stack[-1]
        

    def getMin(self) -> int:
        return self.minStack[-1]