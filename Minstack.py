# time complexity: O(1)
# space complexity: O(N) 
# max number of elements in stack- worst case: all pushes

# Approach:
# have two stacks and a variable min. 
# min is the minimum of the value and the present minimum value.
# push min into second stack.
# whenever pop happens, pop from first stack and second stack. 
# top of second stack is the new min.

import math
class MinStack:

    def __init__(self):
        self.stack = []
        self.minstack = []
        self.mini = math.inf
        #self.minstack.append(min)
        
        

    def push(self, val: int) -> None:
        self.mini = min(self.mini,val)
        self.stack.append(val)
        self.minstack.append(self.mini)
        
        

    def pop(self) -> None:
        self.stack.pop()
        self.minstack.pop()
        if self.minstack:
            self.mini = self.minstack[-1]
        else:
            self.mini = math.inf
        

    def top(self) -> int:
        return self.stack[-1]
        

    def getMin(self) -> int:
        return self.minstack[-1]
        


# Your MinStack object will be instantiated and called as such:
# obj = MinStack()
# obj.push(val)
# obj.pop()
# param_3 = obj.top()
# param_4 = obj.getMin()