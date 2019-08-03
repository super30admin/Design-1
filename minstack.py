import sys
class MinStack:

    def __init__(self):
        """
        initialize your data structure here.
        """
        self.stack=[]
        self.mini=sys.maxsize
    
    
    def push(self, x: int) -> None: 
        # if the input variable (x)is greater than the current min, we blindly push it in the stack, else
        #push the orginal min first, make this x as minimum and then push x
        if x <=self.mini:
            self.stack.append(self.mini)
            self.mini=x
        self.stack.append(x)
       
    def pop(self) -> None:
        #popped the otem from stack. If the popped item and minimum are same, popped one more item and make         #it minimum
        item=self.stack.pop()
        if item==self.mini:
            self.mini=self.stack.pop()

    def top(self) -> int:
        #top of the element
        return self.stack[-1]

    def getMin(self) -> int:
        #return . minimum element
        return self.mini


# Your MinStack object will be instantiated and called as such:
# obj = MinStack()
# obj.push(x)
# obj.pop()
# param_3 = obj.top()
# param_4 = obj.getMin()