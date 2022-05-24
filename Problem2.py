'''
Time Complexity: O(1) for all operations
Space Complexity: O(n) n is the size of stack
Run on Leetcode: YES
Problems: Found it difficult to come up with a solution that solves minimum problem in constant time.
'''

class MinStack:

    def __init__(self):
        self.stack = []
        self.min = []

    def push(self, val: int) -> None:
        if len(self.stack) > 0:
            self.stack.append(val)
            self.min.append(min(self.min[len(self.min)-1],val))
        else:
            self.stack.append(val)
            self.min.append(val)
        

    def pop(self) -> None:
        if len(self.stack) > 0:
            self.stack.pop()
            self.min.pop()
        else:
            print("Stack Empty")

    def top(self) -> int:
        if len(self.stack) > 0:
            return self.stack[len(self.stack) - 1]
        else:
            return -1

    def getMin(self) -> int:
        if len(self.stack) > 0:
            return self.min[len(self.stack) - 1]
        else:
            return -1


# Your MinStack object will be instantiated and called as such:
# obj = MinStack()
# obj.push(val)
# obj.pop()
# param_3 = obj.top()
# param_4 = obj.getMin()