class Node:
    def __init__(self, val, min_):
        self.val = val
        self.next = None
        self.min_ = min_


class MinStack:

    def __init__(self):
        self.head = None

    def push(self, x: int) -> None:
        if self.head:
            curr_min = min(x, self.head.min_)
        else:
            curr_min = x
        n = Node(x, curr_min)
        if self.head:
            n.next = self.head
        self.head = n

    def pop(self) -> None:
        result = self.head.val
        self.head = self.head.next
        return result

    def top(self) -> int:
        if self.head:
            return self.head.val
        else:
            return None

    def getMin(self) -> int:
        return self.head.min_

obj = MinStack()
obj.push(10)
obj.push(17)
print(obj.pop())
obj.push(6)
obj.push(19)
print(obj.getMin())
obj.push(5)
print(obj.pop())
obj.push(12)
obj.push(1)
obj.push(14)
print(obj.pop())
print(obj.top())
print(obj.getMin())

"""
Space Complexity: O(1) 
Time Complexity:
push: O(1)
pop: O(1)
top: O(1)
getmin: O(1)
"""
