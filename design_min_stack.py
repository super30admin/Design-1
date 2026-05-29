class MinStack:
    def __init__(self):
        self.st = []
        self.min = float('inf')

    def push(self, val: int) -> None:
        if val <= self.min:
            self.st.append(self.min)
            self.min = val
        self.st.append(val)

    def pop(self) -> None:
        if self.st.pop() == self.min:
            self.min = self.st.pop()

    def top(self) -> int:
        return self.st[-1]

    def getMin(self) -> int:
        return self.min