# Time Complexity: put, get, remove - O(1)
# Space Complexity: O(1)
# Did this code successfully run on Leetcode: Yes
# Any problem you faced while coding this: No

# Solution:

class Node:
    def __init__(self, key, value):
        self.key = key
        self.value = value
        self.next = None


class MyHashMap:
    def __init__(self):
        """
        Initializing the data structure.
        """
        # Array to store the buckets
        self.nodes = [None] * 10000


    def index(self, key: int) -> int:
        """
        Returns the index of the bucket corresponding to the key
        """
        return hash(key) % len(self.nodes)


    def find(self, head: Node, key: int) -> Node:
        """
        Searches the given node and returns its prev node
        """
        curr = prev = head

        while curr and curr.key != key:
            prev = curr
            curr = curr.next

        return prev


    def put(self, key: int, value: int) -> None:
        """
        Inserts the given (key, value) pair into the corresponding bucket if not present, else updates the existing value of the key
        """
        idx = self.index(key)

        if not self.nodes[idx]:
            self.nodes[idx] = Node(-1, -1)

        prev = self.find(self.nodes[idx], key)

        if not prev.next:
            prev.next = Node(key, value)
        else:
            prev.next.value = value


    def get(self, key: int) -> int:
        """
        Returns the value to which the specified key is mapped, or -1 if this map contains no mapping for the key
        """
        idx = self.index(key)

        if not self.nodes[idx]:
            return -1

        prev = self.find(self.nodes[idx], key)

        if not prev.next:
            return -1

        return prev.next.value


    def remove(self, key: int) -> None:
        """
        Removes the mapping of the specified value key if this map contains a mapping for the key
        """
        idx = self.index(key)

        if not self.nodes[idx]:
            return

        prev = self.find(self.nodes[idx], key)

        if not prev.next:
            return

        prev.next = prev.next.next