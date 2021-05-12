# space complexity - O(n)
# time complexity - O(1)
# using 2 stack approach - one main stack and other is min stack
class MinStack:

    def __init__(self):
        """
        initialize your data structure here.
        """
        self.stackMain = []
        self.stackMin = []

    def push(self, x: int) -> None:
        if not self.stackMin:
            self.stackMin.append(float('inf'))
        self.stackMain.append(x)
        self.stackMin.append(min(x,self.stackMin[-1]))
        # print(self.stackMain,self.stackMin)


    def pop(self) -> None:
        if self.stackMain:
            self.stackMin.pop()
            return self.stackMain.pop()

    def top(self) -> int:
        if self.stackMain:
            return self.stackMain[-1]
        else: return None

    def getMin(self) -> int:
        if self.stackMin:
            return self.stackMin[-1]
        else:
            return None


ms = MinStack()
ms.push(20)
ms.push(30)
ms.push(10)
ms.push(4)
print(ms.pop())
print(ms.getMin())
print(ms.push(15))
print(ms.top())
print(ms.getMin())

