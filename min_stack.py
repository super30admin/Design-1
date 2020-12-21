# Time Complexity : O(n) = 1 for all operations except getMin which is O(n) = n
# Space Complexity : O(n) = n
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : I could not figure out how to implement getMin in O(1).
# I thought of a solution with Min heap to perform it with O(n) = log n but could not implement it in time.


# Your code here along with comments explaining your approach

class Node:
    def __init__(self, data):
        self.data = data
        self.next = None
        self.prev = None

class MinStack:

    def __init__(self):
        """
        initialize your data structure here.
        """
        self.stack = []
        self.top_pointer = None

    def push(self, x: int) -> None:
        if not self.top_pointer:
            self.top_pointer = Node(x)
        else:
            self.top_pointer.next = Node(x)
            self.top_pointer.next.prev = self.top_pointer
            self.top_pointer = self.top_pointer.next
        

    def pop(self) -> None:
        if not self.top_pointer:
            return
        else:
            self.top_pointer = self.top_pointer.prev
            if self.top_pointer:
                self.top_pointer.next = None

    def top(self) -> int:
        if self.top_pointer:
            return self.top_pointer.data
        else:
            return -1

    def getMin(self) -> int:
        if not self.top_pointer:
            return None
        current = self.top_pointer
        minimum = self.top_pointer.data
        while current:
            if minimum > current.data:
                minimum = current.data
            current = current.prev
        return minimum

# Your MinStack object will be instantiated and called as such:
obj = MinStack()
obj.push(20)
obj.push(20)
obj.push(40)
obj.push(20)
obj.pop()
param_3 = obj.top()
param_4 = obj.getMin()

print(param_3)
print(param_4)
