
"""
Time Complexity:
Push: O(1)
Pop: O(1)
peek: O(1)
empty: O(1)

Space Complexity:
Push: O(n)
Pop: O(n)
Peek: O(n)
Empty: O(n)
"""
class MinStack:

    def __init__(self):
        """
        initialize your data structure here.
        """
        self.stack = []
        

    def push(self, val: int) -> None:
        self.stack.append(val)
        return None
    
    def pop(self) -> None:
        self.stack.pop(-1)
        return None
    
    def top(self) -> int:
        return self.stack[-1]

    def getMin(self) -> int:
        return min(self.stack)


# Your MinStack object will be instantiated and called as such:
# obj = MinStack()
# obj.push(val)
# obj.pop()
# param_3 = obj.top()
# param_4 = obj.getMin()