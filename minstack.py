
#MinStack is a class that maintains a stack of values. It stores the minimum value encountered in a separate variable, self.min.
#The push() method adds a value to the stack. If the value is less than or equal to the current minimum value, it stores the previous minimum value before adding the new value.
#The pop() method removes the top value from the stack. If the popped value was the minimum value, it restores the previous minimum value.
#The top() method returns the top value of the stack
#the getMin() method returns the minimum value stored in the stack.
#Time complexity O(1)
#space complexity O(n)
#problem submitted in leetcode

class MinStack:
    def __init__(self):
        self.stack = []
        self.min = float('inf')

    def push(self, val):
        if val <= self.min:
            self.stack.append(self.min)  # Store previous min value
            self.min = val
        self.stack.append(val)

    def pop(self):
        if self.stack.pop() == self.min:
            self.min = self.stack.pop()  # Restore previous min value

    def top(self):
        return self.stack[-1]

    def getMin(self):
        return self.min
 

# Your MinStack object will be instantiated and called as such:
# obj = MinStack()
# obj.push(val)
# obj.pop()
# param_3 = obj.top()
# param_4 = obj.getMin()