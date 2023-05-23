# // Time Complexity : O(1)
# // Space Complexity : O(n)
# // Did this code successfully run on Leetcode : Yes
class MinStack:

    def __init__(self):
        self.q = []
        

    def push(self, val: int) -> None:
        self.q.append(val)

    def pop(self) -> None:
        self.q.pop()

    def top(self) -> int:
        return self.q[-1]

    def getMin(self) -> int:
        return min(self.q)


# Your MinStack object will be instantiated and called as such:
# obj = MinStack()
# obj.push(val)
# obj.pop()
# param_3 = obj.top()
# param_4 = obj.getMin()    


# Another way using LinkedList
# // Time Complexity : O(1) for Push, pop and top and O(n) fo getMin Operation
# // Space Complexity : O(n)
# // Did this code successfully run on Leetcode : Yes

class ListNode:
    def __init__(self, data = 0, next = None):
        self.val = data
        self.next = next

class MinStack:

    def __init__(self):
        self.head = None

    def push(self, val: int) -> None:
        newNode = ListNode(val)
        if self.head is None:
            self.head = newNode
        else:
            newNode.next = self.head
            self.head = newNode

    def pop(self) -> None:
        if self.head:
            if self.head.next:
                self.head = self.head.next
            else:
                self.head = None


    def top(self) -> int:
        if self.head:
            return self.head.val

    def getMin(self) -> int:
        node = self.head
        minVal = float('inf')
        while node:
            if minVal > node.val:
                minVal = node.val
            node = node.next
        return minVal



# Your MinStack object will be instantiated and called as such:
# obj = MinStack()
# obj.push(val)
# obj.pop()
# param_3 = obj.top()
# param_4 = obj.getMin()