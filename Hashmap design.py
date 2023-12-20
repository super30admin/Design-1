# Time Complexity : O(n)
# Space Complexity : O(m+n) m = no of buckers, n = no of key value pairs
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : No


# Your code here along with comments explaining your approach: Created a hashmap using List of python for inserstion, retruevak and removal of key value pairs.
class ListNode:
    def __init__(self, key=-1, val=-1, next=None):
        self.key = key
        self.val = val
        self.next = next

class MyHashMap:
    def __init__(self):
        self.map = [ListNode() for i in range(1000)]
        
    def calc(self, key):
        return key % len(self.map)

    def put(self, key: int, value: int) -> None:
        cur = self.map[self.calc(key)]
        while cur.next:
            if cur.next.key == key:
                cur.next.val = value
                return
            cur = cur.next
        cur.next = ListNode(key, value)
         
    def get(self, key: int) -> int:
        cur = self.map[self.calc(key)].next
        while cur and cur.key != key:
            cur = cur.next
        if cur:
            return cur.val
        return -1

    def remove(self, key: int) -> None:
        cur = self.map[self.calc(key)]
        while cur.next and cur.next.key != key:
            cur = cur.next
        if cur and cur.next:
            cur.next = cur.next.next
