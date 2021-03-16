# // 2. Min Stack Leet Code - 155 - Used 2 stacks, one for maintaining the input values, and the other to store the minimum value.
# Time Complexity = O(1) for all the functions because we are using stack
# Space Complexity = O(n) because we store all the elements in both the stack
# Code runs successfully in 60 ms - 
# How to make it more effecient??


class MinStack:

    def __init__(self):
        """
        initialize your data structure here.
        """
        self.stack = []
        self.minStack = [sys.maxsize]

    def push(self, x):
        self.stack.append(x)
        self.minStack.append(min(x,self.minStack[-1]))
        

    def pop(self):
        self.stack.pop()
        self.minStack.pop()

    def top(self):
        return self.stack[-1]

    def getMin(self):
        return self.minStack[-1]
        

