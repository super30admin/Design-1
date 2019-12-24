"""
 Approach 1
"""
# class MyHashMap:
#
#     def __init__(self):
#         """
#         Initialize your data structure here.
#         """
#         self.arr = []
#
#     def put(self, key: int, value: int) -> None:
#         """
#         value will always be non-negative.
#         """
#         for data in self.arr:
#             if data[0] == key:
#                 self.arr.remove(data)
#         self.arr.append((key, value))
#
#     def get(self, key: int) -> int:
#         """
#         Returns the value to which the specified key is mapped, or -1 if this map contains no mapping for the key
#         """
#         for data in self.arr:
#             if data[0] == key:
#                 return data[1]
#         return -1
#
#     def remove(self, key: int) -> None:
#         """
#         Removes the mapping of the specified value key if this map contains a mapping for the key
#         """
#         self.arr = list(filter(lambda item: item[0] != key, self.arr))
#
#
# # Your MyHashMap object will be instantiated and called as such:
# # obj = MyHashMap()
# # obj.put(key,value)
# # param_2 = obj.get(key)
# # obj.remove(key)

"""
 Approach 2
"""


# class MyHashMap:
#
#     def __init__(self):
#         """
#         Initialize your data structure here.
#         """
#         self.arr = [None for i in range(1000000)]
#
#     def put(self, key: int, value: int) -> None:
#         """
#         value will always be non-negative.
#         """
#         self.arr[key] = value
#         return self.arr[key]
#
#     def get(self, key: int) -> int:
#         """
#         Returns the value to which the specified key is mapped, or -1 if this map contains no mapping for the key
#         """
#         if key < len(self.arr) and self.arr[key] is not None:
#             return self.arr[key]
#         return -1
#
#     def remove(self, key: int) -> None:
#         """
#         Removes the mapping of the specified value key if this map contains a mapping for the key
#         """
#         if key < len(self.arr):
#             self.arr[key] = None
#
#
#
# # Your MyHashMap object will be instantiated and called as such:
# # obj = MyHashMap()
# # obj.put(key,value)
# # param_2 = obj.get(key)
# # obj.remove(key)


# class MyHashMap:
#
#     def __init__(self):
#         """
#         Initialize your data structure here.
#         """
#         self.arr = []
#
#     def put(self, key: int, value: int) -> None:
#         """
#         value will always be non-negative.
#         """
#         if len(self.arr) < key:
#             self.arr += [None for _ in range(len(self.arr), key + 1)]
#         self.arr[key] = value
#         return self.arr[key]
#
#     def get(self, key: int) -> int:
#         """
#         Returns the value to which the specified key is mapped, or -1 if this map contains no mapping for the key
#         """
#         if key < len(self.arr) and self.arr[key] is not None:
#             return self.arr[key]
#         return -1
#
#     def remove(self, key: int) -> None:
#         """
#         Removes the mapping of the specified value key if this map contains a mapping for the key
#         """
#         if key < len(self.arr):
#             self.arr[key] = None

class Node:
    def __init__(self, key, value):
        self.key = key
        self.value = value
        self.next = None


class LinkedList:
    def __init__(self):
        self.root = None

    def add(self, key, value):
        cur = self.root
        if not cur:
            self.root = Node(key, value)
        else:
            while cur:
                if cur.key == key:
                    cur.value = value
                    return
                elif cur.next is None:
                    cur.next = Node(key, value)
                    return
                cur = cur.next

    def remove(self, key):
        prev = self.root
        cur = self.root
        while cur:
            if cur.key == key:
                if cur == self.root:
                    self.root = cur.next
                else:
                    prev.next = cur.next
                return
            prev = cur
            cur = cur.next

    def get(self, key):
        cur = self.root
        while cur:
            if cur.key == key:
                return cur.value
            cur = cur.next
        return -1


class MyHashMap:

    def __init__(self):
        """
        Initialize your data structure here.
        """
        self.max = 1000
        self.hash_table = [None] * self.max

    def put(self, key: int, value: int) -> None:
        """
        value will always be non-negative.
        """
        index = self._get_hash(key)
        if self.hash_table[index] is None:
            self.hash_table[index] = LinkedList()
        self.hash_table[index].add(key, value)

    def get(self, key: int) -> int:
        """
        Returns the value to which the specified key is mapped, or -1 if this map contains no mapping for the key
        """
        index = self._get_hash(key)
        if self.hash_table[index]:
            return self.hash_table[index].get(key)
        return -1

    def remove(self, key: int) -> None:
        """
        Removes the mapping of the specified value key if this map contains a mapping for the key
        """
        index = self._get_hash(key)
        if self.hash_table[index]:
            self.hash_table[index].remove(key)

    def _get_hash(self, index: int) -> int:
        return index % self.max

# Your MyHashMap object will be instantiated and called as such:
# obj = MyHashMap()
# obj.put(key,value)
# param_2 = obj.get(key)
# obj.remove(key)
