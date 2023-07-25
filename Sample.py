# Time Complexity :o(1)
 #Space Complexity :O(n)
#Did this code successfully run on Leetcode :yes
 # Any problem you faced while coding this : method to pop the top element and comarision of min element

class MinStack:
  # It initializes an empty list stack as an instance variable to represent the stack.
    def __init__(self):
        self.stack = []
        
       
      # The push method is used to add an element to the stack. 
      # It takes an integer x as an input parameter, representing the value to be pushed.
        

    def push(self, x: int) -> None:
        
        # If the stack is empty, then the min value
        # must just be the first value we add
        if not self.stack:
            self.stack.append((x, x))
            return

    # If the stack is not empty, the method first retrieves the current minimum value from the top of the stack (the second element of the tuple).
    #  Then, a new tuple containing the value (x) and the updated minimum value (min(x, current_min)) is appended to the stack.
        current_min = self.stack[-1][1]
        self.stack.append((x, min(x, current_min)))
        
       # The pop method is used to remove the top element from the stack. 
    def pop(self) -> None:
        self.stack.pop()
      # retrives the top element  

    def top(self) -> int:
        return self.stack[-1][0]
       # retrives the minimum value from the stack 

    def getMin(self) -> int:
        return self.stack[-1][1]