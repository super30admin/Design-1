import sys
class MinStack:

    def __init__(self):
        """
        initialize your data structure here.
        """
        self.items=[]
        self.minItems=[]
        self.head=-1


    def push(self, val: int) -> None:
        curr_min=sys.maxsize
        if self.head!=-1:
            curr_min = self.minItems[self.head]
        self.head+=1
        self.items.append(val)
        if curr_min > val:
            self.minItems.append(val)
        else:
            self.minItems.append(curr_min)


    def pop(self) -> None:
        #temp=self.items[top]
        self.items.pop()
        self.minItems.pop()
        self.head-=1

        #print temp


    def top(self) -> int:
        return self.items[self.head]


    def getMin(self) -> int:
        return self.minItems[self.head]


# Your MinStack object will be instantiated and called as such:
obj = MinStack()
obj.push(4)
obj.push(10)
obj.push(14)
obj.push(2)
obj.pop()
param_3 = obj.top()
param_4 = obj.getMin()
print(param_4)