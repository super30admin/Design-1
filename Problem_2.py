# Time Complexity - O(1) for each operations
# Space Complexity - O(n) for n Nodes of elements
# Approach - I used singly Linked List which has three variables, value, min_so_far, and next and started of with
# with head, whenever we need to add a new value in the stack I add it after head and compare the min value of previous node
# with the new node created, this helps if I popped the minimum value because after removing the minimum value the value
# of minimum in the stack will change this idea will give us O(1) solution
# This approach successfully ran in Leetcode
#

class ListNode:
    def __init__(self, val: int):
        self.value = val
        self.min_so_far = float("inf")
        self.next = None

class Minstack:
    def __init__(self):
        self.head = ListNode(-1)

    def push(self, val: int):
        new_node = ListNode(val)
        old_node = self.head.next
        self.head.next = new_node
        new_node.next = old_node
        if old_node:
            new_node.min_so_far = min(old_node.min_so_far, val)
        else:
            new_node.min_so_far = val

    def pop(self):
        node = self.head.next
        self.head.next = node.next
        return node.value

    def top(self):
        node = self.head.next
        if node:
            return node.value

    def getMin(self):
        node = self.head.next
        if node:
            return node.min_so_far

    def show(self):
        res = []
        curr = self.head.next
        while curr:
            res.append((curr.value, curr.min_so_far))
            curr = curr.next
        return res

s = Minstack()
s.push(-2)
s.push(0)
s.push(-3)
print(s.show())
print(s.getMin())
print(s.pop())
print(s.top())
print(s.getMin())
print(s.show())
