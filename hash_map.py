# // Time Complexity :
# put - O(1) - Assuming int keys
# get - O(1) Asymptomatic - Assuming int keys and low probability of collisions 
# get - O(n) in the worst case, if there are many collisions, the performance degrades to a linked list lookup
# remove - O(1) asymptomatic, O(n) worst case

# // Space Complexity : O(n)

# // Did this code successfully run on Leetcode : Yes
# // Any problem you faced while coding this : No


# // Your code here along with comments explaining your approach

# Every entry in the hashmap is represented as a ListNode
class Entry:
    def __init__(self, key, val):
        self.key = key
        self.val = val
        self.next = None

class MyHashMap(object):

    def __init__(self):
        """
        Initialize your data structure here.
        """
        # Initialize keyspace with a prime number to minimize collisions
        self.key_space = 997
        self.hash_table = [None] * self.key_space
    
    # Hash Function
    def get_index(self, key):
        """
        Return the hashed key - index for the array
        """
        # Computing the hash is not required for the leetcode version of the problem
        # This step makes the design agnostic to the datatype of keys (assuming it is hashable, immutable)
        hash_code = hash(key)
        # Compute the modulo hash for keys
        index = key % self.key_space
        return index

    def put(self, key, value):
        """
        value will always be non-negative.
        :type key: int
        :type value: int
        :rtype: None
        """
        index = self.get_index(key)
        if self.hash_table[index] == None: # key does not exist, create a new entry for this key 
            self.hash_table[index] = Entry(key, value)
        else: # Collision! - Traverse the list and append a new entry OR if the key exists, update it's value
            curr = self.hash_table[index]
            while True:
                if curr.key == key:
                    curr.val = value #update
                    return
                if curr.next == None: break
                curr = curr.next
            curr.next = Entry(key, value)  
        

    def get(self, key):
        """
        Returns the value to which the specified key is mapped, or -1 if this map contains no mapping for the key
        :type key: int
        :rtype: int
        """
        index = self.get_index(key)
        curr = self.hash_table[index]
        while curr:
            if curr.key == key:
                return curr.val
            else:
                curr = curr.next
        return -1

    def remove(self, key):
        """
        Removes the mapping of the specified value key if this map contains a mapping for the key
        :type key: int
        :rtype: None
        """
        index = self.get_index(key)
        # This is the equivalent of deleting a node from a Singly Linked List
        # Use two pointer - to keep track of current and previous nodes
        curr = self.hash_table[index]
        if not curr: return
        if curr.key == key: # Delete head
            self.hash_table[index] = curr.next
        else: # Traverse list till node is found, point prev.next to curr.next
            prev = curr
            curr = curr.next
            while curr:
                if curr.key == key:
                    prev.next = curr.next
                    break
                else:
                    curr, prev = curr.next, prev.next


# Your MyHashMap object will be instantiated and called as such:
# obj = MyHashMap()
# obj.put(key,value)
# param_2 = obj.get(key)
# obj.remove(key)