
## Time Complexity : O(1) for push, pop, get min
## Space Complexity : O(n)
## Did this code successfully run on Leetcode : Yes

## Any problem you faced while coding this :

# Here I have used linked list as stack. Need help in figuring out other ways to implement this.


import math
class ListNode:
    def __init__(self, data=None, next = None):
        # Initialize node
        self.data = data
        self.next = None

class MinStack:

    def __init__(self):
        """
        initialize your data structure here.
        """
        # Pointer to head of linked list
        self.head = None
        self.min = math.inf
        # Maintain another linked list which just takes min elements
        self.min_pointer = None

    def push(self, x: int) -> None:
        
        # First push it to normal stack
        node_1 = ListNode(x)
        node_1.next = self.head
        self.head = node_1
        # If min, push it to min stack
        if x <= self.min:
            node_2 = ListNode(x)
            node_2.next = self.min_pointer
            self.min_pointer = node_2
            self.min = x

    def pop(self) -> None:
        
        # Pop value from main stack
        values = self.head.data
        temp = self.head.next
        self.head = temp
        # If value == min, pop value from min stack as well
        if values == self.min:
            temp1 = self.min_pointer.next
            self.min_pointer = temp1
            if self.min_pointer:
                self.min = self.min_pointer.data
            else:
                self.min = math.inf
        

    def top(self) -> int:
        
        # Return top of the stack
        return self.head.data

    def getMin(self) -> int:
        
        # Return min value - basically top value of minStack
        return self.min


# Your MinStack object will be instantiated and called as such:
# obj = MinStack()
# obj.push(x)
# obj.pop()
# param_3 = obj.top()
# param_4 = obj.getMin()