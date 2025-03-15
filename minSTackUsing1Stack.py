# Min Stack design using 1 Stack where we will compare the minimum values and update it accordingly
# TC: O(1) for all the methods(push,pop,top, get Min)
# SC: O(n) for number of elements stored in stack


class MinStack:
    def __init__(self):
        self.stack = []  # stack to store values
        self.min_val = float("inf")  # minimum value infinity

    # push value into stack
    def push(self, val):
        if (
            val <= self.min_val
        ):  # check if value is lesser that min value then append min value into the stack and update min value to value
            self.stack.append(self.min_val)
            self.min_val = val
        self.stack.append(val)  # push the current value

    # pop the element
    def pop(self):
        popped = self.stack.pop()  # pop the element from top of the stack
        if (
            popped == self.min_val
        ):  # if popped element was the current min value then update the minimum val by popping the next element which is prev. minimum
            self.min_val = self.stack.pop()

    def top(self):
        return self.stack[-1]  # return the top element

    def getMin(self):
        return self.min_val  # return the current minimum value of the stack


# Your MinSTack object will be instantiated and called as such:
min_stack = MinStack()
min_stack.push(1)
min_stack.push(4)
min_stack.push(0)

print(min_stack.getMin())  # 0
min_stack.pop()
print(min_stack.getMin())  # 1
print(min_stack.top())  # 4
