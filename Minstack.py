# Runtime: 56 ms, faster than 94.36% of Python3 online submissions for Min Stack.
# Memory Usage: 16.4 MB, less than 96.43% of Python3 online submissions for Min Stack.
# Time complexity: O(N)
# Space complexity: O(N)

"""Problems faced: Didnt account for the scenario when the stack was empty, due to which, I was getting
run time error when attempting to access top of my stack

Also, couldnt implement isFull method as python arrays are dynamic and doesnt have a fixed size """

"""Implemented using two stack solution as there is no advantage of using single stack in time or space complexity"""
class MinStack:
    def __init__(self):
        """
        initialize your data structure here.
        """
        self.globalMinimum = float('inf')
        self.stack = list()
        self.minStack = list()

    def push(self, x: int) -> None:
        self.stack.append(x)
        """When pushing, check whether the element being pushed is less than the current minimum, if so, push the element 
        onto the min stack and make it the current minimum"""
        if x < self.globalMinimum:
            self.minStack.append(x)
            self.globalMinimum = x
        """Else, minimum remains as it is, push the same minimum"""    
        else:
            self.minStack.append(self.globalMinimum)

    def pop(self) -> None:
        """When popping, pop the normal stack as well as the min stack
        Update the currentMinimum with the previous minimum.
        If stack is empty, update the currentMinimum value to infinity"""
        self.stack.pop()
        self.minStack.pop()
        if self.isEmpty():
            self.globalMinimum = float('inf')
        else:
            self.globalMinimum = self.minStack[-1]

    def top(self) -> int:
        """If the stack is empty, return None, else, return the element on top of the stack"""
        if self.isEmpty():
            return None
        else:
            return self.stack[-1]
        

    def getMin(self) -> int:
        """Returns the current minimum"""
        return self.globalMinimum
    
    
    def isEmpty(self) -> int:
        """Returns true if the stack is empty"""
        if not self.stack:
            return True
        else:
            return False    
            