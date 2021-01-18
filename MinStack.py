#// Time Complexity :O(1)
#// Space Complexity :O(n)
#// Did this code successfully run on Leetcode :yes
#// Any problem you faced while coding this :no


#// Your code here along with comments explaining your approach
class MinStack:

    def __init__(self):
        """
        initialize your data structure here.
        """
        self.stack=[]
        self.min=[]

    def push(self, x: int) -> None:
        self.stack.append(x)
        if(self.min==[]):
            self.min.append(x)
        else:
            self.min.append(min(x,self.min[-1]))
            

    def pop(self) -> None:
        self.stack.pop()
        self.min.pop()

    def top(self) -> int:
        return self.stack[-1]

    def getMin(self) -> int:
        return self.min[-1]


# Your MinStack object will be instantiated and called as such:
# obj = MinStack()
# obj.push(x)
# obj.pop()
# param_3 = obj.top()
# param_4 = obj.getMin()