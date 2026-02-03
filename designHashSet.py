# Time Complexity: O(1) average
# Space Complexity: O(n) where n is the number of keys 
# Did this code successfully run on LeetCode: Yes
# Any problem faced while coding: No
# Approach: Used chaining with linked list for collision


class Node:
    def __init__(self,key):
        self.key = key
        self.next = None

class MyHashSet:
    def __init__(self):
        self.hset = [Node(0) for i in range(10**4)]

    def add(self, key: int) -> None:
        curr = self.hset[key % len(self.hset)]
        while curr.next:
            if curr.next.key == key:
                return
            curr = curr.next
        curr.next = Node(key)

    def remove(self, key: int) -> None:
        curr = self.hset[key % len(self.hset)]
        while curr.next:
            if curr.next.key == key:
                curr.next = curr.next.next
                return
            curr = curr.next

    def contains(self, key: int) -> bool:
        curr = self.hset[key % len(self.hset)]
        while curr.next:
            if curr.next.key == key:
                return True
            curr = curr.next
        return False
        


# Your MyHashSet object will be instantiated and called as such:
# obj = MyHashSet()
# obj.add(key)
# obj.remove(key)
# param_3 = obj.contains(key)




