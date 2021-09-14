# Time Complexity : O(1)
# Space Complexity : O(n)
# If the min stack is empty, or this number is smaller than
# the top of the min stack, we put it on with a count of 1.
# Else if this number is equal to what's currently at the top
# of the min stack, then increment the count at the top by 1.
class MinStack:

    def __init__(self):
        self.stack = []
        self.min_stack = []        
        

    def push(self, x: int) -> None:
        self.stack.append(x)
        if not self.min_stack or x < self.min_stack[-1][0]:
            self.min_stack.append([x, 1])
        elif x == self.min_stack[-1][0]:
            self.min_stack[-1][1] += 1

    
    def pop(self) -> None:
        if self.min_stack[-1][0] == self.stack[-1]:
            self.min_stack[-1][1] -= 1
        if self.min_stack[-1][1] == 0:
            self.min_stack.pop()
        self.stack.pop()


    def top(self) -> int:
        return self.stack[-1]


    def getMin(self) -> int:
        return self.min_stack[-1][0]   