"""
https://leetcode.com/problems/design-hashmap/

Space Complexity: O(n)
Runtime Complexity:
Here, in worst case n = 100, it is constant.
put --> O(1)
get --> O(1)
remove --> O(1)
"""


class Node:
    def __init__(self, key, value):
        self.key = key
        self.value = value
        self.next = None


class MyHashMap:

    def __init__(self):
        """
        Initialize your data structure here.
        """
        self.size = 10001 # increasing size of primary array as we will be iterating through linked list
        self.node = [None for _ in range(0, self.size)]  # primary array. Later you will put linked list node into it.

    def put(self, key: int, value: int) -> None:
        """
        value will always be non-negative.
        """
        index = hash(key) % self.size  # hashing --> key%10001
        if self.node[index] is None:
            self.node[index] = Node(key, value)  # initialize linked list
        elif self.node[index].key == key:  # same key, update value
            self.node[index].value = value
        else:
            n = self.node[index]
            while n.next:  # iterate through linked list to check for key
                if n.next.key == key:
                    n.next.value = value
                    return
                else:
                    n = n.next
            n.next = Node(key, value)

    def get(self, key: int) -> int:
        """
        Returns the value to which the specified key is mapped, or -1 if this map contains no mapping for the key
        """
        index = hash(key) % self.size
        if self.node[index] is None:
            return -1
        elif self.node[index].key == key:
            return self.node[index].value
        else:
            n = self.node[index]
            while n.next:
                if n.next.key == key:
                    return n.next.value
                else:
                    n = n.next
            return -1

    def remove(self, key: int) -> None:
        """
        Removes the mapping of the specified value key if this map contains a mapping for the key
        """
        index = hash(key) % self.size
        n = self.node[index]
        if self.node[index] is None:
            return
        elif self.node[index].key == key:
            self.node[index] = n.next
        else:
            while n.next:
                if n.next.key == key:
                    n.next = n.next.next
                else:
                    n = n.next

# Your MyHashMap object will be instantiated and called as such:
# obj = MyHashMap()
# obj.put(key,value)
# param_2 = obj.get(key)
# obj.remove(key)