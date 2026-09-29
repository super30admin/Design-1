// Time Complexity : O(1)
// Space Complexity : O(N)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach
#I have used 2 stacks and pushed only the minimum element in the minStack if the minStack is empty or if the element in minStack is less than or equal to current element
#If the minStack contains the element which is same as pop element then we pop from minStack as well

class MinStack:

    def __init__(self):
        self.stack = []
        self.minStack = []

    def push(self, value: int) -> None:
        self.stack.append(value)
        if not self.minStack or self.minStack[-1] >= value:
            self.minStack.append(value)

    def pop(self):
        if self.stack.pop() == self.minStack[-1]:
            self.minStack.pop()

    def top(self) -> int:
        return self.stack[-1]

    def getMin(self) -> int:
        return self.minStack[-1]