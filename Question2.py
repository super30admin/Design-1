#Time-Complexity: O(1)
#Space-Complexity: O(n)

class ListNode:
    
    def __init__(self, val=None, minimum_value=float('inf')):
        self.val = val
        self.next = None
        self.prev = None
        self.minimum_value = minimum_value
        
class MinStack:

    def __init__(self):
        self.head = ListNode()

    def push(self, val: int) -> None:
        n = ListNode(val, val)
        
        if self.head.minimum_value < n.minimum_value:
            n.minimum_value = self.head.minimum_value
        
        self.head.next = n 
        n.prev = self.head
        self.head = self.head.next

    def pop(self) -> None:
        if self.head.prev:
            self.head = self.head.prev
            self.head.next = None

    def top(self) -> int:
        return self.head.val
    
    def getMin(self) -> int:
        return self.head.minimum_value