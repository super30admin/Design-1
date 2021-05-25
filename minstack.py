//Time Complexity : O(1)
//Space Complecity : O(n)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this :

# Cannnot find optimal solution for space
// Your code here along with comments explaining your approach
#Logic
Use two stack,One to maintain the order and other to keep track of minimum.
While pushing always check whether there is a minimum and push into both the stacks.
While popping if the minimum is on top then pop from both the stacks.


class MinStack:
    def __init__(self):
        """
        initialize your data structure here.
        """
        self.orderStack = []
        self.minStack = []
        

    def push(self, val: int) -> None:
      #always push the value in order
        self.orderStack.append(val)
      # If min stack is empty or value is less then previous value     
        if not self.minStack or val <= self.minStack[-1]:
            self.minStack.append(val)
            

    def pop(self) -> None:
# order stack will be popped but before popping check if it is minimum element then pop from min stack also
        if self.minStack[-1] == self.orderStack[-1]:
            self.minStack.pop()
        self.orderStack.pop()
        
        

    def top(self) -> int:
        return self.orderStack[-1]
        

    def getMin(self) -> int:
        return self.minStack[-1]


# Your MinStack object will be instantiated and called as such:
# obj = MinStack()
# obj.push(val)
# obj.pop()
# param_3 = obj.top()
# param_4 = obj.getMin()




