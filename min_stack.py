class MinStack:

    def __init__(self):
        self.stk = []
        self.minStk = []
        self.minStk.append(float('inf'))
        self.size = 0

    """
        Push new element to the stack
        Takes O(1) time.
    """
    def push(self, val: int) -> None:
        self.stk.append(val)
        minVal = min(self.minStk[self.size], val)
        self.minStk.append(minVal)
        self.size += 1
    
    """
        Pop an element
        Takes O(1) time.
    """
    def pop(self) -> None:
        self.size -= 1
        self.stk.pop()
        self.minStk.pop()

    """
        Fetching top element of the stack
        Takes O(1) time.
    """
    def top(self) -> int:
        return self.stk[self.size - 1]

    """
        Fetching min element from the stack
        Takes O(1) time.
    """
    def getMin(self) -> int:
        return self.minStk[self.size]


# Your MinStack object will be instantiated and called as such:
# obj = MinStack()
# obj.push(val)
# obj.pop()
# param_3 = obj.top()
# param_4 = obj.getMin()