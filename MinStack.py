// Time Complexity : O(1)
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : To keep track of the self.m element while pop operation

class MinStack:
	def __init__(self):
        """
        initialize your data structure here.
        """
        self.m = None
        self.stack = []
        self.n = 0
        

	# Add the element to the stack
    def push(self, x: int) -> None:
        self.stack.append(x)
        self.n +=1
        if self.m is None or x<self.m:
            self.m = x
        
    # Checks is the stack is Empty
    def isEmpty() -> bool:
        return False if self.n else True
    
    # Pops the element from the stack and keep track of min element
    def pop(self) -> None:
        t = self.stack.pop()
        self.n -=1
        if t == self.m:
            self.m = min(self.stack) if self.n != 0 else None
        return t

	# returns the top element of the stack
    def top(self) -> int:
        return self.stack[-1] if self.n else None
        
	# Gets the minimum element from the stack
    def getMin(self) -> int:
        return self.m
    
    
    
