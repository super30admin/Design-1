# // Time Complexity : O(1) for all ops
# // Space Complexity : O(n)
# // Did this code successfully run on Leetcode : Yes
# // Any problem you faced while coding this : No
# Approach: maintain a list with two elements in each index 
#arr[i] = [current element, min element till here]

class MinStack:

    def __init__(self):
        self.stack = []
        

    def push(self, val: int) -> None:
        if not self.stack:
            self.stack.append([val, val])
            return 
        self.stack.append([val, min(val, self.stack[-1][1])])

    def pop(self) -> None:
        if not self.stack:
            return
        self.stack.pop()
        

    def top(self) -> int:
        if not self.stack:
            return float("-inf")
        return self.stack[-1][0]
        

    def getMin(self) -> int:
        if not self.stack:
            return float("-inf")
        return self.stack[-1][1]
        


# Your MinStack object will be instantiated and called as such:
# obj = MinStack()
# obj.push(val)
# obj.pop()
# param_3 = obj.top()
# param_4 = obj.getMin()