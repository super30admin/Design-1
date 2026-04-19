# Time Complexity: O(1)
# Space Complexity: O(n) 
# Two stacks: one for values, one tracking the running min at each push

"""
@author: chinmayprajapati
"""

class MinStack:

    def __init__(self):
        self.minstack = list()
        self.stack = list()

    def push(self, val: int) -> None:
        self.stack.append(val)
        if not self.minstack:
            self.minstack.append(val)
        else:
            self.minstack.append(min(self.minstack[-1],val))

    def pop(self) -> None:
        self.stack.pop()
        self.minstack.pop()
        
    def top(self) -> int:
        return self.stack[-1]

    def getMin(self) -> int:
        if self.minstack:
            return self.minstack[-1]
        