class Node:

    def __init__(self, key=None, value=None):
        self.key = key
        self.value = value
        self.next = None


class MyHashMap:

    def __init__(self):
        self.length = 10 ^ 4
        self.arraylist = [None] * self.length

    def index(self, key):
        return key % self.length

    def find(self, head, key):
        previous = head
        current = head
        while current and current.key != key:
            previous = current
            current = current.next
        return previous

    def put(self, key: int, value: int) -> None:
        """
        value will always be non-negative.
        """
        array_index = self.index(key)

        if not self.arraylist[array_index]:
            node = Node()
            self.arraylist[array_index] = node

        previous = self.find(self.arraylist[array_index], key)
        if previous.next:
            previous.next.value = value
        else:
            previous.next = Node(key, value)

    def get(self, key: int) -> int:
        """
        Returns the value to which the specified key is mapped, or -1 if this map contains no mapping for the key
        """

        array_index = self.index(key)

        if not self.arraylist[array_index]:
            return -1
        previous = self.find(self.arraylist[array_index], key)
        if previous.next:
            return previous.next.value
        else:
            return -1

    def remove(self, key: int) -> None:
        """
        Removes the mapping of the specified value key if this map contains a mapping for the key
        """
        array_index = self.index(key)
        # print(array_index)
        if not self.arraylist[array_index]:
            return
        previous = self.find(self.arraylist[array_index], key)
        if previous.next:
            previous.next = previous.next.next
        else:
            return

# Your MyHashMap object will be instantiated and called as such:
# obj = MyHashMap()
# obj.put(key,value)
# param_2 = obj.get(key)
# obj.remove(key)