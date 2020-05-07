"""
// Time Complexity :O(1) All stack operations in constant time
// Space Complexity :O(n)
// Did this code successfully run on Leetcode :YES
// Any problem you faced while coding this :NA
"""
import sys
class MinStack:
  size = 100
  def __init__(self):
    self.stack = []
    self.minval = sys.maxsize

  def push(self, x: int) -> None:
    if self.isFull():
      print("Stack is full")
    else:
      if x < self.minval:
        self.minval = x
      self.stack.append(x)

  def pop(self) -> None:
    if self.isEmpty():
        print("Stack is empty")
        return -1
    else:
      value = self.stack.pop()
      self.minval = self.stack[0]

      for i in self.stack[1:]:
        if i< self.minval:
          self.minval = i
      return value

  def isEmpty(self):
    if len(self.stack)==0:
      return True
    else:
      return False

  def isFull(self):
    if len(self.stack) == self.size:
      return True
    else:
      return False

  def top(self) -> int:
    return self.stack[-1]

  def getMin(self) -> int:
    return  self.minval

if __name__ == "__main__":
  ss = MinStack()
  ss.push(3)
  ss.push(6)
  ss.push(9)
  print(ss.pop())
  print(ss.stack)
