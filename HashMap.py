class Node:

    def __init__(self, data):
        self.data = data
        self.next = None


class MyHashMap:

    def __init__(self):
        self.hashmap = [None] * 1000

    def _hash(self, data):

        return hash(data) % 1000

    def put(self, key: int, value: int) -> None:
        """
        value will always be non-negative.
        """
        block = self._hash(key)
        if self.hashmap[block] is None:
            self.hashmap[block] = Node((key, value))
        else:
            current = self.hashmap[block]
            while current:
                k, v = current.data
                if k == key:
                    current.data = (key, value)
                    return
                if current.next is None:
                    break
                else:
                    current = current.next
            current.next = Node((key, value))

    def get(self, key: int) -> int:
        """
        Returns the value to which the specified key is mapped, or -1 if this map contains no mapping for the key
        """
        block = self._hash(key)
        if self.hashmap[block] is None:
            return -1
        current = self.hashmap[block]
        while current:
            k, v = current.data
            if k == key:
                return v
            current = current.next
        return -1

    def remove(self, key: int) -> None:
        """
        Removes the mapping of the specified value key if this map contains a mapping for the key
        """
        block = self._hash(key)
        if self.hashmap[block] is None:
            return

        current = self.hashmap[block]

        dummyNode = Node(0)
        dummyNode.next = current

        cur = dummyNode
        while cur and cur.next:
            k, v = cur.next.data
            if k == key:
                cur.next = cur.next.next
            cur = cur.next

        self.hashmap[block] = dummyNode.next



        """
        Time Complexity: Amortized O(1)
        Space Complexity: O(n) 
        """