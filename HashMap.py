# Design Hashmap (https://leetcode.com/problems/design-hashmap/)
# Time complexity: O(N/k); N=number of all possible keys, k=size of table
# Space complexity: O(k+M); k=size of table, M=number of unique keys inserted in linkedlists
# Did this code successfully run on Leetcode : Yes
# Approach: Used separate chaining technique: Array + LinkedList

class ListNode:
    def __init__(self, key, value):
        self.pair = (key, value)
        self.next = None

class MyHashMap:

    def __init__(self):
        """
        Initialize your data structure here.
        """
        self.capacity = 100
        self.hashmap = [None] * self.capacity
        
    def hash_function(self, key):
        return key % self.capacity
        

    def put(self, key: int, value: int) -> None:
        """
        value will always be non-negative.
        """
        hash_val = self.hash_function(key)
        
        if self.hashmap[hash_val] == None:
            self.hashmap[hash_val] = ListNode(key, value)
        else:
            curr = self.hashmap[hash_val]
            while True:
                if curr.pair[0] == key:
                    curr.pair = (key,value)
                    break
                if curr.next == None:
                    curr.next = ListNode(key,value)
                    break  
                curr = curr.next

    def get(self, key: int) -> int:
        """
        Returns the value to which the specified key is mapped, or -1 if this map contains no mapping for the key
        """
        hash_val = self.hash_function(key)
        
        curr = self.hashmap[hash_val]
        while curr:
            if curr.pair[0] == key:
                return curr.pair[1]
            curr = curr.next
            
        return -1

    def remove(self, key: int) -> None:
        """
        Removes the mapping of the specified value key if this map contains a mapping for the key
        """
        hash_val = self.hash_function(key)
        
        curr = prev = self.hashmap[hash_val]
        
        if not curr:
            return 
        if curr.pair[0] == key:
            self.hashmap[hash_val] = curr.next
        else:
            curr = curr.next
            while curr:
                if curr.pair[0] == key:
                    prev.next = curr.next
                    break
                else:
                    curr, prev = curr.next, prev.next

        


# Your MyHashMap object will be instantiated and called as such:
# obj = MyHashMap()
# obj.put(key,value)
# param_2 = obj.get(key)
# obj.remove(key)