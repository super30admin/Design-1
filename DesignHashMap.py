# Time Complexity : O(1) for all operations for keys from 1 to 10**6. Each bucket can be of size 100 in worst case.
# Space Complexity : O(n) where n is the size of universe of keys. n = 10^6
# Did this code successfully run on Leetcode : yes
# Any problem you faced while coding this :no
class LinkedList:
    class Node:
        def __init__(self, key, value):
            self.key = key
            self.value = value
            self.next = None
    def __init__(self) -> None:
        self.head = None
        self.tail = None
    def add(self, key, value):
        new = LinkedList.Node(key, value)
        if self.head is None:
            self.head = self.tail = new
        else:
            self.tail.next = new
            self.tail = new
    def findNodes(self, key):
        prev = None
        curr = self.head
        while curr:
            if curr.key == key:
                return (prev, curr)
            prev = curr 
            curr = curr.next
        return None, None

    def remove(self, key):
        prev, curr = self.findNodes(key)
        if curr is None: return 
        if prev is None:
            self.head = self.head.next
        else:
            prev.next = curr.next
            if curr == self.tail:
                self.tail = prev
class MyHashMap:
    BUCKETS = 10000
    def __init__(self):
        self.buckets = [None] * MyHashMap.BUCKETS
    def put(self, key, value):
        index = key % MyHashMap.BUCKETS
        if self.buckets[index] is None:
            self.buckets[index] = LinkedList()
        _,existing = self.buckets[index].findNodes(key)
        if existing is not None:
            existing.value = value
        else:
            self.buckets[index].add(key, value)
    def get(self, key):
        index = key % MyHashMap.BUCKETS
        if self.buckets[index] is None: return -1
        _, existing = self.buckets[index].findNodes(key)
        return -1 if existing is None else existing.value

    def remove(self, key):
        index = key % MyHashMap.BUCKETS
        if self.buckets[index] is None: return 
        self.buckets[index].remove(key)


