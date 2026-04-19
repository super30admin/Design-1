# Uses linked lists to handle hash collisions across 1000 buckets.
# Each bucket has a dummy head node; add/remove/contains traverse the chain at key % 1000.

# Time Complexity: average per operation O(1)
# Space Complexity: O(n + k) 

"""
@author: chinmayprajapati
"""

class ListNode:
    def __init__(self, key = -1, next = None):
        self.key = key
        self.next = next

class MyHashSet:

    def __init__(self):
        self.map = [ListNode() for i in range(1000)]

    def hash(self, key):
        return key % len(self.map)

    def add(self, key: int) -> None:
        current = self.map[self.hash(key)]
        while current.next:
            if current.next.key == key:
                return
            current = current.next
        current.next = ListNode(key)
       

    def remove(self, key: int) -> None:
        current = self.map[self.hash(key)]
        while current.next:
            if current.next.key == key:
                current.next = current.next.next
                return 
            current = current.next
        
 
    def contains(self, key: int) -> bool:
        current = self.map[self.hash(key)].next
        while current:
            if current.key == key:
                return True
            current = current.next
        return False    
