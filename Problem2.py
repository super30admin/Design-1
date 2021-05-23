# Time Complexity : push -> O(1) pop -> o(1) top -> O(1) getMin -> O(1)
# Space Complexity : O(n) n is number of operations
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : I did this problem already so there was
# no problem but first time i tried for so long and refered the solution(it was long back)
class Node:
    def __init__(self,val):
        self.next = None
        self.val = val
class MinStack:

    def __init__(self):
        """
        initialize your data structure here.
        """
        self.head = None
        self.len = 0
        self.m = None

    def push(self, val: int) -> None:
        if self.len == 0:
            self.head = Node(val)
            self.m = val
            self.len = 1
        else:
            node = None
            if val < self.m:
                v = 2*val - self.m
                self.m = val
                node = Node(v)     
            else:
                node = Node(val)
            node.next = self.head
            self.head = node
            self.len = self.len + 1

    def pop(self) -> None:
        if self.len != 0:
            if self.head.val < self.m:
                self.m = 2 * self.m - self.head.val
            self.head = self.head.next
            self.len = self.len - 1

    def top(self) -> int:
        if self.head.val < self.m:
            return self.m
        else:
            return self.head.val

    def getMin(self) -> int:
        return self.m


# Your MinStack object will be instantiated and called as such:
# obj = MinStack()
# obj.push(val)
# obj.pop()
# param_3 = obj.top()
# param_4 = obj.getMin()