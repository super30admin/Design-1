"""
Approach : Use a list  of fixed size (10000) in this case because we have atmost 10000 operations.
Given a key take the mod of 10000 and insert a BST node in the associate position

Order mentioned along with the method
"""

class BSTNode(object):
    key = None
    value = None
    left = None
    right = None
    
    def __init__(self, k, v):
        self.key = k
        self.value = v
        self.left = None
        self.right = None
    
    def add(self, k, v):
        if self.key == k:
            self.value = v
        elif (self.key > k) and (self.left is None):
            self.left = BSTNode(k, v)
        elif (self.key > k) and (self.left is not None):
            self.left.add(k, v)
        elif (self.key < k) and (self.right is None):
            self.right = BSTNode(k, v)
        elif (self.key < k) and (self.right is not None):
            self.right.add(k, v)
        
        return
    
    def get(self, k):
        if self.key == k:
            return self.value
        elif (self.key > k) and (self.left is None):
            return None
        elif (self.key > k) and (self.left is not None):
            return self.left.get(k)
        elif (self.key < k) and (self.right is None):
            return None
        elif (self.key < k) and (self.right is not None):
            return self.right.get(k)


class MyHashMap(object):
    arr = None
    MAP_SIZE = 10000
    
    def __init__(self):
        """
        Initialize your data structure here.
        """
        self.arr = [None for i in range(self.MAP_SIZE)]
    
    def put(self, key, value):
        """
        value will always be non-negative.
        O(log(n))
        :type key: int
        :type value: int
        :rtype: None
        """
        idx = key % self.MAP_SIZE
        if not self.arr[idx]:
            self.arr[idx] = BSTNode(key, value)
        else:
            self.arr[idx].add(key, value)
    
    def get(self, key):
        """
        Returns the value to which the specified key is mapped, or -1 if this map contains no mapping for the key
        :type key: int
        :rtype: int
        O(log(n))
        """
        idx = key % self.MAP_SIZE
        if not self.arr[idx]:
            r = self.arr[idx].get(key)
            return -1 if r is None else r
        else:
            return -1
    
    def remove(self, key):
        """
        Removes the mapping of the specified value key if this map contains a mapping for the key
        :type key: int
        :rtype: None
        O(log(n))
        """
        idx = key % self.MAP_SIZE
        if not self.arr[idx]:
            self.arr[idx].add(key, -1)

# Your MyHashMap object will be instantiated and called as such:
# obj = MyHashMap()
# obj.put(key,value)
# param_2 = obj.get(key)
# obj.remove(key)
