#time_complexity: O(1) for every operation
#space complexity: O(n)
#can not figure a solution for space complexity

class MinStack:

	def __init__(self):
		"""
		initialize your data structure here.
		"""
		self.list_1 = []

	def push(self, x: int) -> None:
		min_final = x
		if len(self.list_1)!=0:
			val = self.list_1[-1]
			if val.get('min')<min_final:
				min_final = val.get('min')
		self.list_1.append({'num':x, 'min':min_final})
		

	def pop(self) -> None:
		self.list_1.pop()
		
	def top(self) -> int:
		return self.list_1[-1].get('num')

	def getMin(self) -> int:
		return self.list_1[-1].get('min')
		


# Your MinStack object will be instantiated and called as such:
# obj = MinStack()
# obj.push(x)
# obj.pop()
# param_3 = obj.top()
# param_4 = obj.getMin()