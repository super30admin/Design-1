"""
Design a HashSet without using any built-in hash table libraries.

Implement MyHashSet class:

void add(key) Inserts the value key into the HashSet.
bool contains(key) Returns whether the value key exists in the HashSet or not.
void remove(key) Removes the value key in the HashSet. If key does not exist in the HashSet, do nothing.



 Time Complexity : O(N/k) where N is the number of all possible values and K is the number of predefined
    buckets, which is 887.
 Space Complexity : O(M+k), M is the number of unique value added
 Did this code successfully run on Leetcode : Yes
 Any problem you faced while coding this : Yes
 Your code here along with comments explaining your approach
"""

class MyHashSet:

    def __init__(self):
        self.range = 887
        self.hash_arr = [Hasing() for i in range(self.range)]
        
    def _hash(self,key):
        return key % self.range
        
    def add(self, key: int) -> None:
        index = self._hash(key)
        self.hash_arr[index].add_node(key)
        

    def remove(self, key: int) -> None:
        index = self._hash(key)
        self.hash_arr[index].remove_node(key)
        

    def contains(self, key: int) -> bool:
        index = self._hash(key)
        return self.hash_arr[index].is_present(key)
                                              
                                              
class Node:
    def __init__(self,data, next = None):
        self.data = data
        self.next = next
        
class Hasing():
    def __init__(self):
        self.head = Node(0)
        
    def add_node(self, data):
        if not self.is_present(data):
            node = Node(data, self.head.next)
            self.head.next = node
            
    def remove_node(self, val):
        if self.head is None:
            return
        
        prev = self.head
        curr = self.head.next
        while curr is not None:
            if curr.data == val:
                prev.next = curr.next
                return
            prev = curr
            curr = curr.next
            
    def is_present(self,value):
        if self.head is None:
            return False
        
        curr = self.head.next
        while curr is not None:
            if curr.data == value:
                return True
            curr = curr.next
        return False
            
                
        

# Your MyHashSet object will be instantiated and called as such:
# obj = MyHashSet()
# obj.add(key)
# obj.remove(key)
# param_3 = obj.contains(key)