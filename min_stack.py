# min-stack implementation using array
# to find minimum value, we go over each element and find minimum and return it

import sys
class Stack:
    def __init__(self):
        self.array = [sys.maxsize for i in range(100)]
        self.top_of_stack = -1

    def push(self, item):
        if self.top_of_stack >= 100:
            raise Exception("Stack Full")
        self.top_of_stack += 1
        self.array[self.top_of_stack] = item

    def pop(self) -> int:
        if self.top_of_stack == -1:
            raise Exception("Stack is empty")
        value = self.array[self.top_of_stack]
        self.top_of_stack-=1
        return value

    def min_stack(self) -> int:
        min_item = sys.maxsize
        for i in range(len(self.array)):
            min_item = min(min_item, self.array[i])
        return min_item
        
if __name__ == "__main__":
    s = Stack()
    s.push(10)
    s.push(11)
    s.push(12)
    s.push(7)
    s.pop()
    print(s.min_stack())