# TC is O(1): for all push, pop, top and getMin()
# SC is O(n): Storing two integers for each element in the stack. If pushing n elements,then it's O(2n) = O(n) space

#The approach involves storing extra information with each stack element. 
#Each element holds both its value and the minimum value up to that point. 
#This allows always keeping the current minimum at the top of the stack.

class MinStack:

    def __init__(self):
        self.list = [] # List/stack to store pairs of [value, min_value]

    def push(self, val: int) -> None:
        if len(self.list)==0: #if not self.list:
            self.list.append([val,val]) #If empty, the new element is also the minimum
        else:
            minimum = min(val, self.list[-1][1]) #get min between current val and last stored minumum. -1 gives top element of the list where at 0, val is stored and at 1, minumum is stored
            self.list.append([val,minimum])

    def pop(self) -> None:
        self.list.pop()

    def top(self) -> int:
        if len(self.list)==0:
            return None #return 0
        return self.list[-1][0]

    def getMin(self) -> int:
        if len(self.list)==0:
            return None #return 0
        return self.list[-1][1] # return minimum stored with top element