import sys

class SpecialStack:
	SIZE = 100
	# One stack approach
	def __init__(self):
		self.stack = []
		self.minval = sys.maxsize

	def isEmpty(self):
		if len(self.stack) == 0:
			return True
		else:
			return False

	def isFull(self):
		if len(self.stack) == self.SIZE:
			return True
		else:
			return False

	def st_push(self, val):
		if self.isFull():
			print("The stack is full. So, can't add more values")
		else:
			if val <= self.minval:
				self.stack.append(self.minval)
				self.minval = val
			self.stack.append(val)

	def st_pop(self):
		if self.isEmpty():
			print("Stack is empty")
		else:
			x = self.stack.pop()
			if x == self.minval:
				self.minval = self.stack.pop()

	def st_top(self):
		return self.stack[-1]

	def getMin(self):
		return self.minval

if __name__ == "__main__":
	ss = SpecialStack()
	ss.st_push(5)
	ss.st_push(9)
	print(ss.getMin())
	ss.st_push(4)
	print(ss.getMin())
	ss.st_pop()
	ss.st_push(12)
	print(ss.getMin())
	ss.st_pop()
	ss.st_push(3)
	print(ss.getMin())
	ss.st_pop()
	print(ss.getMin())
	ss.st_pop()
	print(ss.getMin())
	ss.st_pop()
	print(ss.getMin())