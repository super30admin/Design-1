#  Time Complexity : - o(1) for each method
#  Space Complexity : o(n) due to auxilary list for storing min stack
#  Did this code successfully run on Leetcode : yes
#  Any problem you faced while coding this : 
    #  faced issues while testing my code could submit in 3rd attempt on leetcode. I was missing poping from minStack when implementing pop method


# // Your code here along with comments explaining your approach
#  1)  Take two stacks one normal stack and other min stack to track min for (o(1) time)
#  2) For every push to stack calculate min  and push that to minStack
#  3) When poping pop from both stacks  (in such a way we can always get min from min stack in o(1))

class MinStack:

    def __init__(self):
        self.stack = []
        self.minStack = []
        

    def push(self, val: int) -> None:
        self.stack.append(val)
        self.minStack.append(min(val, self.minStack[-1] if self.minStack else val))

    def pop(self) -> None:
        if self.stack:
            self.stack.pop()
            self.minStack.pop()

    def top(self) -> int:
        return self.stack[-1]
        

    def getMin(self) -> int:
        return self.minStack[-1]
        


# Your MinStack object will be instantiated and called as such:
obj = MinStack()
obj.push(-2)
obj.push(0)
obj.push(-3)
print(obj.getMin())
obj.pop()
print(obj.top())
print(obj.getMin())