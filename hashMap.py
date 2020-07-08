
# Time Complexity : O(n) for put, get and remove
# Space Complexity : O(n)
# Did this code successfully run on Leetcode : yes
# Any problem you faced while coding this : Confused regarding the initialization of nodes array .

class Node:
    def __init__(self, key, val):
        self.key = key
        self.val = val
        self.next = None


class MyHashMap:

    def __init__(self):
        """
        Initialize your data structure here.
        """
        self.nodes = [None]*10000

    def put(self, key: int, value: int) -> None:
        """
        value will always be non-negative.
        """
        index = self.getIndex(key)
        prev = self.findElement(key, index)
        if prev.next == None:
            prev.next = Node(key, value)
        else:
            prev.next.val = value

    def get(self, key: int) -> int:
        """
        Returns the value to which the specified key is mapped, or -1 if this map contains no mapping for the key
        """
        index = self.getIndex(key)
        prev = self.findElement(key, index)

        if prev.next != None:
            return prev.next.val
        else:
            return -1

    def remove(self, key: int) -> None:
        """
        Removes the mapping of the specified value key if this map contains a mapping for the key
        """
        index = self.getIndex(key)
        prev = self.findElement(key, index)
        if prev.next != None:
            prev.next = prev.next.next

    def getIndex(self, key: int) -> int:
        return key % 10000

    def findElement(self, key: int, index: int) -> Node:

        if self.nodes[index] == None:
            self.nodes[index] = Node(-1, -1)
            return self.nodes[index]
        prev = self.nodes[index]
        while (prev.next != None and prev.next.key != key):
            prev = prev.next
        return prev
