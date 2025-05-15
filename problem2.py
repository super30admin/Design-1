# Time Complexity :
# push(): O(1)
# pop(): O(1)
# top(): O(1)
#getMin() : O(1)

# Space Complexity : O(N) N->Size of the input 

# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : No
#Approach: One stack to store the current values and the min_stack to store the minimum values this way we can get 
# Minimum value also in O(1) time
#So get Min() always return the top of the stack and when performing pop() even this min_stack is being popped

class MinStack:

    def __init__(self):
        self.stack = []
        self.min_stack = []
        

    def push(self, val: int):
        self.stack.append(val)
        if not self.min_stack or val <= self.min_stack[-1]:
            self.min_stack.append(val)
        else:
            self.min_stack.append(self.min_stack[-1])
        

    def pop(self):
        if self.stack:
            self.stack.pop()
            self.min_stack.pop()
        

    def top(self):
        return self.stack[-1]
        

    def getMin(self):
        return self.min_stack[-1]

# Your MinStack object will be instantiated and called as such:
# obj = MinStack()
# obj.push(val)
# obj.pop()
# param_3 = obj.top()
# param_4 = obj.getMin()