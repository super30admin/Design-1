// Time Complexity :O(1)
// Space Complexity :O(n)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : No


class MinStack:

    def __init__(self):
        """
        initialize your data structure here.
        """
        self.stack = []
        self.stack2 = []

    def push(self, x: int) -> None:
        self.stack.append(x)
        if len(self.stack2)==0 or self.stack2[-1]>=x:
            self.stack2.append(x)
        

    def pop(self) -> None:
        if len(self.stack)==0:
            return -1
        values = self.stack[-1]
        self.stack.pop()
        if values==self.stack2[-1]:
            self.stack2.pop()
        return values 

    def top(self) -> int:
        if len(self.stack)==0:
            return -1
        return self.stack[-1]

    def getMin(self) -> int:
        if len(self.stack2)==0:
            return -1
        return (self.stack2[-1])
        


# Your MinStack object will be instantiated and called as such:
# obj = MinStack()
# obj.push(x)
# obj.pop()
# param_3 = obj.top()
# param_4 = obj.getMin()