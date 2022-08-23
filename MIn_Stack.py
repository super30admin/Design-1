# Time Complexity : O(1)
# Space Complexity : O(n)

    def __init__(self):
        self.stack = []    
    
    def push(self, val: int) -> None:
        currmin = self.getMin()
        if  val < currmin:
            currmin = val
        self.stack = [(val, currmin)] + self.stack       

    def pop(self) -> None:
        self.stack = self.stack[1:]
        
    
    
    def top(self) -> int:
        return self.stack[0][0]        

    def getMin(self) -> int:
        if self.stack == []:
            return (2**31) -1
        else:
            return self.stack[0][1]
# Your MinStack object will be instantiated and called as such:
# obj = MinStack()
# obj.push(val)
# obj.pop()
# param_3 = obj.top()
# param_4 = obj.getMin()

if __name__ == "__main__":
	ss = MinStack()
	ss.push(10)
	ss.push(4)
	ss.push(0)
	print(ss.pop())
print(ss.stack)