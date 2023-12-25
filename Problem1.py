# Time Complexity :  O(1)  (when initilizing a vertical it will take O(hash1))
# Space Complexity :  O(self.size)

# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : Dynamically allocating the array instead of initiazing at the beginning

import math


class MyHashSet:
    def __init__(self):
        self.size = 10**6
        self.hash1 = math.ceil(self.size**(1/2))
        self.arr = [None for _ in range(self.hash1)]

    def add(self, key: int) -> None:
        idxHorizontal = key % self.hash1
        idxVertical = key // self.hash1
        if self.arr[idxHorizontal] is None:
            if idxHorizontal == 0:
                self.arr[idxHorizontal] = [False] * (self.hash1 + 1)
            else:
                self.arr[idxHorizontal] = [False] * self.hash1

        self.arr[idxHorizontal][idxVertical] = True

    def remove(self, key: int) -> None:
        idxHorizontal = key % self.hash1
        idxVertical = key // self.hash1
        if self.arr[idxHorizontal] is not None:
            self.arr[idxHorizontal][idxVertical] = False

    def contains(self, key: int) -> bool:
        idxHorizontal = key % self.hash1
        idxVertical = key // self.hash1
        return self.arr[idxHorizontal] is not None and self.arr[idxHorizontal][idxVertical]

# Approach 2


class ListNode:
    def __init__(self, val=False):
        self.val = val
        self.next = None


class MyHashSet:

    def __init__(self):
        self.size = 10**6
        self.hash1 = math.ceil(self.size**(1/2))

        self.arr = [[ListNode(0)]for _ in range(self.hash1)]

    def add(self, key: int) -> None:
        index = key % self.hash1
        curr = self.arr[index][0]

        while curr.next:
            if curr.next.val == key:
                return
            curr = curr.next
        curr.next = ListNode(key)

    def remove(self, key: int) -> None:
        index = key % self.hash1
        curr = self.arr[index][0]
        while curr.next:
            if curr.next.val == key:
                curr.next = curr.next.next
                return

            curr = curr.next

    def contains(self, key: int) -> bool:
        index = key % self.hash1
        curr = self.arr[index][0]

        while curr.next:
            if curr.next.val == key:
                return True
            curr = curr.next

        return False


# Your MyHashSet object will be instantiated and called as such:
# obj = MyHashSet()
# obj.add(key)
# obj.remove(key)
# param_3 = obj.contains(key)
