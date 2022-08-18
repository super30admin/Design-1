#Using 1-1 Mapping
"""
Time Complexity: O(1) for all the operations
Space Complexity: O(n)

Did this code successfully run on Leetcode : Yes
Any problem you faced while coding this : No


Your code here along with comments explaining your approach
- In this approach we can use 2 stacks.
- First stack will contain all the values and second stack will contain the minimum values
- We need two stack's and won't be able to implement this with only min variable because we will not have a reference of previous   min value when we pop an element.
"""
class MinStack:

    def __init__(self):
        self.__stack = []
        self.__minStack = []
        self.__min = inf
        self.__minStack.append(self.__min)
        
    def push(self, val: int) -> None:
        self.__min = min(self.__min, val)
        self.__stack.append(val)
        self.__minStack.append(self.__min)

    def pop(self) -> None:
        self.__stack.pop()
        self.__minStack.pop()
        self.__min = self.__minStack[-1]

    def top(self) -> int:
        return self.__stack[-1]

    def getMin(self) -> int:
        return self.__minStack[-1]


# Your MinStack object will be instantiated and called as such:
# obj = MinStack()
# obj.push(val)
# obj.pop()
# param_3 = obj.top()
# param_4 = obj.getMin()