class MinStack:

    def __init__(self):
        """
        initialize your data structure here.
        """
        self.s = []
        # set deault min as infinity
        self.current_min = float('inf')
        self.minS = []
        self.minS.append(self.current_min)
        

    def push(self, val: int) -> None:
        """
        :type x:int
        :no return type
        :append val in stack list and min stack list
        """
        self.current_min=min(self.current_min, val)
        self.s.append(val)
        self.minS.append(self.current_min)
      
        

    def pop(self) -> None:
        self.s.pop()
        self.minS.pop()
        self.current_min=self.minS[-1]
       

        

    def top(self) -> int:
        return self.s[-1]
        

    def getMin(self) -> int:
        return self.current_min


# Your MinStack object will be instantiated and called as such:
# obj = MinStack()
# obj.push(val)
# obj.pop()
# param_3 = obj.top()
# param_4 = obj.getMin()