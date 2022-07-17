# Time complexity push( ( O(1)) pop(( O(1)) getmin(O(1)) top((O(1))
# Space compelxity: O(N) 

from cmath import inf



# by 1 to 1 mapping 
class MinStack:

    def __init__(self):
        self.min = inf
        self.st = []
        self.minSt = []
        self.minSt.append(self.min)

    def push(self, val: int) -> None:
        self.min = min(self.min,val)
        self.st.append(val)
        self.minSt.append(self.min)

    def pop(self) -> None:
        self.st.pop()
        self.minSt.pop()
        self.min = self.minSt[-1]

    def top(self) -> int:
        return self.st[-1]

    def getMin(self) -> int:
        return self.min


# this apporach push the previous min to the stack if the current is min than previous min
# if don't want to maintain stack for minimum,use this apporoch
class MinStack1:

    def __init__(self):
        self.min = inf
        self.st = []
        

    def push(self, val: int) -> None:
        if self.min >= val:
            self.st.append(self.min)
            self.min = val
        self.st.append(val)

    def pop(self) -> None:
        if self.st.pop() == self.min:
            self.min = self.st.pop()
       

    def top(self) -> int:
        return self.st[-1]

    def getMin(self) -> int:
        return self.min



# Your MinStack object will be instantiated and called as such:
# obj = MinStack()
# obj.push(val)
# obj.pop()
# param_3 = obj.top()
# param_4 = obj.getMin()