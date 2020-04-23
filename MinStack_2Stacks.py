class MinStack:
    

    def __init__(self):
        """
        initialize your data structure here.
        """
        self.sMain = [] #Main Stack
        self.sMin = [] #Min Stack
        self.minimum = sys.maxsize#2147483647 #Max Value of python
        self.sMin.append(self.minimum)
    

    def push(self, x: int) -> None:
        self.sMain.append(x)
        self.minimum = min(self.minimum,x)
        self.sMin.append(self.minimum)
        

    def pop(self) -> None:
        self.sMain.pop() # pop without index will give the last value in the index
        self.sMin.pop() # pop from both stacks: refer notes
        self.minimum = self.sMin[-1] #peek() function, now the min value will                                                   be the previous one

    def top(self) -> int:
        return self.sMain[-1]#return the last value in the list, which is the top                                value                                 when looked in a stack perspective; peek()
        

    def getMin(self) -> int:
        return self.minimum
        


# Your MinStack object will be instantiated and called as such:
# obj = MinStack()
# obj.push(x)
# obj.pop()
# param_3 = obj.top()
# param_4 = obj.getMin()