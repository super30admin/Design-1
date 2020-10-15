# Time complexity: O(n) Worst, Average case is O(1)
# Space Complexity: O(n)

class MinStack:

    def __init__(self):
        """
        initialize your data structure here.
        """
        self.stack = []  # array of tuples     

    def push(self, x: int):
        
        if not self.stack:
            self.stack.append( (x,x) )
        else:
            last = self.stack[-1]
            curr_min = last[1]
            self.stack.append( (x, min(x,curr_min)) )
        
    def pop(self):
        
        if not self.stack:
            return
        else:
            self.stack.pop()
       

    def top(self):
        if not self.stack:
            return None
        else:
            last = self.stack[-1]
            return last[0]
        

    def getMin(self):
        
        if not self.stack:
            return None
        else:
            last = self.stack[-1]
            return last[1]
              

# Your MinStack object will be instantiated and called as such:
# obj = MinStack()
# obj.push(x)
# obj.pop()
# param_3 = obj.top()
# param_4 = obj.getMin()