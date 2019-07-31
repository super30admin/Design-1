import sys

class SpecialStack:
	SIZE = 100
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

	def push(self, val):
		if self.isFull():
			print("The stack is full. So, can't add more values")
		else:
			if val < self.minval:
				self.minval = val
			self.stack.append(val)

	def spop(self):
		if self.isEmpty():
			print("Stack is empty")
			return -1
		else:
			val = self.stack.pop()
			self.minval = self.stack[0]
			# Not an O(1) operation
			for i in self.stack[1:]:
				if i < self.minval:
					self.minval = i
			return val

	def getMin(self):
		return self.minval

if __name__ == "__main__":
	ss = SpecialStack()
	ss.push(10)
	ss.push(4)
	ss.push(0)
	print(ss.spop())
	print(ss.stack)
	print(ss.getMin())