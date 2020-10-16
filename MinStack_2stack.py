# Time Complexity : push O(1) pop O(1) in worst O(n) peek O(1) 
# Space Complexity :O(1)
class MinStack2:

    def __init__(self):
        """
        initialize your data structure here.
        """
        #using two stack for stack i am using list
        self.s1=[]
        self.s2=[]
        self.minnum=float('inf')
        self.s2.append(self.minnum)

    def push(self, x: int) -> None:
            self.s1.append(x)
            self.minnum=min(self.minnum,x)
            self.s2.append(self.minnum)



    def pop(self) -> None:
            self.s1.pop()
            self.s2.pop()
            self.minnum=self.peek()

    def peek(self):
            return self.s2[-1]



    def top(self) -> int:
        return self.s1[-1]


    def getMin(self) -> int:
        if self.s1!=[]:
            return (self.minnum)



# Your MinStack object will be instantiated and called as such:
# obj = MinStack()
# obj.push(x)
# obj.pop()
# param_3 = obj.top()
# param_4 = obj.getMin()
