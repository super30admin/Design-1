class MinStack:

    def __init__(self):
        """
        initialize your data structure here.
        """
        self.s=[]

    def push(self, x: int) -> None:
        #here we will push x and min(x,topelement) so that
        #while we retrieve the min element, it happens in O(1) time

        if not self.s:
            self.s.append((x,x))
            return

        mini = self.s[-1][1]
        self.s.append((x,min(x,mini)))




    def pop(self) -> None:
        return self.s.pop()



    def top(self) -> int:
        return self.s[-1][0]


    def getMin(self) -> int:
        return self.s[-1][1]



obj = MinStack()
obj.push(5)
obj.push(-3)
obj.pop()
param_3 = obj.top()
print(param_3)
param_4 = obj.getMin()
print(param_4)
