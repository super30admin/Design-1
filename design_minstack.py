class MinStack:


  def __init__(self):
    self.stack =[]
    self.min_stack =[]
    self.min_val = float('inf')

  def push(self,val)->None:
    self.stack.append(val)
    self.min_stack.append(val if val<self.min_val else self.min_val )
    self.min_val = self.min_stack[-1]


  def pop(self)->None:
    self.stack.pop()
    self.min_stack.pop()
    self.min_val = self.min_stack[-1] if self.stack else float('inf')


  def top(self)->int:
    return self.stack[-1]

  def getMin(self)->int:
    return self.min_stack[-1]


