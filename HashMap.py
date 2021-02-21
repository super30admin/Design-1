class Node:
    def __init__(self, data):
        self.data = data
        self.next = None


class MyHashMap:

    def __init__(self):
        self.hashtable = [None] * 1000

        """
        Initialize your data structure here.
        """

    def _hash(self, data):

        return hash(data) % 1000

    def put(self, key: int, value: int) -> None:
        hk = self._hash(key)
        if self.hashtable[hk] is None:
            self.hashtable[hk] = Node((key, value))
        else:
            current = self.hashtable[hk]
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
        """
        value will always be non-negative.
        """

    def get(self, key: int) -> int:
        hk = self._hash(key)
        if self.hashtable[hk] is None:
            return -1
        current = self.hashtable[hk]
        while current:
            k, v = current.data
            if k == key:
                return v
            current = current.next
        return -1
        """
        Returns the value to which the specified key is mapped, or -1 if this map contains no mapping for the key
        """

    def remove(self, key: int) -> None:
        hk = self._hash(key)
        if self.hashtable[hk] is None:
            return

        current = self.hashtable[hk]

        dummy = Node(0)
        dummy.next = current

        cur = dummy
        while cur and cur.next:
            k, v = cur.next.data
            if k == key:
                cur.next = cur.next.next
            cur = cur.next

        self.hashtable[hk] = dummy.next

        """
        Removes the mapping of the specified value key if this map contains a mapping for the key
        """

# Your MyHashMap object will be instantiated and called as such:
# obj = MyHashMap()
# obj.put(key,value)
# param_2 = obj.get(key)
# obj.remove(key)