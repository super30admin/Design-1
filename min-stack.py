#Time Complexity - O(1)
# ----- Space complexity O(n)
class MinStack:

    def __init__(self):
        self.stack=[]
        # self.mini=inf
        
    def push(self, val: int) -> None:
        if self.stack:
            self.stack.append([val,min(val,self.stack[-1][1])])
            # print(self.stack)
        else:
            self.stack.append([val,val])
    

    def pop(self) -> None:
        if self.stack:
            self.stack.pop()


    def top(self) -> int:
        # print(self.stack[-1])
        if self.stack:
            return self.stack[-1][0]

    def getMin(self) -> int:
        return self.stack[-1][1]


# Your MinStack object will be instantiated and called as such:
# obj = MinStack()
# obj.push(val)
# obj.pop()
# param_3 = obj.top()
# param_4 = obj.getMin()