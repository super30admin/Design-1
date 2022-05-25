class MinStack:
  def __init__(self):
    self.size = 10
    self.l = list()
    self.m = float("inf")


  def push(self, val: int) -> None:
    if len(self.l) <= self.size:
      self.l.append([val, min(val, self.m)])
    else:
      print("Stack is at it's capacity")


  def pop(self) -> None:
    if(len(self.l) > 0):
      self.l.pop()
    else:
      print("stack is empty")
  
  def top(self) -> int:
    if(len(self.l)):
      return self.l[-1][0]
    else:
      print("Stack is empty")
   
    
  def getMin(self) -> int:
    if(len(self.l) > 0):
      return self.l[-1][1]
    else:
      return float("inf")
    
  def isFull(self) -> int:
    if(len(self.l) == size):
      print("Stack is Full")
    else:
      print("Stack is not Full")
   
      
  def isEmpty(self) -> int:
    if( not len(self.l)):
      print("Stack is Empty")
    else:
      print("stack is not Empty")
  
  
