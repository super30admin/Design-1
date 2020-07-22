# Time Complexity : 
	# push: O(1)
	# pop: O(1)
	# top: O(1)
	# getMin: O(1)
# Space Complexity : O(n)
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : First tried to use a single variable that points to the min element,
	# but that increased the time complexity, as this variable needs to be updated everytime a min element is poped


# // Your code here along with comments explaining your approach
class MinStack:

    def __init__(self):
        """
        initialize your data structure here.
        """
        self.stack = []
        self.minStack = []

    def push(self, x: int) -> None:
        if len(self.stack) == 0 or self.minStack[-1] >= x:
            self.minStack.append(x)
            
        self.stack.append(x)

    def pop(self) -> None:
        if self.stack.pop(-1) == self.minStack[-1]:
            self.minStack.pop(-1)

    def top(self) -> int:
        return self.stack[-1]

    def getMin(self) -> int:
        return self.minStack[-1]


# Your MinStack object will be instantiated and called as such:
# obj = MinStack()
# obj.push(x)
# obj.pop()
# param_3 = obj.top()
# param_4 = obj.getMin()