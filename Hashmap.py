class MyHashMap:

    def __init__(self):
        """
        Initialize your data structure here.
        """
        self.nodes = [None] * 10000

    def put(self, key: int, value: int) -> None:
        """
        value will always be non-negative.
        """
        index = self.getIndex(key)
        prev = self.findElement(index, key)
        if prev.next == None:
            prev.next = ListNode(key, value)
        else:
            prev.next.value = value

    def get(self, key: int) -> int:
        """
        Returns the value to which the specified key is mapped, or -1 if this map contains no mapping for the key
        """
        index = self.getIndex(key)
        prev = self.findElement(index, key)
        if prev.next != None:
            return prev.next.value
        else:
            return -1

    def remove(self, key: int) -> None:
        """
        Removes the mapping of the specified value key if this map contains a mapping for the key
        """
        index = self.getIndex(key)
        prev = self.findElement(index, key)
        if prev.next != None:
            prev.next = prev.next.next

    def getIndex(self, key) -> int:

        index = key % 10000

        return index

    def findElement(self, index, key):
        if self.nodes[index] == None:
            self.nodes[index] = ListNode(-1, -1)
            return self.nodes[index]
        prev = self.nodes[index]
        while (prev.next != None and prev.next.key != key):
            prev = prev.next

        return prev


class ListNode:

    def __init__(self, key, val):
        self.key = key
        self.value = val
        self.next = None

# Your MyHashMap object will be instantiated and called as such:
# obj = MyHashMap()
# obj.put(key,value)
# param_2 = obj.get(key)
# obj.remove(key)