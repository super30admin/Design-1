# Time Complexity : o(1) all operations
# Space Complexity : o(n) where n is the max length of stack
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : No
        


# Your MinStack object will be instantiated and called as such:
# obj = MinStack()
# obj.push(val)
# obj.pop()
# param_3 = obj.top()
# param_4 = obj.getMin()

class MinStack:

	def __init__(self):
		self.stack = []

    #Push the current minimum element along with the new value as a tuple. 
	def push(self, val: int) -> None: 
		if not self.stack:
			self.stack.append((val, val)) 
		else:
			self.stack.append((val, min(val, self.stack[-1][1])))

    #Pop the tuple at the top
	def pop(self) -> None:
		if self.stack:
			self.stack.pop()

    #return the value of the top tuple at index 0 
	def top(self) -> int:
		if self.stack:
			return self.stack[-1][0]
		else:
			return None

    #return the minimum value from the top tuple at index 1 
	def getMin(self) -> int:
		if self.stack:
			return self.stack[-1][1]
		else:
			return None