# Time Complexity : 
# Space Complexity : 
# Did this code successfully run on Leetcode :
# Any problem you faced while coding this :


# Your code here along with comments explaining your approach
class ListNode:
    def __init__(self, key, val):
        self.pair = (key, val)
        self.next = None

class MyHashMap(object):

    def __init__(self):
        """
        Initialize your data structure here.
        """
        self.mod = 997
        self.hash_map = [None] * self.mod
        

    def put(self, key, value):
        """
        value will always be non-negative.
        :type key: int
        :type value: int
        :rtype: None
        """
        index = key % self.mod
        
        # If index not present, create a new node
        if self.hash_map[index] == None:
            self.hash_map[index] = ListNode(key, value)
        
        # If index already present
        # 1. If key present, update its value
        # 2. If not, create a new node
        else:
            cur = self.hash_map[index]
            # 1. Navigate over te list and Check if key present, then update its value
            while True:
                if cur.pair[0] == key:
                    cur.pair = (key, value)
                    return
                if cur.next == None: break
                cur = cur.next
            # 2. If key not present, append a new node
            cur.next = ListNode(key, value)
        

    def get(self, key):
        """
        Returns the value to which the specified key is mapped, or -1 if this map contains no mapping for the key
        :type key: int
        :rtype: int
        """
        index = key % self.mod
        cur = self.hash_map[index]
        # Navigate through all the nodes at a particular index to get the pair with key
        # else return -1
        while cur:
            if cur.pair[0] == key:
                return cur.pair[1]
            else:
                cur = cur.next
        return -1

    def remove(self, key):
        """
        Removes the mapping of the specified value key if this map contains a mapping for the key
        :type key: int
        :rtype: None
        """
        index = key % self.mod
        
        # Kepp track of current and previous node
        cur = prev = self.hash_map[index]
        if not cur: return
        
        # If key found at first position, set the hashmap index to the next node
        if cur.pair[0] == key:
            self.hash_map[index] = cur.next
        # Else loop over the remaining nodes
        # If found, link the previous node with the current's next node
        else:
            cur = cur.next
            while cur:
                if cur.pair[0] == key:
                    prev.next = cur.next
                    break
                else:
                    cur, prev = cur.next, prev.next


# Your MyHashMap object will be instantiated and called as such:
obj = MyHashMap()
obj.put(1,2)
obj.put(2,3)
print('obj.get(1)', obj.get(1))
print('obj.get(3)', obj.get(3))
obj.put(2,4)
print('obj.get(2)', obj.get(2))
print('obj.remove(2)', obj.remove(2))
print('obj.get(2)', obj.get(2))