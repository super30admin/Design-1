"""
    Problem Statement: Design a Min-Stack.

    Approach: We have no restrictions on using stack's built-in functions. In python, list is designed as a stack 
              so we will be using a single list to implement min-stack. When a new value is added to the stack we compare
              the value with minimum, if the new value is less than minimum then we push the current minimum and update minimum. 
              During pop operation, we pop from the stack and check if the popped value is equal to minimum, if it is equal
              to minimum then we pop again and save the recent popped element as the minimum.

    Time complexity:
    push(): O(1)
    top(): O(1)
    getMin(): O(1)
    pop(): O(1)
    
    Space complexity: O(n), where n is the length of the stack.

    Working on LeetCode? Yes!
"""
import math
from typing import List

class MinStack:
    def __init__(self):
        self.stack: List[int] = []
        self.min:int = math.inf
    
    def push(self, value: int) -> None:
        if value <= self.min:
            self.stack.append(self.min)
            self.min = value
        self.stack.append(value)

    def top(self) -> int:
        if len(self.stack):
            return self.stack[-1]

    def getMin(self) -> int:
        return self.min
    
    def pop(self) -> int:
        if self.stack[-1] != math.inf:
            popped = self.stack.pop()
            if popped == self.min:
                self.min = self.stack.pop()
            return popped


if __name__ == "__main__":
    ms = MinStack()
    ms.push(1)
    ms.push(2)
    ms.push(3)
    ms.push(3)
    ms.push(4)
    ms.push(5)
    ms.push(10)
    ms.push(-12)

    print(f"Current stack: {ms.stack}")
    print(f"Top element: {ms.peek()}")
    print(f"Element popped: {ms.pop()}")
    print(f"Current stack: {ms.stack}")
    print(f"Minimum element: {ms.getMin()}")
    print(f"Element popped: {ms.pop()}")
    print(f"Current stack: {ms.stack}")
    print(f"Minimum element: {ms.getMin()}")
    print(f"Element popped: {ms.pop()}")
    print(f"Current stack: {ms.stack}")
    print(f"Minimum element: {ms.getMin()}")
    print(f"Element popped: {ms.pop()}")
    print(f"Current stack: {ms.stack}")
    print(f"Minimum element: {ms.getMin()}")
    print(f"Element popped: {ms.pop()}")
    print(f"Current stack: {ms.stack}")
    print(f"Minimum element: {ms.getMin()}")
    print(f"Element popped: {ms.pop()}")
    print(f"Top element: {ms.peek()}")
    