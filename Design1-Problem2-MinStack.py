"""
Problem 2
155. Min Stack
Time Complexity : 
    All operation is O(1)

Space Complexity : O(N) for both the stack used

Did this code successfully run on Leetcode : yes



Two stacks are used to store the value
The first stack contains the push values 
The second stack stores the min value at the time of push by comparing the minstak top valye with
the current value


    

@name: Rahul Govindkumar_RN27JUL2022
"""

class MinStack:

    def __init__(self):
        
        self.stack = []
        self.minStack =[]
        

    def push(self, val: int) -> None:
        
        self.stack.append(val)
        
        val = min(val, self.minStack[-1] if self.minStack else val )
        
        self.minStack.append(val)
        
        

    def pop(self) -> None:
        
        self.stack.pop()
        self.minStack.pop()
        

    def top(self) -> int:
        
        return self.stack[-1]

    def getMin(self) -> int:
        return self.minStack[-1]
        


# Your MinStack object will be instantiated and called as such:
# obj = MinStack()
# obj.push(val)
# obj.pop()
# param_3 = obj.top()
# param_4 = obj.getMin()