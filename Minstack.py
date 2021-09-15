"""
Time Complexity :
push : O(1)
pop : O(1)
top: O(1)
isEmpty: O(1)
isFull: O(1)
getMin: O(1)

Space Complexity :
push : O(1)
pop : O(1)
top: O(1)
isEmpty: O(1)
isFull: O(1)
 
"""
iimport sys
class MinStack:

    def __init__(self):
        """
        initialize your data structure here.
        """
        self.st = []
        self.m = sys.maxsize
        self.size = 5

    def push(self, val : int) -> None:
        if val <= self.m:
            self.st.append(self.m)
            self.st.append(val)
            self.m = val
        else:
            self.st.append(val)
            # print(self.st)

    def pop(self) -> None:
        if self.st[-1] == self.m:
            self.st.pop()
            self.m = self.st[-1]
            self.st.pop()
            # print(self.st)
        else:
            self.st.pop()
            # print(self.st)

    def top(self) -> int:
        # print(self.st[-1])
        return self.st[-1]

    def isEmpty(self):
        if self.isEmpty:
            # print("stack is empty")
            # print(self.st)
            return self.st

    def isFull(self):
        if self.isFull:
            # print("full")
            return True
    def getMin(self) -> int:
        # print(self.m)
        return self.m

# Your MinStack object will be instantiated and called as such:obj = MinStack()
if __name__ == '__main__':
    obj = MinStack()
    obj.push(5)
    obj.push(7)
    obj.push(7)
    obj.push(3)
    obj.push(2)
    obj.isFull()
    obj.getMin()
    obj.pop()
# param_3 = obj.top()
# param_4 = obj.getMin()
