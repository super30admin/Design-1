"""
The basic idea is to when we push the val <= current min:
we will insert into stack current min
set current min=val
insert into stack val

while popping when stack.pop()==current min
we just pop another time and assign that value to min, as that was the previous min value

"""
class MinStack:
    def __init__(self):
        """
        initialize your data structure here.
        """
        self.stack=[]
        self.min=float("inf")

    def push(self, x: int) -> None:
        if x<=self.min:
            self.stack.append(self.min)
            self.min=x
        self.stack.append(x)
            
            

    def pop(self) -> None:
        val=self.stack.pop()
        if self.min==val:
            self.min=self.stack.pop()
        

    def top(self) -> int:
        if len(self.stack)>0:
            return self.stack[-1]
        return -1

    def getMin(self) -> int:
        if self.min!=float("inf"):
            return self.min
        return -1

#     def __init__(self):
#         """
#         initialize your data structure here.
#         """
#         self.stack=[]

#     def push(self, x: int) -> None:
#         if len(self.stack)==0:
#             self.stack.append([x,x])
#         else:
#             top=self.stack[-1]
#             self.stack.append([x,min(top[1],x)])
            

#     def pop(self) -> None:
#         if len(self.stack)>0:
#             self.stack.pop()

#     def top(self) -> int:
#         if len(self.stack)>0:
#             return self.stack[-1][0]
#         return -1

#     def getMin(self) -> int:
#         if len(self.stack)>0:
#             return self.stack[-1][1]
#         return -1


