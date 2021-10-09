# Time Complexity :O(1) all
# Space Complexity :O(N)
# Did this code successfully run on Leetcode :yes
# Any problem you faced while coding this : No
class MinStack:
    def __init__(self):
        self.stack = list()
        self.min = list()
    def push(self, x: int) -> None:
        if not self.stack or x < self.min[-1]:
            self.min.append(x)
        else:
            self.min.append(self.min[-1])
        self.stack.append(x)
    def pop(self) -> None:
        self.stack = self.stack[:-1]
        self.min = self.min[:-1]   
    def top(self) -> int:
        return self.stack[-1]
    def getMin(self) -> int:
        if not self.min: return None
        return self.min[-1]

if __name__ == '__main__':
  stack = MinStack() 
  stack.push(3)
  stack.push(5)
  print(stack.getMin())
  stack.push(2)
  stack.push(1)
  print(stack.getMin())  
  stack.pop()
  print(stack.getMin())
  stack.pop()
  stack.top()