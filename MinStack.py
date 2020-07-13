#Time Complexity : o(1)
#Space Complexity : o(n)
#Did this code successfully run on Leetcode : yes
#Any problem you faced while coding this : no
class MinStack:
    
    SIZE = 1000

    def __init__(self):
        """
        initialize your data structure here.
        """
        self.stack = []
        self.min= []
    
    # Check if the stack is empty
    def isEmpty(self):
        if len(self.stack) == 0:
            return True
        else:
            return False
    # Check if the stack is full
    def isFull(self):
        if len(self.stack) ==self.SIZE:
            return True
        else:
            return False
        
    # Each time we push the element on to the stack, keep track of the minimum element
    def push(self, x: int) -> None:
        
        if self.isFull():
            print('Stack is full')
        else:
            self.stack.append(x)
            if self.min:
                if x < self.min[-1]:
                    self.min.append(x)
                else:
                    self.min.append(self.min[-1])
            else:
                self.min.append(x)

    # remove the element from the stack if the stack is not empty and update the min value
    def pop(self) -> None:
        
        if self.isEmpty():
            print('stack is empty')
            return -1
        else:
            self.min.pop()
            return self.stack.pop()
            
    # return the last element in the list
    def top(self) -> int:
        return self.stack[-1]

    def getMin(self) -> int:
        return self.min[-1]


# Your MinStack object will be instantiated and called as such:
# obj = MinStack()
# obj.push(x)
# obj.pop()
# param_3 = obj.top()
# param_4 = obj.getMin()