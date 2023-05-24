# Time Complexity: O(1) for all operations. 
# Space Complexity: O(n), where n is the number of elements in the stack

# The code ran on Leetcode
class MinStack:

    def __init__(self):
        # Initialize head pointer
        self.head = None

    def push(self, val: int) -> None:
        # Append elements to the left of the head pointer, while keeping track of minimum element so far
        newNode = Node(val)
        if self.head == None:
            self.head = newNode
            self.head.min_so_far = val
        else:
            newNode.next = self.head
            newNode.min_so_far = min(self.head.min_so_far, val)
            self.head = newNode

    def pop(self) -> None:
        # Remove first element from linked list, which is the most recently added element
        if self.head == None:
            return
        temp = self.head
        self.head = self.head.next
        temp.next = None


    def top(self) -> int:
        if self.head == None:
            return
        return self.head.data

    def getMin(self) -> int:
        if self.head == None:
            return
        return self.head.min_so_far
        
# A node class to create elements of stack. It also keeps track of the minimum element 
# seen so far, since we need this value if the minimum element is popped from the stack.

class Node:
    def __init__(self, data):
        self.data = data
        self.next = None
        self.min_so_far = None

# Your MinStack object will be instantiated and called as such:
# obj = MinStack()
# obj.push(val)
# obj.pop()
# param_3 = obj.top()
# param_4 = obj.getMin()