"""
Push : This approach tries to push element in a min stack only when its lower than the previous value of minstack or empty and push all the 
elements in the normal stack and maintain its top index.
Pop : Pop elements from normal stack by decreasing its top value and if the stack top value is found in minstack decrement the min index
Top and Getmin will give the top element in the respective stacks
// Time Complexity : O(1) per function
// Space Complexity : O(1) per function
"""

class MinStack:

    def __init__(self):
        self.stack = [0]*1000 # fixed-size array (of 10,000) that acts as the main stack, storing all the elements.
        self.minStack = [0]*1000 #Another array of the same size that stores the current minimum at each level.
        self.top_index = -1  #Keeps track of the top element index in self.stack.
        self.min_index = -1  #Keeps track of the top index in min_stack, which represents the current minimum value.

    def push(self, val: int) -> None:
        self.top_index += 1
        self.stack[self.top_index] = val
        
        if self.min_index == -1 or val <= self.minStack[self.min_index]:
            self.min_index+=1
            self.minStack[self.min_index] = val

    def pop(self) -> None:

        if self.top_index == -1:
            return None

        if self.stack[self.top_index] == self.minStack[self.min_index]:
            self.min_index-=1
        self.top_index-=1
        
    def top(self) -> int:

        if self.top_index == -1:
            return None
        return self.stack[self.top_index]
        
    def getMin(self) -> int:

        if self.min_index == -1:
            return None
        return self.minStack[self.min_index]
        
