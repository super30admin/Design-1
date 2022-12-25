#Without 1-1 mapping

"""
# Space Complexity: O(n) as in worst case n elements can be store in the stack
# Time Complexity: O(1)

Did this code successfully run on Leetcode : Yes
Any problem you faced while coding this : No


Your code here along with comments explaining your approach
- In this approach we are going to use only one stack and minimum val will be push only when there is change in minimum value
- While doing pop operation 2 elements will be popped if the current pooped value is same as the minimum value and minimum value will be updated to the next pooped value which is nothing but the previous minimum value.
"""
class MinStack:

    def __init__(self):
        self.__stack = []
        self.__min = inf
        
    def push(self, val: int) -> None:
        if self.__min >= val:
            self.__stack.append(self.__min)
            self.__min = val
        self.__stack.append(val)
        
    def pop(self) -> None:
        if self.__min == self.__stack.pop():
            self.__min = self.__stack.pop()

    def top(self) -> int:
        return self.__stack[-1]

    def getMin(self) -> int:
        return self.__min


# Your MinStack object will be instantiated and called as such:
# obj = MinStack()
# obj.push(val)
# obj.pop()
# param_3 = obj.top()
# param_4 = obj.getMin()