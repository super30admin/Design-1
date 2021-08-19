  # // Time Complexity : O(1) for each function call made to MinStack class functions
  # // Space Complexity : O(n) where n is the number of elements in the stack 
  # // Did this code successfully run on Leetcode : yes
  # // Any problem you faced while coding this : while writing pop function - missed updating the global minima value


  # // Your code here along with comments explaining your approach

class MinStack:

        
    def __init__(self):
        """
        initialize your data structure here.
        """
        self.stack = []
        # using a variable to maintain 
        # min throughtout the stack calls
        self.min = float('inf')
        
    def push(self, val: int) -> None:
        # pushing element and min up to now as a tuple in the stack
        self.min = min(self.min,val)
        self.stack.append((val,self.min))

    def pop(self) -> None:
        self.stack.pop()
        # assigning current minimum value to global minima based on
        # status of the stack 
        if not self.stack:
            self.min = float('inf')
        else:
            self.min = self.stack[-1][1]

    def top(self) -> int:
        # in O(1) returning top most element
        return self.stack[-1][0] if self.stack else None

    def getMin(self) -> int:
        # in O(1) returning minimum element seen so far
        return self.stack[-1][1] if self.stack else None
