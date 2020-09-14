# Design minstack 
# Time Complexity = All operations in O(1)
# Space Complexity = O(n)
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : No

# Code along with comments explaining the approach

class MinStack:

    def __init__(self):
        
        self.stack = []

    def push(self, x):
        # Inset two elements in stacks (current,global_minmum of stack)
        if not self.stack:
            self.stack.append((x,x))
        else:
            # Keeping second element as minimum always
            self.stack.append((x,min(x,self.stack[-1][1])))

    def pop(self):
        if self.stack:
            self.stack.pop()
        

    def top(self):
        # Get the first element of top of stack, which is current element i.e. stack[-1][0]
        if self.stack:
            return self.stack[-1][0]
        else:
            return None

    def getMin(self):
        # Get the second element of top of stack, which is current element i.e. stack[-1][1]
        if self.stack:
            return self.stack[-1][1]
        else:
            return None
        


# Your MinStack object will be instantiated and called as such:
# obj = MinStack()
# obj.push(x)
# obj.pop()
# param_3 = obj.top()
# param_4 = obj.getMin()