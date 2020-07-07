class MinStack:

    def __init__(self):
        """
        initialize your data structure here.
        """
        self.stack = []

    def push(self, x: int) -> None:
        self.stack.append(x)

    def pop(self) -> None:
        if len(self.stack) >0:
            return self.stack.pop()

    def top(self) -> int:
        if len(self.stack) >0:
            return self.stack[-1]

    def getMin(self) -> int:
        min_ele = float("inf")
        for i in range(len(self.stack)):
            if self.stack[i] < min_ele:
                min_ele = self.stack[i]
        return min_ele
    
if __name__ == "__main__":
    ms = MinStack()
    ms.push(3)
    ms.push(2)
    ms.push(1)
    print("pop = ",ms.pop())
    print("top = ",ms.top())
    print("min = ",ms.getMin())
    