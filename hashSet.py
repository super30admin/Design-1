# Time Complexity : O(N/K) where K is key range or number of buckets
# Space Complexity : O(K+M) where M is number of unique values inserted in Hashset
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : No


# Your code here along with comments explaining your approach

class MyHashSet:

    def __init__(self):
        self.key_range = 1000
        self.array_list = [List() for i in range(self.key_range)]

    def hash_fn(self, key):
        return key % self.key_range
    
    def add(self, key: int) -> None:
        index = self.hash_fn(key)
        self.array_list[index].insert(key)

    def remove(self, key: int) -> None:
        index = self.hash_fn(key)
        self.array_list[index].delete(key)

    def contains(self, key: int) -> bool:
        index = self.hash_fn(key)
        return self.array_list[index].exists(key)
    

class Node:
    
    def __init__(self, value, new_node=None):
        self.value = value
        self.next = new_node
        

class List:
    
    def __init__(self):
        self.head = Node(0)
        
    def exists(self, val):
        curr = self.head.next
        while curr is not None:
            if curr.value == val:
                return True
            curr = curr.next
        return False
        
    def insert(self, val):#only if val does not exist, gotta insert cuz its a hashset
        if not self.exists(val):
            new_node = Node(val, self.head.next)
            self.head.next = new_node
            
    def delete(self, val):
        prev = self.head
        curr = self.head.next
        while curr is not None:
            if curr.value == val:
                prev.next = curr.next
                return
            prev = curr
            curr = curr.next
