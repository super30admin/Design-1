# Time Complexity : Every operation is done in O(1) time
# Space Complexity : O(n) where n is the number of values given to the stack
# Did this code successfully run on Leetcode : Yes  
# Any problem you faced while coding this : No  

# Three line explaination of the code: This implements a stack with O(1) min tracking by storing previous minimums alongside values. When pushing, if the new value is ≤ current min, it first saves the old min on the stack before updating the min. When popping, if the removed value is the current min, it restores the previous min by popping the saved value.

class MinStack:

    def __init__(self):
        self.st = []
        self.minval = sys.maxsize

    def push(self, val: int) -> None:
        if(val <= self.minval):
            self.st.append(self.minval)
            self.minval = val
        self.st.append(val)

    def pop(self) -> None:
        if not self.st:
            return
        popped = self.st.pop()
        if (popped == self.minval):
            self.minval = self.st.pop()

    def top(self) -> int:
        if not self.st:
            return -1

        return self.st[-1]
    
    def getMin(self) -> int:
        return self.minval



# Your MinStack object will be instantiated and called as such:
# obj = MinStack()
# obj.push(val)
# obj.pop()
# param_3 = obj.top()
# param_4 = obj.getMin()