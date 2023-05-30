#Time Complexity : O(n) ... n is number of elements 
#Space Complexity : O(n)
#Did this code successfully run on Leetcode : Yes
#Any problem you faced while coding this : faced some issue with the add function initially

#Used a list to store the elements of the stack and for determining the minimum element, I iterated over all the elements while searching for it.

class MinStack:

    def __init__(self):
        self.stack = []

    def push(self, val: int) -> None:
        self.stack.append(val)

    def pop(self) -> None:
        if len(self.stack) == 0:          
          return
        pop_item = self.stack.pop()
        return

    def top(self) -> int:
        return self.stack[-1]

    def getMin(self) -> int:
        minVal = 2147483647
        for val in self.stack:
            minVal = min(minVal,val)

        return minVal

# Your MinStack object will be instantiated and called as such:
# obj = MinStack()
# obj.push(val)
# obj.pop()
# param_3 = obj.top()
# param_4 = obj.getMin()