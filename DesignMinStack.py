# Time Complexity : O(1) for all operations
# Space Complexity : 
    #we are maintaing two stacks each of length "n" so overall space complexity will be O(2n) -> O(n)
#  Did this code successfully run on Leetcode : Yes
#  Any problem you faced while coding this :
    #None

#  Your code here along with comments explaining your approach

class MinStack:

    #initialize stack and minimum stack
    def __init__(self):
        self.stack = []
        self.minStack = []

    #if we want to push to stack,
    #we need to check the top element of the minStack and append the minimum of the top element and the current value
    #and then bydefault adding the value to our stack
    def push(self, val: int) -> None:
        
        if self.minStack:
            top = self.minStack[-1]
            self.minStack.append(min(top, val))
        else:
            self.minStack.append(val)
        self.stack.append(val)

    #popping from both stack and minStack  
    def pop(self) -> None:
        if self.stack and self.minStack:
            self.stack.pop()
            self.minStack.pop()

    #get the top element from the stack
    def top(self) -> int:
        return self.stack[-1]

    #get the top element from the minStack
    def getMin(self) -> int:
        return self.minStack[-1]
        


# Your MinStack object will be instantiated and called as such:
# obj = MinStack()
# obj.push(val)
# obj.pop()
# param_3 = obj.top()
# param_4 = obj.getMin()