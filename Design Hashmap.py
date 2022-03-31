# We consciously take a decision, that the length of the linked list will
# not be 1000 but 10000 becaues each node will have 100 elements this way
# which is still possible to go through in case of collisions.

# Time Complexity = O(1)
# Space Complexity = O(N)
# Did this code successfully run on Leetcode : Yes. It got accepted, without any errors.
# Any problem you faced while coding this : None


class Node:
    def __init__(self, key):
        self.key = key
        self.val = None
        self.next = None


class MyHashMap:

    SIZE = 10000

    def __init__(self):
        self.listValue = [Node(-1) for _ in range(self.SIZE)]

    def put(self, key: int, value: int) -> None:
        head = self.listValue[key % self.SIZE]
        current = head.next
        while current:
            if current.key == key:
                break
            current = current.next
        else:
            current = Node(key)
            current.next = head.next
            head.next = current
        current.val = value

    def get(self, key: int) -> int:
        current = self.listValue[key % self.SIZE].next
        while current:
            if current.key == key:
                break
            current = current.next
        else:
            return -1
        return current.val

    def remove(self, key: int) -> None:
        current = self.listValue[key % self.SIZE]
        while current and current.next:
            if current.next.key == key:
                break
            current = current.next
        else:
            return None
        current.next = current.next.next


# Your MyHashMap object will be instantiated and called as such:
# obj = MyHashMap()
# obj.put(key,value)
# param_2 = obj.get(key)
# obj.remove(key)
