'''
Time Complexity : Average is O(1)
Space Complexity : O(n + m), where n is primary DS and m is Secondary
Did this code successfully run on Leetcode : Yes
Any problem you faced while coding this : No
Your code here along with comments explaining your approach:
        hashed the key using large prime number
        secondary DS used is singly linked list
        hash the key and hash will give index.
        Use the index to access the linked list.
'''

class ListNode:
    def __init__(self, key = -1, next = None):
        self.key = key
        self.next = next

class MyHashSet:

    def __init__(self):
        self.set=[ListNode() for i in range(2096)]

    def add(self, key: int) -> None:
        index = key % 2096
        curr = self.set[index]
        while curr.next:
            if curr.next.key == key:
                return
            curr = curr.next
        
        curr.next = ListNode(key)
        

    def remove(self, key: int) -> None:
        index = key % 2096
        prev = self.set[index]
        curr = prev.next

        while curr:
            if curr.key == key:
                prev.next = curr.next
            prev = curr
            curr = curr.next
        
    def contains(self, key: int) -> bool:
        index = key % 2096
        curr = self.set[index]
        while curr:
            if curr.key == key:
                return True
            curr = curr.next
        
        return False
        


# Your MyHashSet object will be instantiated and called as such:
# obj = MyHashSet()
# obj.add(key)
# obj.remove(key)
# param_3 = obj.contains(key)