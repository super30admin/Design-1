#Approach:
#Appending an item only takes O(1) time complexity
#To pop, last element in the list has to be deleted, so accessing the element at the last position takes only O(1)
#Accessing the element at the last index directly from the list


class MinStack:

    def __init__(self):
        self.stack=[]

    def push(self, val: int) -> None:
        self.stack.append(val)

    def pop(self) -> None:
        self.stack.pop(len(self.stack)-1)

    def top(self) -> int:
        return self.stack[len(self.stack)-1]

    def getMin(self) -> int:
        minstack=sorted(self.stack)
        return minstack[0]


# Your MinStack object will be instantiated and called as such:
# obj = MinStack()
# obj.push(val)
# obj.pop()
# param_3 = obj.top()
# param_4 = obj.getMin()