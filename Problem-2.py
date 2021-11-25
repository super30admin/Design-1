# Time Complexity : O(1) for all operations
# Space Complexity : O(n)
# Did this code successfully run on Leetcode : yes
# Any problem you faced while coding this : No


#Your code here along with comments explaining your approach



class MinStack:

    def __init__(self):
        """
        initialize your data structure here.
        """
        self.mini = float("inf")
        self.st = []

    def push(self, x: int) -> None:
        if x <= self.mini:
            self.st.append(self.mini)
            self.mini = x
            self.st.append(x)
        else:
            self.st.append(x)
                
    def pop(self) -> None:
        if self.st[-1] == self.mini:
            self.st.pop()
            self.mini =self.st.pop()
        else:
            self.st.pop()
        

    def top(self) -> int:
        if self.st:
            return self.st[-1]
        

    def getMin(self) -> int:
        return self.mini
        


# Your MinStack object will be instantiated and called as such:
# obj = MinStack()
# obj.push(x)
# obj.pop()
# param_3 = obj.top()
# param_4 = obj.getMin()