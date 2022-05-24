# Time Complexity : O(N/K) where N is the total number of values to be hashed and k is the predefined bucket size
#Space Complexity : (k+m) where k is the predefined bucket size and M is the number of unique values inserted into the hashset
# Did this code successfully run on Leetcode : yes
# Any problem you faced while coding this : No

#Problem explanation: the hash key values are interpreted as array starting from index 0 to keyrange-1 index and the bucket to store values for each
# key index is linked list as array would take O(N)  time complexity to insert or delete a value whereas linkedlist it is O(1)

class MyHashSet:
    # O(1) for the operations in hashset
    def __init__(self):
        self.keyrange = 10
        self.bucketArray = [Bucket() for i in range(self.keyrange)]

    def _hash(self, key):
        return key % self.keyrange

    def add(self, key):
        bucketindex = self._hash(key)
        self.bucketArray[bucketindex].insert(key)

    def remove(self, key):
        bucketindex = self._hash(key)
        self.bucketArray[bucketindex].delete(key)

    def contains(self, key):
        bucketindex = self._hash(key)
        return self.bucketArray[bucketindex].exists(key)


class Node:
    def __init__(self, value, nextnode=None):
        self.value = value
        self.next = nextnode

# We are creating a pseudo head inorder to keep reference to actual head of linkedlist which reduces the number of branching.
# we insert a new value not in the list already to head of the bucket so that reduntant values comparison is easier and more likely that we spot the value at the head of the bucket
class Bucket:
    def __init__(self):
        self.head = Node(0)

    def insert(self, newValue):
        if not self.exists(newValue):
            newNode = Node(newValue, self.head.next)
            self.head.next = newNode

    def delete(self, value):
        prev = self.head
        curr = self.head.next
        while curr is not None:
            if value == curr.value:
                prev.next = curr.next
                return
            prev = curr
            curr = curr.next

    def exists(self, value):
        curr = self.head.next
        while curr is not None:
            if value == curr.value:
                return True
            curr = curr.next
        return False
