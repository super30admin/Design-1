"""
// Time Complexity :O(1) All stack operations in constant time
// Space Complexity :O(n)
// Did this code successfully run on Leetcode :YES
// Any problem you faced while coding this :NA
"""
class MinStack:

    def __init__(self):
        self.stack = []
        self.minstack = [ ]
        self.minvalue = float("inf")

    def push(self, x: int) -> None:
        self.stack.append(x)
        if x < self.minvalue:
            self.minvalue = x
        self.minstack.append(self.minvalue)

    def pop(self) -> None:
        #print("stack = ",self.stack,"minstack = ",self.minstack,"min =",self.minvalue)
        self.stack.pop()
        self.minstack.pop()
        if len(self.minstack) > 0 :
            self.minvalue = self.minstack[-1]
        else:
            self.minvalue =  float("inf")

    def top(self) -> int:
        return self.stack[-1]

    def getMin(self) -> int:
        return self.minvalue


# Your MinStack object will be instantiated and called as such:
# obj = MinStack()
# obj.push(x)
# obj.pop()
# param_3 = obj.top()
# param_4 = obj.getMin()

if __name__ == "__main__":
  ss = MinStack()
  ss.push(3)
  ss.push(6)
  ss.push(9)
  print(ss.pop())
  print(ss.stack)
