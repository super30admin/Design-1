class MinStack:
    def __init__(self):
        """
        Time complexity: O(1)
        Space complexity: O(n)
        """
        self.stack = []
        self.min_stack = []

    def push(self, x: int) -> None:
        """
        Time complexity: O(1)
        Space complexity: O(1)
        """
        self.stack.append(x)
        if not self.min_stack or x <= self.min_stack[-1]:
            self.min_stack.append(x)

    def pop(self) -> None:
        """
        Time complexity: O(1)
        Space complexity: O(1)
        """
        if self.stack[-1] == self.min_stack[-1]:
            self.min_stack.pop()
        self.stack.pop()

    def top(self) -> int:
        """
        Time complexity: O(1)
        Space complexity: O(1)
        """
        return self.stack[-1]

    def getMin(self) -> int:
        """
        Time complexity: O(1)
        Space complexity: O(1)
        """
        return self.min_stack[-1]
