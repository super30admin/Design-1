class MinStack:
	def __init__(self):
		self.minVal = float('inf')
		self.stack = []
		self.minStack = []

	def push(self, val: int) -> None:
		self.stack.append(val)
		newMin = min(val, self.minVal)
		self.minStack.push(newMin)
		self.minVal = newMin

	def pop(self) -> None:
		# Methods pop, top and getMin operations will always be called on non-empty stacks.
		self.stack.pop()
		self.minStack.pop()
		if len(self.stack) == 0:
			self.minVal = float('inf')
		else:
			self.minVal = self.minStack[-1]

	def top(self) -> int:
		# Methods pop, top and getMin operations will always be called on non-empty stacks.
		return self.stack[-1]

	def getMin(self) -> int:
		# Methods pop, top and getMin operations will always be called on non-empty stacks.
		return self.minVal