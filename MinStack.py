// Time Complexity : O(1)
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this :


// Your code here along with comments explaining your approach
class MinStack:

    def __init__(self):
       self.stack = []
       self.minstack = []
       self.min = sys.maxsize 

    def push(self, val: int) -> None:
        self.stack.append(val)
        if val<=self.min:
            self.minstack.append(val)
            self.min = val
        else:
            self.minstack.append(self.min)

    def pop(self) -> None:
        self.stack.pop()
        self.minstack.pop()
        if self.minstack:
            self.min = self.minstack[-1]
        else:
            self.min = sys.maxsize

    def top(self) -> int:
        return self.stack[-1]

    def getMin(self) -> int:
        if self.minstack:
            return self.minstack[-1]
        else:
            return None
