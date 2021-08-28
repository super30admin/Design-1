Time complexity: O(1)
Space Complexity:O(n)



class MinStack:

    def __init__(self):
        self.st=[]
        self.mini=sys.maxsize
        
        """
        initialize your data structure here.

        """
        

    def push(self, val: int) -> None:
        if val<=self.mini:
            self.st.append(self.mini)
            self.mini=val
        self.st.append(val)
            
        

    def pop(self) -> None:
        if self.st.pop()==self.mini:
            self.mini=self.st.pop()

    def top(self) -> int:
        return self.st[-1]
        

    def getMin(self) -> int:
        return self.mini


# Your MinStack object will be instantiated and called as such:
# obj = MinStack()
# obj.push(val)
# obj.pop()
# param_3 = obj.top()
# param_4 = obj.getMin()
