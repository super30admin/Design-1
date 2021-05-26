# // Time Complexity : O(1)
# // Space Complexity : O(n)
# // Did this code successfully run on Leetcode : Yes

class MinStack:

    def __init__(self):
        """
        initialize your data structure here.
        """
        self.stackList = [100]
        self.min = float('inf')

    def push(self, val: int) -> None:
        # if new value is lower than current min, append the current min to stack
        if val <= self.min:
            self.stackList.append(self.min)
            self.min = val
        self.stackList.append(val)

    def pop(self) -> None:
        # if popping current min value, replace min with older min value
        top = self.stackList[-1]
        self.stackList.pop()
        if self.min == top:
            self.min = self.stackList[-1]
            self.stackList.pop()

    def top(self) -> int:
        if len(self.stackList) == 0:
            ValueError("Stack is empty")
        else:
            return self.stackList[-1]

    def get_min(self) -> float:
        return self.min

    def is_empty(self) -> bool:
        return len(self.stackList) == 0


obj = MinStack()
obj.push(3)
obj.push(-1)
obj.push(0)
obj.push(-2)
print(obj.min)
obj.pop()
obj.pop()
obj.pop()
obj.pop()
obj.pop()
print(obj.top())
print(obj.get_min())
print(obj.is_empty())
