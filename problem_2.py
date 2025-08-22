class MyQueue:

    def __init__(self):
        self.InStack=[]
        self.OutStack=[]
        

    def push(self, x: int) -> None: # O(1)
        self.InStack.append(x)

    def pop(self) -> int: # O(1)
        if self.empty():
            return -1
        self.peek()
        return self.OutStack.pop()


    def peek(self) -> int: # O(1)
        if self.empty():
            return -1
        if not self.OutStack:
            while self.InStack:
                self.OutStack.append(self.InStack.pop())
        return self.OutStack[-1]
        

    def empty(self) -> bool:
        return not self.InStack and not self.OutStack

