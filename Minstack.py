#succesfully executed on leetcode
class MinStack:

    def __init__(self):
        self.stack = []
        self.minstack = [] 
        
        # we have used 2 stacks one keep the tracks of orders and the other keeps the track of current min

    def push(self, val: int) -> None:
        self.stack.append(val)
        if not self.minstack or val <= self.minstack[-1]:
            self.minstack.append(val)
        
       #push operation is performed if the the items are smaller then the current top 
        

    def pop(self) -> None:
        
        if self.minstack[-1] == self.stack[-1]:
                self.minstack.pop()
        self.stack.pop()
        
        #pop is performed on the top value
        

    def top(self) -> int:
        return self.stack[-1]
        
        

    def getMin(self) -> int:
        return self.minstack[-1]
        
        # Time complexity - O(1)
        #space complexity - O(n)

# Your MinStack object will be instantiated and called as such:
# obj = MinStack()
# obj.push(val)
# obj.pop()
# param_3 = obj.top()
# param_4 = obj.getMin()