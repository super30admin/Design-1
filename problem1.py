# Time Complexity :
#   put: O(n)
#   get: O(n)
#   remove: O(n)

# Space Complexity:
#     O(n)
#  Did this code successfully run on Leetcode : Yes

class Node:

    def __init__(self, key, value):
        self.next = None
        self.key = key
        self.value = value


class MyHashMap:

    def __init__(self):
        self.buckets = 10000
        self.nodes = [None] * self.buckets

    def getHash(self, key):
        return hash(key) % self.buckets

    def find(self, node, key):
        prev = node
        curr = node.next

        while curr != None and prev.next.key != key:
            prev = curr
            curr = curr.next
        return prev

    def put(self, key: int, value: int) -> None:
        index = self.getHash(key)
        if self.nodes[index] is None:
            self.nodes[index] = Node(-1, -1)
        prev = self.find(self.nodes[index], key)
        if prev.next == None:
            prev.next = Node(key, value)
        else:
            prev.next.value = value

    def get(self, key: int) -> int:
        index = self.getHash(key)
        if self.nodes[index] is None:
            return -1
        prev = self.find(self.nodes[index], key)
        if prev.next == None:
            return -1
        else:
            return prev.next.value

    def remove(self, key: int) -> None:
        index = self.getHash(key)
        if self.nodes[index] is None:
            return
        prev = self.find(self.nodes[index], key)
        if prev.next == None:
            return
        else:
            prev.next = prev.next.next

# Your MyHashMap object will be instantiated and called as such:
# obj = MyHashMap()
# obj.put(key,value)
# param_2 = obj.get(key)
# obj.remove(key)