class MinStack:

    def __init__(self):
        self.st=[]
        self.m = []
        """
        initialize your data structure here.
        """
        

    def push(self, val: int) -> None:
        #Time complexity O(1)
        if len(self.m)==0:
            self.m.append(val)
        else:
            if val<self.m[-1]:
                self.m.append(val)
            else:
                self.m.append(self.m[-1])
        self.st.append(val)
        

    def pop(self) -> None:
        #Time complexity O(1)
        if len(self.st)>0:
            self.m.pop(-1)
            return self.st.pop(-1)
        else:
            return None
        
        

    def top(self) -> int:
        #Time complexity O(1)
        if len(self.st)>0:
            return self.st[-1]
        

    def getMin(self) -> int:
        #Time complexity O(1)
        if len(self.m)>0:
            return self.m[-1]
        


# Your MinStack object will be instantiated and called as such:
# obj = MinStack()
# obj.push(val)
# obj.pop()
# param_3 = obj.top()
# param_4 = obj.getMin()