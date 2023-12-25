''' We will go with two stacks approach, one which acts as normal stack and another to maintain min element track
When we add, we check if min_stack is empty or if the value is lesser than current min on top of min stack
When we pop, we check if the element being removed is on top of min stack, if so, we pop that as well '''

'''Time Complexity: O(1) for all operations
Space Complexity: O(n)'''



class MinStack:

    def __init__(self):

        self.stack = []
        self.min_stack = []
        

    def push(self, val: int) -> None:

        self.stack.append(val)

        if not self.min_stack or val <= self.min_stack[-1]:
            self.min_stack.append(val)
        

    def pop(self) -> None:

        temp = self.stack.pop()

        if temp == self.min_stack[-1]:
            self.min_stack.pop()
        

    def top(self) -> int:

        return self.stack[-1]
        

    def getMin(self) -> int:

        return self.min_stack[-1]
        


# Your MinStack object will be instantiated and called as such:
# obj = MinStack()
# obj.push(val)
# obj.pop()
# param_3 = obj.top()
# param_4 = obj.getMin()
