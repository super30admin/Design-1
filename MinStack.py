# Time Complexity : O(1) for all operations.
# Space Complexity : O(2n) = O(n)
# Did this code successfully run on Leetcode : yes
# Any problem you faced while coding this :no
class Node:
    def __init__(self, data):
        self.data = data
        self.next = None
class Stack:
    def __init__(self, default = None) -> None:
        self.head = None
        self.default = default
        self.size = 0
    def push(self,data):
        new = Node(data)
        if self.head is None: self.head = new
        else:
            new.next = self.head
            self.head = new
        self.size += 1
    def pop(self):
        if self.head is None: return self.default
        data = self.head.data
        self.head = self.head.next
        self.size -= 1
        return data
    def empty(self):
        return self.head is None
    def peek(self):
        if self.empty(): return self.default
        else: return self.head.data
class MinStack:

    def __init__(self):
        self.stack  = Stack()
        self.minStack = Stack()

        

    def push(self, val: int) -> None:
        self.stack.push(val)
        if self.minStack.empty(): self.minStack.push(val)
        else: self.minStack.push(min(val, self.minStack.peek()))
        

    def pop(self) -> None:
        if self.stack.empty(): return 
        self.stack.pop()
        self.minStack.pop()
        

    def top(self) -> int:
        return self.stack.peek()
        

    def getMin(self) -> int:
        return self.minStack.peek()