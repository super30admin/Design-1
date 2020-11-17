# Design Hashmap (https://leetcode.com/problems/design-hashmap/)
# Time complexity: O(N/k); N=number of all possible keys, k=size of table
# Space complexity: O(k+M); k=size of table, M=number of unique keys inserted in linkedlists
# Did this code successfully run on Leetcode : Yes
# Approach: Used separate chaining technique: Array + LinkedList


class ListNode:
    def __init__(self, key, val):
        """
        Initialize your data structure here.
        """
        self.pair = (key, val) #storing key,value tuple
        self.next = None #linkedlist next pointer


class MyHashMap:

    def __init__(self):
        """
        Initialize your data structure here.
        """
        self.m = 997 #size of hashtable
        self.h = [None] * self.m #initializing the array
        

    def put(self, key: int, value: int) -> None:
        """
        value will always be non-negative.
        """
        index = key % self.m
        if self.h[index] == None:
            self.h[index] = ListNode(key,value)
        else: #Collision
            cur = self.h[index]
            while True:
                if cur.pair[0] == key:
                    cur.pair = (key, value)
                    return
                if cur.next == None:
                    break
                cur = cur.next
            cur.next = ListNode(key, value)
        
        

    def get(self, key: int) -> int:
        """
        Returns the value to which the specified key is mapped, or -1 if this map contains no mapping for the key
        """
        index = key % self.m
        cur = self.h[index]
        while cur:
            if cur.pair[0] == key:
                return cur.pair[1]
            else:
                cur = cur.next
        return -1

    def remove(self, key: int) -> None:
        """
        Removes the mapping of the specified value key if this map contains a mapping for the key
        """
        index = key % self.m
        cur = prev = self.h[index]
        if not cur:
            return
        if cur.pair[0] == key:
            self.h[index] = cur.next
        else:
            cur = cur.next
            while cur:
                if cur.pair[0] == key:
                    prev.next = cur.next
                    break
                else:
                    cur, prev = cur.next, prev.next


# Your MyHashMap object will be instantiated and called as such:
# obj = MyHashMap()
# obj.put(key,value)
# param_2 = obj.get(key)
# obj.remove(key)