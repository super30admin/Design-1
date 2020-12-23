"""Problem 2:MinStack in Python

Time complexity for PUshing elem onto stack, popping,peeking top element : O(1)
Space Complexity : O(n) where n is the no. of elements in the array

Did the below program run for all cases ? Yes"""

class MinStack:

    def __init__(self):
        """
        initialize your data structure here.
        """
        self.a = []

    def push(self, x: int) -> None:
        return self.a.append(x) #push element x onto the stack a

    def pop(self) -> None:
        return self.a.pop()     #pop element from stack a   

    def top(self) -> int:
        return self.a[-1]       #return the topmost element present in the stack

    def getMin(self) -> int:
        return min(self.a)      #return the smallest element in the stack


# Your MinStack object will be instantiated and called as such:
# obj = MinStack()
# obj.push(x)
# obj.pop()
# param_3 = obj.top()
# param_4 = obj.getMin()