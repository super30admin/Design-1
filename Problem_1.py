### MinStack Problem

class MinStack:
    def __init__(self) -> None:
        self.stk = []
        self.min = []

    def push(self, x : int) -> None :
        if not self.stk:
            self.stk.append(x)
            self.min.append(x)
        else:
            self.stk.append(x)
        if x <= self.min[-1]: # used <= because there can be more than 1 same  min numbers if there are 2 mins and one is removed the other is still a min
            self.min.append(x)

    def pop(self, x : int) -> None :
        if self.min[-1] == self.stk[-1]:
            self.stk.pop()
            self.min.pop()
        else :
            self.stk.pop()

    def top(self) -> int:
        return self.stk[-1]
    
    def min(self) -> int:
        return self.min[-1]
