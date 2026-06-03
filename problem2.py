# Problem 2:
# Design MinStack (https://leetcode.com/problems/min-stack/)

# Time Complexity : O(1)
# Space Complexity : O(n)
# Did this code successfully run on Leetcode : yes
# Any problem you faced while coding this :no

class MinStack:
    # since O(1) all we can have 2 stacks where when we push we push value to 1 and curr_min to anothercurr_min will update if curr_val < curr_min and then pop from both stacks so we can access curr_min at any time looking at min stack peek
    # approach2: use 1 stack where do we fail if we try simple approach of  having a min variable and a single stack ?  we fail when we pop out curr_min element then we did not know what was the prev min  so can we do one thing whenever we have a new value <= curr_min we push the old min first and then on top of it push new value (think simple approach we would fail what was the prev min this adresses that) please note that this we should push old min even if new value is equal to the old min
    #below in approach 2
    def __init__(self):
        self.stack = []
        self.min = float('inf')

    def push(self, val: int) -> None:
        if val <= self.min:
            self.stack.append(self.min)
            self.min = val
        self.stack.append(val)
        return

    def pop(self) -> None:
        if not self.stack:
            return 
        top_val = self.stack.pop()
        if top_val == self.min:
            self.min = self.stack.pop()
        return
        

    def top(self) -> int:
        return self.stack[-1]

    def getMin(self) -> int:
        return self.min

        


# Your MinStack object will be instantiated and called as such:
# obj = MinStack()
# obj.push(val)
# obj.pop()
# param_3 = obj.top()
# param_4 = obj.getMin()