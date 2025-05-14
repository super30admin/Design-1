# Time Complexity : O(1) for push, pop, top, getMin
# Space Complexity : O(n) where n = number of elements in the stack
# Did this code successfully run on Leetcode : YES
# Any problem you faced while coding this : No issues

class MinStack:

    def __init__(self):
        # main stack storing all pushed value
        self.stack = []
        # auxiliary stack storing the minimum value at each depth
        self.min_stack = []
    
    def push(self, val):
        # add the value to the main stack
        self.stack.append(val)
        # if no min yet, or new val is smaller, push it as the new min
        minVal = min(val, self.min_stack[-1] if self.min_stack else val)
        self.min_stack.append(minVal)

    def pop(self):
        # remove top from both stacks
        self.stack.pop()
        self.min_stack.pop()

    def top(self):
        # return the most recent value
        return self.stack[-1]

    def getMin(self):
        # the current minimum is at the top of min_stack
        return self.min_stack[-1]
    

if __name__ == "__main__":
    obj = MinStack()
    obj.push(-2)
    obj.push(0)
    obj.push(-3)

    print(obj.top())
    obj.pop()
    print(obj.getMin())
    