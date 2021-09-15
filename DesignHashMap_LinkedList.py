# Time complexity: O(1)
# Space complexity: O(n)
# Did this code successfully run on Leetcode : yes
# Any problem you faced while coding this : no
class Node:
    def __init__(self, key=-1, val=-1, next=None):
        self.key = key
        self.val = val
        self.next = next


class MyHashMap:

    def __init__(self):
        """
        Initialize your data structure here.
        """
        # given that the total operations performed will be 10^4, it is safe to consider that value for the number of buckets for hashMap
        self.numBuckets = 10001
        # Using List of LinkedList nodes with a dummy head data structure to implement hashmap
        self.hashmap = [Node() for _ in range(self.numBuckets)]

    def getHashKey(self, key):
        return key % self.numBuckets

    def put(self, key: int, value: int) -> None:
        """
        value will always be non-negative.
        """
        hashkey = self.getHashKey(key)
        # assign a pointer to the dummy node and traverse through the linked list until you find the key, if linked list exists. Otherwise create a new ListNode with given key-value pair
        head = self.hashmap[hashkey]
        while head.next:
            if head.next.key == key:
                head.next.val = value
                return
            head = head.next
        head.next = Node(key, value)

    def get(self, key: int) -> int:
        """
        Returns the value to which the specified key is mapped, or -1 if this map contains no mapping for the key
        """
        hashkey = self.getHashKey(key)
        # assign a pointer to the dummy node and traverse through the linked list until you find the key, if linked list exists. Otherwise return -1
        head = self.hashmap[hashkey]
        while head.next:
            if head.next.key == key:
                return head.next.val
            head = head.next
        return -1

    def remove(self, key: int) -> None:
        """
        Removes the mapping of the specified value key if this map contains a mapping for the key
        """
        hashkey = self.getHashKey(key)
        head = self.hashmap[hashkey]
        prev = None
        while head.next:
            if head.next.key == key:
                nodeToDelete = head.next
                head.next = nodeToDelete.next
                nodeToDelete.next = None
                return
            head = head.next


# Your MyHashMap object will be instantiated and called as such:
# obj = MyHashMap()
# obj.put(key,value)
# param_2 = obj.get(key)
# obj.remove(key)
