class MinStack:

    def __init__(self):
        self.arr=[]
        self.mini=[]
     #Time Complexity: O(1)
    #Space complexity:O(1)       
    def push(self, val: int) -> None:
        if self.arr==[]:
            self.arr.append(val)
            self.mini.append(val)
        else:
            self.mini.append(min(self.mini[-1],val))
            self.arr.append(val)
    #Time Complexity: O(1)
    #Space complexity:O(1)
    def pop(self) -> None:
        self.arr.pop()
        self.mini.pop()
    #Time Complexity: O(1)
    #Space complexity:O(1)
    def top(self) -> int:
        return self.arr[-1]
        
    #Time Complexity: O(1)
    #Space complexity:O(1)
    def getMin(self) -> int:
        return self.mini[-1]


# Your MinStack object will be instantiated and called as such:
# obj = MinStack()
# obj.push(val)
# obj.pop()
# param_3 = obj.top()
# param_4 = obj.getMin()