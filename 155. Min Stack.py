'''
T = O(1)
S = O(2n)

Approach:
Maintain 2 stacks
1. to store the element itself
2. to store the min value when that idex from the element is poped
3. Every time a new elelment is added or removed make the corresponding changes in the 
	minstack array also
'''
class MinStack:

    def __init__(self):
        """
        initialize your data structure here.
        """
        self.stack = []
        self.MinVal = []
        self.InitMax = float('inf')

    def push(self, val: int) -> None:
        self.updateStack(val)
        self.stack.append(val)
        

    def pop(self) -> None:
        if self.stack[-1] != None:
            self.stack.pop()
        if self.MinVal[-1] != None:
            self.MinVal.pop()

    def top(self) -> int:
        if self.stack[-1] != None:
            return self.stack[-1]

    def getMin(self) -> int:
        if self.MinVal[-1] != None:
            return self.MinVal[-1]
        
    def updateStack(self,val):
        if len(self.MinVal) == 0:
            val1 = float('inf')
        else:
            val1 = self.MinVal[-1]
        val2 = val
        if val1 >= val2:
            self.MinVal.append(val2)
        else:
            self.MinVal.append(val1)
# Your MinStack object will be instantiated and called as such:
# obj = MinStack()
# obj.push(val)
# obj.pop()
# param_3 = obj.top()
# param_4 = obj.getMin()