# // Time Complexity : O(1)
# // Space Complexity : O(n)
# // Did this code successfully run on Leetcode : Yes
# // Any problem you faced while coding this : No


class MinStack:

    def __init__(self):
        # Initialize stack
        self.minStack = []   

    def push(self, val: int) -> None:
        
        # if empty stack append val for both vaa and min
        if not self.minStack:
            self.minStack.append((val,val))
            return
        
        # compare the val with current min
        current_min = self.minStack[-1][1]
        self.minStack.append((val, min(current_min, val)))

    def pop(self) -> None:
        self.minStack.pop()

    def top(self) -> int:
        return self.minStack[-1][0]

    def getMin(self) -> int:
        return self.minStack[-1][1]

# Your MinStack object will be instantiated and called as such:
# obj = MinStack()
# obj.push(val)
# obj.pop()
# param_3 = obj.top()
# param_4 = obj.getMin()