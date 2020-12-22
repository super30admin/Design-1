# Time Complexity: O(1) for put/get/remove since there is O(1) accessing with arrays
# Space Complexity: O(N) where N is number of unique keys that is put inside the hashmap. 
#         Should be O(N + size when I defined my data structure in myHashMap class) nontheless O(N)
# Did this code successfully run on Leetcode: Yes
# Any problem you faced while coding this: Stumbled during the part of implmenting a linkedlist. Had to
# draw it out really quick to fix the minor error. But thats about it.


# Your code here along with comments explaining your approach.
#   - Wanted to use an array of linkedlists to implement my hashMap
#
class Node: #Create a node class to hold the keys/values as well as pointer to the next node 
    def __init__(self, key=None, val=None):
        self.key = key 
        self.val = val
        self.next = None

#O(N) time and space
class LL:  #needs insert/get/search/deletion
    def __init__(self):
        self.head = Node()
    
    #O(1)
    #Adds a key/val pair to the linkedlist
    def insert(self, key, val):
        curr = self.search(key)
        if curr:
            curr.val = val 
        else:
            newNode = Node(key, val)
            newNode.next = self.head.next 
            self.head.next = newNode
    
    #O(N)
    #retrieves the value when passing in a key
    def get(self, key):
        curr = self.search(key)
        if curr: 
            return curr.val 
        
        return -1 #doesn't exist 
        
    #O(N) look up.
    def search(self, key):
        curr = self.head 
        while curr:
            if curr.key == key:
                return curr
            curr = curr.next 
        return None
    #O(N)
    #delete/remove the key
    def deletion(self, key):
        prev = self.head 
        curr = self.head.next 
        while curr:
            if curr.key == key:
                break #found key
            prev = curr
            curr = curr.next 
        if curr: #remove 
            prev.next = prev.next.next
    
class MyHashMap:

    def __init__(self):
        """
        Initialize your data structure here.
        """
        self.size = 10000
        self.mapping = [LL() for i in range(self.size)]
    
    #O(N)
    def put(self, key: int, value: int) -> None:
        """
        value will always be non-negative.
        """
        hashing = key % self.size 
        self.mapping[hashing].insert(key,value)

    def get(self, key: int) -> int:
        """
        Returns the value to which the specified key is mapped, or -1 if this map contains no mapping for the key
        """
        hashing = key % self.size 
        val = self.mapping[hashing].get(key)
        return val 
    #O(N)
    def remove(self, key: int) -> None:
        """
        Removes the mapping of the specified value key if this map contains a mapping for the key
        """
        hashing = key % self.size 
        self.mapping[hashing].deletion(key)


# Your MyHashMap object will be instantiated and called as such:
# obj = MyHashMap()
# obj.put(key,value)
# param_2 = obj.get(key)
# obj.remove(key)

obj = MyHashMap()
obj.put(12,13)
print(obj.get(12))
print(obj.remove(12))
print(obj.get(12))
