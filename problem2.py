class MinStack:

    def __init__(self):
        """
        initialize your data structure here.
        """
        self.main_stack=[]
        self.supporting_stack=[]
        

    def push(self, x: int) -> None:
        if len(self.main_stack)==0:
            self.main_stack.append(x)
            self.supporting_stack.append(x)
            # print("main",self.main_stack)
            # print("support",self.supporting_stack)
        else:
            self.main_stack.append(x)
            if x<=self.supporting_stack[-1]:
                self.supporting_stack.append(x)
            # print("main",self.main_stack)
            # print("support",self.supporting_stack)
            
        

    def pop(self) -> None:
        popped_elem=self.main_stack.pop()
        if popped_elem==self.supporting_stack[-1]:
            self.supporting_stack.pop()

    def top(self) -> int:
        return self.main_stack[-1]
        

    def getMin(self) -> int:
        return self.supporting_stack[-1]
        


# Your MinStack object will be instantiated and called as such:
# obj = MinStack()
# obj.push(x)
# obj.pop()
# param_3 = obj.top()
# param_4 = obj.getMin()