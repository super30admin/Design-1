# https://leetcode.com/problems/design-hashmap/
# Time Complexity : O(1) for all of the functions
# Space Complexity : O(n)
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : None

# Your code here along with comments explaining your approach


# hashMap using linear chaining with LinkedLists
# we choose base array of nodes of size 10000
# and use one hash function to find location in primary array
# then use dummy node there as head of linked list and traverse it till the point
# you find the target. Use two pointers curr and prev. And always return prev.
# we choose primary array of 10000, because for a data of size 1 million nums
# each bucket will have a maximum of 100 items in the linkedlist that we need to traverse
# we are trading space for lower time complexity. Longer the linked list longer the time needed
# to traverse each linkedlist in the worst case to find the key
class Node:

    def __init__(self, k, v):
        self.key = k
        self.val = v
        self.next = None
    
    def __str__(self):
        return f"{self.key},{self.val}"

class MyHashMap:

    def __init__(self):
        self._size = 10000
        self.list = [Node(None,None)] * self._size   # init an empty list with dummy Node values

    def hash(self, key):
        return key % self._size

    def find(self, head, target):
        prev = head
        curr = head.next
        while curr != None and curr.key != target:
            prev = curr
            curr = curr.next
        return prev

    def put(self, key: int, value: int) -> None:
        h = self.hash(key)
        prev = self.find(self.list[h], key)
        if not prev.next:
            prev.next = Node(key,value)
        else:
            prev.next.val = value
        
    def get(self, key: int) -> int:
        h = self.hash(key)
        prev = self.find(self.list[h], key)
        if not prev.next:
            return -1
        return prev.next.val

    def remove(self, key: int) -> None:
        h = self.hash(key)
        if not self.list[h]:
            return
        prev = self.find(self.list[h], key)
        if prev.next:
            prev.next = prev.next.next

# Your MyHashMap object will be instantiated and called as such:
obj = MyHashMap()
obj.put(15, "fas")
obj.put(11, "KK")
print(obj.get(15))
print(obj.get(11))
obj.remove(5)