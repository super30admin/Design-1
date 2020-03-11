"""
// Time Complexity : O(1) for all operations
// Space Complexity : O(n) for storing elements in the stack
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : None
// Your code here along with comments explaining your approach
Algorithm explanation
1) push, pop and top similar to precourse exercise
2) Implementing min
    - We basically initialize the stack with tracking min_element
    - At each push operation, we update the min based on comparing the stack
    top and currently element
    - Fetching min, we just return the top's min value
"""
class MinStack:

    def __init__(self):
        """
        initialize your data structure here.
        """
        self.stk = [(-1,float("inf"))]

    def push(self, x: int) -> None:
        self.stk.append([x,min(x,self.stk[-1][1])])

    def pop(self) -> None:
        if self.stk:
            self.stk.pop()

    def top(self) -> int:
        return self.stk[-1][0] if self.stk else None

    def getMin(self) -> int:
        return self.stk[-1][1]


# Your MinStack object will be instantiated and called as such:
# obj = MinStack()
# obj.push(x)
# obj.pop()
# param_3 = obj.top()
# param_4 = obj.getMin()