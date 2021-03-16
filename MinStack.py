# Time Complexity : O(1)
# Space Complexity :O(n)
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : No
class MinStack:

    def __init__(self):
        """
        initialize your data structure here.
        """
        self.stack=[]
        self.minstack=[]
        

    def push(self, x: int) -> None:
        self.stack.append(x)
        if self.minstack:
            current_min = self.minstack[-1]
        else:
            current_min=math.inf
        
        if x <= current_min:
            self.minstack.append(x)
        
    def pop(self) -> None:
        if self.stack.pop() == self.minstack[-1]:
            self.minstack.pop()
        

    def top(self) -> int:
        return self.stack[-1]
        

    def getMin(self) -> int:
        return self.minstack[-1]
        


# Your MinStack object will be instantiated and called as such:
# obj = MinStack()
# obj.push(x)
# obj.pop()
# param_3 = obj.top()
# param_4 = obj.getMin()