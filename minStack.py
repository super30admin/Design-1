#Time Complexity : O(n) for getMin
#Space Complexity : O(1) space doesnt use extra space.
#Did this code successfully run on Leetcode : Yes
#Any problem you faced while coding this : No, but want to find if there is an efficient way of solving this.


class MinStack:

    def __init__(self):
        self.items = []

    def push(self, val: int) -> None:
        self.items.append(val)

    def pop(self) -> None:
        return self.items.pop()
    
    def show(self):
        return self.items

    def top(self) -> int:
        return self.items[len(self.items) - 1]

    def getMin(self) -> int:
        min = self.items[0]
        for num in self.items:
            if num < min:
                min = num
        return min

minStack = MinStack()
minStack.push(-2)
minStack.push(0)
minStack.push(-3)
print(minStack.show())
print(minStack.getMin()) #// return -3
minStack.pop()
print(minStack.show())
print(minStack.top())   #// return 0
print(minStack.getMin())#// return -2
print(minStack.show())