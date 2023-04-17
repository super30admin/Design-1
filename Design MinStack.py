
#Method 1: Using 2 stacks 
#Time Complexity : O(1)
#Space Complexity : O(2n)


class MinStack:

    def __init__(self):
        self.s1 = [ ]
        self.s2 = [ ]

    def push(self, val: int) -> None:
        self.s1.append(val)
        if self.s2 != [] and self.s2[len(self.s2) - 1] < val :
            self.s2.append(self.s2[len(self.s2) - 1])
        else:
            self.s2.append(val)
        
    def pop(self) -> None:
        self.s1.pop()
        self.s2.pop()

    def top(self) -> int:
        return self.s1[len(self.s1) - 1]
        
    def getMin(self) -> int:
        return self.s2[len(self.s2) - 1]
        


# Your MinStack object will be instantiated and called as such:
# obj = MinStack()
# obj.push(val)
# obj.pop()
# param_3 = obj.top()
# param_4 = obj.getMin()

#--------------------------------------------------------------#
#Method 2: Using 1 stacks 
#Time Complexity : O(1)
#Space Complexity : less than O(2n)

import sys
class MinStack:

    def __init__(self):
        self.stack = [ ]
        self.min = sys.maxsize
        
    def push(self, val: int) -> None:
        if  val <= self.min:
            self.stack.append(self.min)
            self.min = val
        self.stack.append(val)
                
    def pop(self) -> None:
        tmp = self.stack.pop()
        if tmp == self.min:
            self.min = self.stack.pop()
               
    def top(self) -> int:
        return self.stack[len(self.stack) - 1]
        

    def getMin(self) -> int:
        return self.min
        


# Your MinStack object will be instantiated and called as such:
# obj = MinStack()
# obj.push(val)
# obj.pop()
# param_3 = obj.top()
# param_4 = obj.getMin()