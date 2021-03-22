# Time Complexity : O(m), where m is the length of the Linked List
# Space Complexity : O(n), where n is the number of elements in the hashmap
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : No

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
        self.hashmap = [None] * 10000

    def generate_hash(self, key: int) -> int:
        return key % 10000

    def put(self, key: int, value: int) -> None:
        """
        value will always be non-negative.
        """
        index = self.generate_hash(key)

        if not self.hashmap[index]:
            self.hashmap[index] = Node(key, value)

        else:
            curr = self.hashmap[index]

            while curr.next and curr.key != key:
                curr = curr.next

            if curr.key == key:
                curr.val = value
            else:
                curr.next = Node(key, value)

    def get(self, key: int) -> int:
        """
        Returns the value to which the specified key is mapped, or -1 if this map contains no mapping for the key
        """
        index = self.generate_hash(key)

        if not self.hashmap[index]:
            return -1
        else:
            curr = self.hashmap[index]

            while curr and curr.key != key:
                curr = curr.next

            if curr:
                return curr.val
            else:
                return -1

    def remove(self, key: int) -> None:
        """
        Removes the mapping of the specified value key if this map contains a mapping for the key
        """
        index = self.generate_hash(key)

        if not self.hashmap[index]:
            return
        else:
            curr = self.hashmap[index]

            if curr.key == key:
                self.hashmap[index] = curr.next

            while curr.next and curr.next.key != key:
                curr = curr.next

            if curr.next:
                curr.next = curr.next.next

            return

# Your MyHashMap object will be instantiated and called as such:
# obj = MyHashMap()
# obj.put(key,value)
# param_2 = obj.get(key)
# obj.remove(key)