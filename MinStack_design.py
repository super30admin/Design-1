"""
Author: Srinidhi Bhat 
Time Complexity : O(1) - All Operation
Space Complexity : O(N) - In worst case all can be push operations 
Did this code successfully run on Leetcode : Yes - faster than 99.7% and memory less than 10%

Any problem you faced while coding this :No

Core Logic - 
Remaining Stack operations are same
To get Min in O(1) - Always maintain the minimum at every block as a tuple
the 1st position of tuple will be element and 2nd position will be the minimum found till that time
"""
class MinStack:

    def __init__(self):
        self.my_stack = []

    def push(self, x: int) -> None:
        #While pushing, maintain the structure - (element,minimum)
        if len(self.my_stack) == 0:
            self.my_stack.append((x,x))
        else:
            curr_min = self.my_stack[-1][1]
            if x < curr_min:
                curr_min = x
            self.my_stack.append((x,curr_min))

    def pop(self) -> None:
        return self.my_stack.pop()
    
    def top(self) -> int:
        return self.my_stack[-1][0] #since element is in 0th position

    def getMin(self) -> int:
        return self.my_stack[-1][1] #since minimum is in the 1st position

# Your MinStack object will be instantiated and called as such:
# obj = MinStack()
# obj.push(x)
# obj.pop()
# param_3 = obj.top()
# param_4 = obj.getMin()