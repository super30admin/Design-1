# Submitted  in leetcode
# T.C: O(1) 
# S.C: O(n)




class MinStack:
    
#     Create a array stack
# Have one stack to add values
# 2nd stack to store the min of current and stack's min

    def __init__(self):
        self.stack = []
        self.minStack = []
        

    def push(self, val: int) -> None:
#         Append elements in stack
        self.stack.append(val)
#     Check if minstack is empty before append
        if len(self.minStack) == 0:
            self.minStack.append(val)
#         compare the minStack top and the current element and append the least to theminStack
        else:
            less = min(val, self.minStack[-1] if self.minStack else val)
            self.minStack.append(less)

# Remove element from the stack when the stack is not empty
    def pop(self) -> None:
        if len(self.stack) != 0:
            self.stack.pop()
            self.minStack.pop()
            
# Returns the top element  of the stack
    def top(self) -> int:
        if len(self.stack) == 0:
            return 
        
        return self.stack[-1]
    
# top element of minStack is returned
    def getMin(self) -> int:
        
        return self.minStack[-1]


# Your MinStack object will be instantiated and called as such:
# obj = MinStack()
# obj.push(val)
# obj.pop()
# param_3 = obj.top()
# param_4 = obj.getMin()