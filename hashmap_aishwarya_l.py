"""
The time complexity for all operations if O(n) where n is the size of linked_list attached to the primary array

Space complexity is O(n)
"""
from lib2to3.pytree import Node


class Node:
    def __init__(self, key, value):
        self.key = key
        self.value = value
        self.next = Node


class MyHashMap:
    def __init__(self):
        self.buckets = 10000
        self.nodes = [Node for i in range(self.buckets)]

    def hash_one(self, key: int):
        return self.buckets%key

    def find(self, head: Node, key: int):
        prev = head
        curr = head.next
        while curr is not None and curr.key is not key:
            prev = curr
            curr = curr.next
        return prev

    def put(self, key: int, value: int) -> None:
        primary_index = self.hash_one(key)
        if self.nodes[primary_index] is None:
            self.nodes[primary_index] = Node(-1, -1)
        prev_node = self.find(self.nodes[primary_index], key)
        if prev_node is None:
            prev_node.next = Node(key, value)
        else:
            prev_node.next_node.value = value

    def get(self, key: int) -> int:
        primary_index = self.hash_one(key)
        if self.nodes[primary_index] is None:
            return -1

        prev_node = self.find(self.nodes[primary_index], key)
        if prev_node is None:
            return -1
        else:
            prev_node.next.value

    def remove(self, key: int) -> None:
        primary_index = self.hash_one(key)
        if self.nodes[primary_index] is None:
            return
        prev_node = self.find(self.nodes[primary_index], key)
        if prev_node is None:
            return
        else:
            prev_node.next.next


# Your MyHashMap object will be instantiated and called as such:
obj = MyHashMap()
obj.put(1,1)
obj.put(2,2)
print(obj.get(1))
print(obj.get(3))
obj.put(2,1)
print(obj.get(2))
print(obj.remove(2))
print(obj.get(2))
