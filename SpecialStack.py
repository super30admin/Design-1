import sys

class SpecialStack:
	SIZE = 100
	# Two stack approach
	def __init__(self):
		self.stack = []
		self.minstack = []
		self.minval = sys.maxsize
		self.minstack.append(self.minval)

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
			if val < self.minval:
				self.minval = val
			self.minstack.append(self.minval)
			self.stack.append(val)

	def st_pop(self):
		if self.isEmpty():
			print("Stack is empty")
		else:
			self.stack.pop()
			self.minstack.pop()
			self.minval = self.minstack[-1]

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