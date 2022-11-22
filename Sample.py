#Time Complexity : O(1)
#Space Complexity : O(1)
#Did this code successfully run on Leetcode : Yes
#Any problem you faced while coding this : No


#Your code here along with comments explaining your approach
# 1. init - Created a stack and a min stack
# 2. push - we add our value to the stack first
#           then we check if min stack has any value, if it doesn't,
#           we add that val as it is the only value, hence will be min
#           if min stack already has value, we compare the curr val to val 
#           on top and add if curr is min
# 3. pop -  we remove the topmost value from stack and min stack
# 4. top -  we see the topmost value from stack
# 5. getMin - we get the topmost value from min stack


class MinStack:

    def __init__(self):
        self.stack = []
        self.min_stack = []

    def push(self, val: int) -> None:
        self.stack.append(val)
        if(self.min_stack):
            min = self.min_stack[-1] 
            if val < min:
                self.min_stack.append(val)
            else:
                self.min_stack.append(min)
        else:
            self.min_stack.append(val)
            
    def pop(self) -> None:
        self.stack.pop()
        self.min_stack.pop()

    def top(self) -> int:
        if len(self.stack) == 0:
            return None
        else:
            return self.stack[-1]

    def getMin(self) -> int:
        if len(self.min_stack) == 0:
            return None
        else:
            return self.min_stack[-1]


# Your MinStack object will be instantiated and called as such:
# obj = MinStack()
# obj.push(val)
# obj.pop()
# param_3 = obj.top()
# param_4 = obj.getMin()