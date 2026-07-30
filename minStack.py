# Time Complexity : O(1)
# Space Complexity : O(N)
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : had to use module division when calculating key hash for secondary array.


# Your code here along with comments explaining your approach
class MinStack:

    #Defining 2 stacks, seocnd stack will be used to define the minimum value at each stage of the main stack. This helps in retrieving the minimum value in O(1) time.
    def __init__(self):
        self.stack = []
        self.minStack = [float('infinity')]
        
    #Pushes a value onto the stack and updates the minStack with the minimum value at this stage.
    def push(self, val: int) -> None:
        self.stack.append(val)
        min = self.minStack[-1]
        if val < min:
            self.minStack.append(val)
        else:
            self.minStack.append(min)
        

    #Removes the top element from the stack and updates the minStack accordingly.
    def pop(self) -> None:
        self.stack.pop()
        self.minStack.pop()
        

    #Returns the top element of the stack without removing it.
    def top(self) -> int:
        return self.stack[-1]
        

    #Retrieves the minimum element in the stack in O(1) time.
    def getMin(self) -> int:
        return self.minStack[-1]
        


# Your MinStack object will be instantiated and called as such:
# obj = MinStack()
# obj.push(val)
# obj.pop()
# param_3 = obj.top()
# param_4 = obj.getMin()