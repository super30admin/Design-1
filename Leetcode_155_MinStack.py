#Time Complexity: O(1)
#Sapce Complexity: O(n)


class MinStack:

    def __init__(self):
        self.main=[]
        

    def push(self, val: int) -> None:
        if not self.main:
            self.main.append([val,val])
        else:
            self.main.append([val,min(val,self.main[-1][1])])

    def pop(self) -> None:
         self.main.pop()
        

    def top(self) -> int:
        return self.main[-1][0]

    def getMin(self) -> int:
        return self.main[-1][1]
        


# Your MinStack object will be instantiated and called as such:
# obj = MinStack()
# obj.push(val)
# obj.pop()
# param_3 = obj.top()
# param_4 = obj.getMin()