class MinStack:
    """
        Time Complexity:
            push: O(1)
            pop: O(1)
            top: O(1)
            getMin: O(1)

        Approach:
            - We will create two stack
                - Main stack to store values
                - Min stack to store min at any particular stack state
            - Push 
                - We will push value in main stack 
                - We will compare the current value with the previous min val and 
                and add whichever is min to the min stack 
            - Pop
                - Pop the last element out of main stack and min stack
            - Top
                - Return the last element of the main stack
            - getMin
                - Return the last element of the min stack
    """
    def __init__(self):
        self.stack = list()
        self.min_stack = list()
        self.min = float('inf')
        self.min_stack.append(self.min)

    def push(self, val: int) -> None:
        self.min = min(self.min_stack[-1], val)
        self.stack.append(val)
        self.min_stack.append(self.min)
        
    def pop(self) -> None:
        self.stack.pop()
        self.min_stack.pop()

    def top(self) -> int:
        if self.stack:
            return self.stack[-1]

    def getMin(self) -> int:
        return self.min_stack[-1]


# Your MinStack object will be instantiated and called as such:
# obj = MinStack()
# obj.push(val)
# obj.pop()
# param_3 = obj.top()
# param_4 = obj.getMin()