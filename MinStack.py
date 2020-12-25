# Time Complexity: everything O(1)
# Space Complexity: O(n)
# Did this code successfully run on LeetCode?: Yes
# Problems faced while coding this: None

# Approach: Two Stack
class MinStack:

    def __init__(self):
        """
        initialize your data structure here.
        """
        self._storage = []
        self._min_stack = [float('inf')]


    def push(self, x: int) -> None:
        self._storage.append(x)
        mini = min(x, self.getMin())
        self._min_stack.append(mini)


    def pop(self) -> None:
        if len(self._storage) == 0:
            raise Exception('Stack is empty!')

        self._storage.pop()
        self._min_stack.pop()


    def top(self) -> int:
        if len(self._storage) == 0:
            raise Exception('Stack is empty!')

        return self._storage[-1]


    def getMin(self) -> int:
        if len(self._storage) == 0:
            raise Exception('Stack is empty!')

        return self._min_stack[-1]


# Your MinStack object will be instantiated and called as such:
# obj = MinStack()
# obj.push(x)
# obj.pop()
# param_3 = obj.top()
# param_4 = obj.getMin()
