# Time Complexity: push,pop,top,getmin-O(1)
#Space Complexity: O(n)

class MinStack:
    
    def __init__(self):
        self.obj=[]

    def push(self, val: int) -> None:
        min_value=self.getMin()
        if min_value==None or val<min_value :
            min_value=val
        self.obj.append((val,min_value))

    def pop(self) -> None:
        del(self.obj[-1])
        
    def top(self) -> int:
        return self.obj[-1][0]

    def getMin(self) -> int:
        if len(self.obj)==0:
            return None
        else:
            return self.obj[-1][1]
        

        # ["MinStack","push","push","push","getMin","pop","top","getMin"]
        # [[],[-2],[0],[-3],[],[],[],[]]
ms=MinStack()
ms.push(-2)
ms.push(0)
ms.push(-3)
ms.getMin()
ms.pop()
ms.top()
ms.getMin()
