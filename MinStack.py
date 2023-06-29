# time complexity : O(1)
# space complexity : O(n)
class MinStack:
    def __init__(self):
        self.l = []
        self.min = []

    def push(self, val: int) -> None:
        self.l.append(val)
        val = min(val, self.min[-1] if self.min else val)
        self.min.append(val)
        

    def pop(self) -> None:
        self.l.pop()
        self.min.pop()
        

    def top(self) -> int:
        return self.l[-1]

    def getMin(self) -> int:
        return self.min[-1]
        


obj = MinStack()
obj.push(-2)
obj.push(0)
obj.push(-3)
print(obj.getMin())
obj.pop()
print(obj.top())   
print(obj.getMin())