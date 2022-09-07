#Time complexity - to get min- O(1)
#Space complexity - O(n)
class MinStack:
    def __init__(self):
        self.stack = []

    def push(self, val: int) -> None:
        # if the stack is empty, then the first value is the min value
        if len(self.stack) == 0:
            self.stack.append((val, val))
            return
        
        current_min = self.stack[-1][1]
        self.stack.append((val, min(val,current_min)))

    def pop(self) -> None:
        return self.stack.pop()
        
    def top(self) -> int:
        return self.stack[-1][0]

    def getMin(self) -> int:
        return self.stack[-1][1]


# Your MinStack object will be instantiated and called as such:
# obj = MinStack()
# obj.push(val)
# obj.pop()
# param_3 = obj.top()
# param_4 = obj.getMin()