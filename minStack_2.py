# Time complexity O(1)
#1. implemented stack using python internal lists.
#2. Used  a set for each list item, where the second element of set stores minimum number in the list.
#3. push, pop and top operations to the stack are O(1), and accessing minimum with set list items can be O(1)
class MinStack:

    def __init__(self):
        # initialize list as stack.
        self.stack = []

    def push(self, x: int) -> None:
        #initialize each list item as set of two elements
        if not self.stack:
            self.stack.append((x,x))
        else:
            self.stack.append((x, min(x,self.stack[-1][1])))
        print(self.stack)

    def pop(self) -> None:
        if self.stack:
            return self.stack.pop()

    def top(self) -> int:
        # accessing top element
        if self.stack:
            return self.stack[-1][0]
        else:return None

    def getMin(self) -> int:
        # accessing min element.
        if self.stack:
            return self.stack[-1][1]
        else:
            return None


obj = MinStack()
obj.push(-2)
obj.push(0)
obj.push(-3)
print(obj.getMin())
print(obj.pop())
print(obj.top())
print(obj.getMin())