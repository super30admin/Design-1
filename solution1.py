# Time Complexity : push -> O(n) for all operations since max linked list size for each key could be n and index is hashed
# Space Complexity : push -> O(m), number of unique keys inserted
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : No


# Your code here along with comments explaining your approach

class MyHashSet(object):

    def __init__(self):
        self.key_space = 2069
        # hashset structure
        self.bucketArray = [Bucket() for i in range(self.key_space)]

    def _hash(self, key):
        return key % self.key_space

    def add(self, key):
        bucketIndex = self._hash(key)
        self.bucketArray[bucketIndex].add(key)

    def remove(self, key):
        bucketIndex = self._hash(key)
        self.bucketArray[bucketIndex].remove(key)

    def contains(self, key):
        bucketIndex = self._hash(key)
        return self.bucketArray[bucketIndex].contains(key)

#separate chaining using linked list nodes
class Node:
    def __init__(self, value, nextNode=None):
        self.value = value
        self.next = nextNode

# list of linked list references
class Bucket:
    def __init__(self):
        # a pseudo head 
        self.head = Node(0)

    def add(self, newValue):
        # if it does not exist, add after head
        if not self.contains(newValue):
            newNode = Node(newValue, self.head.next)
            # set the new head
            self.head.next = newNode

    def remove(self, value):
        prev = self.head
        curr = self.head.next
        while curr is not None:
            if curr.value == value:
                # remove the current node
                prev.next = curr.next
                return
            prev = curr
            curr = curr.next

    def contains(self, value):
        curr = self.head.next
        while curr is not None:
            if curr.value == value:
                # value exists already
                return True
            curr = curr.next
        return False