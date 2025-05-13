# Time Complexity : 
# push(int val) pushes the element val onto the stack O(1).
# void pop() removes the element on the top of the stack O(1).
# int top() gets the top element of the stack O(1).
# int getMin() retrieves the minimum element in the stack O(1).
#Space Complexity : O(n)
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : No
#Maintain 2 stacks , one for stack and other for tracking min vals, for each value we add in main stack we track whats min val until that point with help of min stack, 
#while add we check min val and upadate our minstack accordingly 
class MinStack:

    def __init__(self):
        self.stack = []
        self.min_stack = []
        

    def push(self, val: int) -> None:
        self.stack.append(val)
        if not self.min_stack or val <= self.min_stack[-1]:
            self.min_stack.append(val)
        else : 
            self.min_stack.append(self.min_stack[-1])
      

    def pop(self) -> None:
        self.stack.pop()
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
