class MinStack:
    #Time Complexity :O(1)
    #Space Complexity :O(n)
    #Did this code successfully run on Leetcode : Yes
    #Any problem you faced while coding this : No

    #there are 2 approaches with which can solve this problem:
    #1-> using 2 stacks : main stack and min stack, pushing all values to the main stack and minimum values in min stack for each value.We will be Poping values from both stacks. 
    #2-> using 1 stack: pushing the values to the stack. if the new value is less than or equal to previous minimum value, pushing the previous minimum value before the new value. Poping:if the poped value is equal to the minimum value, pop the previous value and set it to minimum.  
    def __init__(self):
        self.stack=[]
        self.min=float(inf)

    def push(self, val: int) -> None:
        if val<=self.min:
            self.stack.append(self.min)
            self.min=val
        self.stack.append(val) 

    def pop(self) -> None:
        if self.min==self.stack.pop():
            self.min=self.stack.pop()

    def top(self) -> int:
        return self.stack[-1]

    def getMin(self) -> int:
        return self.min


# Your MinStack object will be instantiated and called as such:
# obj = MinStack()
# obj.push(val)
# obj.pop()
# param_3 = obj.top()
# param_4 = obj.getMin()