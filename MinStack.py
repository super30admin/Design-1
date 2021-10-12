# Time Complexity : O(1)
# Space Complexity : O(n)
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : No
class MinStack:
  def __init__(self):
    self.stack = []
    self.min = 9999999999999

  def push(self, val: int) -> None:
    if val <= self.min:
      self.stack.append(self.min)
      self.min = val
    self.stack.append(val)            

  def pop(self) -> None:
    if self.stack.pop(len(self.stack) - 1) == self.min:
      self.min = self.stack.pop(len(self.stack) - 1)

  def top(self) -> int:
    return self.stack[len(self.stack) - 1]        

  def getMin(self) -> int:
    return self.min
        


# Your MinStack object will be instantiated and called as such:
obj = MinStack()
obj.push(5)
print(obj.getMin())
obj.push(4)
print(obj.getMin())
obj.push(2)
print(obj.getMin())
obj.push(2)
obj.pop()
print(obj.getMin())
obj.push(10)
print(obj.getMin())
print(obj.top())
print(obj.getMin())