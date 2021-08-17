# Did this code successfully run on Leetcode : YES

class MinStack:

	def __init__(self):
		"""
		initialize your data structure here.
		Overall SC: O(N)
		where N is total number of elements inserted
		"""
		self.stack = []

	def push(self, val: int) -> None:
		"""
		Insert element into stack
		TC: O(1)
		---------
		arguments:
		val: int, value to insert into stack
		----------
		returns:
		None
		"""
		if not self.stack:
			self.stack.append([val, val])
		else:
			self.stack.append([val, min(val, self.stack[-1][1])])
		

	def pop(self) -> None:
		"""
		Pop topmost element from stack
		TC: O(1)
		-----------
		arguments:
		None
		----------
		returns:
		None
		"""
		self.stack.pop()
		

	def top(self) -> int:
		"""
		Get top element of stack without popping
		TC: O(1)
		-----------
		arguemnts:
		None
		----------
		returns:
		val: int, top most item in stack
		"""
		return self.stack[-1][0]
		

	def getMin(self) -> int:
		"""
		Get minimum element of stack in O(1) time
		----------
		approach:
		when inserting any item, keep track of minimum value at that stage
		hence stack is designed to take tuples as input
		tuple = (value, minimmum of stack)
		if new value to insert into stack is smaller than current minimum: update minimum
		else: minimum is not changed
		this approach enables getting min value in O(1) time by peeking at the top most item
		---------
		arguemnts:
		None
		--------
		returns:
		minimum: int, minimum value in stack currently
		"""
		return self.stack[-1][1]
		


# Your MinStack object will be instantiated and called as such:
# obj = MinStack()
# obj.push(val)
# obj.pop()
# param_3 = obj.top()
# param_4 = obj.getMin()