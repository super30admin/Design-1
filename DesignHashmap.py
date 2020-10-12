#Time Complexity : O(n/k) where n = all possible key entries and k = number of defined buckets
#Space Complexity : O(n) where n = number of entries (number of keys+values)
#Did this code successfully run on Leetcode : Yes
#Any problem you faced while coding this : No

class ListNode:
    def __init__(self, key, value):
        self.node = (key, value)
        self.next = None

class MyHashMap:
    def __init__(self):
        """
        Initialize your data structure here.
        """
        self.m = 1000
        self.hashmap = [None]*self.m


    def put(self, key: int, value: int) -> None:
        """
        value will always be non-negative.
        """
        index = key % self.m
        if self.hashmap[index] == None:
            self.hashmap[index] = ListNode(key, value)
        else:
            curr = self.hashmap[index]
            while True:
                if curr.node[0] == key:
                    curr.node = (key, value)
                    return
                if curr.next == None:
                    break
                curr = curr.next
            curr.next = ListNode(key, value)


    def get(self, key: int) -> int:
        """
        Returns the value to which the specified key is mapped, or -1 if this map contains no mapping for the key
        """
        index = key % self.m
        curr = self.hashmap[index]
        while curr:
            if curr.node[0] == key:
                return curr.node[1]
            else:
                curr = curr.next
        return -1


    def remove(self, key: int) -> None:
        """
        Removes the mapping of the specified value key if this map contains a mapping for the key
        """
        index = key % self.m
        curr = prev = self.hashmap[index]
        if not curr:
            return
        if curr.node[0] == key:
            self.hashmap[index] = curr.next
        else:
            curr = curr.next
            while curr:
                if curr.node[0] == key:
                    prev.next = curr.next
                    break
                else:
                    curr, prev = curr.next, prev.next
