class MinStack:

    def __init__(self):
        """
        initialize your data structure here.
        """
        self.stack = []
        self.min_stack = []
        

    def push(self, x: int) -> None:
        self.stack.append(x)
        if not self.min_stack or x<=self.min_stack[-1]:
            self.min_stack.append(x)

    def pop(self) -> None:
        if self.min_stack[-1] == self.stack[-1]:
            self.min_stack.pop()
        self.stack.pop()
        
        

    def top(self) -> int:
        return self.stack[-1]

    def getMin(self) -> int:
        return self.min_stack[-1]
            

#Time complexity O(1)
#Space complexity O(n)
#Did this code successfully run on Leetcode : Yes
#Any problem you faced while coding this : 


#Your code here along with comments explaining your approach
# Created two stack one of Minimum stack and other normal stack. Appending the value in it if the value pushed in normal stack
# is lower then value already in minimum stack. And take the min_stack value only if the top element of both stacks matches.