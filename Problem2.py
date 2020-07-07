class MinStack:

	def __init__(self):
		"""
		initialize your data structure here.
		"""
		self.stack=[]
		

	def push(self,x):
		cur_min=self.getMin()
		if cur_min==None or x<cur_min:
			cur_min=x
		self.stack.append((x,cur_min))
		

	def pop(self):
		self.stack.pop()
		

	def top(self) :
		if not self.stack:
			return None
		
		return self.stack[-1][0]
		
		

	def getMin(self):
		if not self.stack:
			return None
		#stack[-1][1] means last element (-1) and (1) here is for the minimum element
		return self.stack[-1][1]
	#(-2,-2),(0,-2),(-3,-3)
		
		


#Your MinStack object will be instantiated and called as such:
obj = MinStack()
obj.push(-2)
obj.push(0)
obj.push(-3)
obj.pop()

param_3 = obj.top()
print("Top element is")
print(param_3)
param_4 = obj.getMin()
print("minimum element is")
print(param_4)