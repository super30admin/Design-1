# // Time Complexity :O(1)
# // Space Complexity :O(2n)
class MinStack:

    def __init__(self):
        self.st=[]
        self.minst=[]
        self.minst.append(inf)
        

    def push(self, val: int) -> None:
        self.st.append(val)
        if val<self.minst[-1]:
            self.minst.append(val)
        else:
            self.minst.append(self.minst[-1])
            
        

    def pop(self) -> None:
        self.st.pop()
        self.minst.pop()
        

    def top(self) -> int:
        return self.st[-1]
        

    def getMin(self) -> int:
        return self.minst[-1]


# Your MinStack object will be instantiated and called as such:
# obj = MinStack()
# obj.push(val)
# obj.pop()
# param_3 = obj.top()
# param_4 = obj.getMin()