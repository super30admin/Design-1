"""
Time Complexity : O(1)
Space Complexity : Worst Case O(2n) = O(n) 

"""

class MinStack:

    def __init__(self):
        """
        initialize your data structure here.
        """
        self.stack = []
        self.min = float("inf")
                          
    def push(self, val: int) -> None:
        if self.min >= val:
            self.stack.append(self.min)
        self.min = min(self.min, val)
        self.stack.append(val)
        
    def pop(self) -> None:
        if not self.stack:
            return None 
        val = self.stack.pop()
        if val == self.min:
            self.min = self.stack.pop()
        return val

    def top(self) -> int:
        if not self.stack:
            return None
        return self.stack[-1]

    def getMin(self) -> int:
        return self.min
        


# Your MinStack object will be instantiated and called as such:
lis = ["MinStack","push","push","push","getMin","pop","top","getMin"]
main_lis = [[],[-2],[0],[-3],[],[],[],[]]

result = []

for i in range(len(lis)):
    
    if lis[i] == "MinStack":
        obj = MinStack()
        result.append(None)
        
    elif lis[i] == "push":
        obj.push(main_lis[i][0])
        result.append(None)
    
    elif lis[i] == "pop":
        obj.pop()
        result.append(None)
    
    elif lis[i] == "top":
        result.append(obj.top())
    
    elif lis[i] == "getMin":
        result.append(obj.getMin())

print(result)
    
        
