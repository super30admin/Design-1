class Node(object):
    def __init__(self,key,val):
        self.key = key
        self.val = val
        self.next = None

"""
Amortized complexities of put, get and remove operations are O(1), however worst case complexities are O(n). 
We did not use any extra space other than the space required to store (key,value) pair in Hashmap. 
The code successfully submitted on Leetcode.

"""

class MyHashMap(object):
            
    def __init__(self):
        """
        Initialize your data structure here.
        """
        self.size = 10^4
        self.hashmap = [None]*self.size
        
    def getPrevious(self,key):
        
        loc = hash(key)%self.size
        head = self.hashmap[loc]
        while(head.next is not None and head.next.key!=key):
            head = head.next
        return head
    
    def put(self, key, value):
        """
        value will always be non-negative.
        :type key: int
        :type value: int
        :rtype: None
        """
        newNode = Node(key,value)
        loc = hash(key)%self.size
        head = self.hashmap[loc]
        if(head is None):
            self.hashmap[loc] = newNode
        elif(head.key == key):
            self.hashmap[loc].val = value
        else:
            head = self.getPrevious(key)
            if(head.next is not None):
                newNode.next = head.next.next
            head.next = newNode
            

    def get(self, key):
        """
        Returns the value to which the specified key is mapped, or -1 if this map contains no mapping for the key
        :type key: int
        :rtype: int
        """
        loc = hash(key)%self.size
        head = self.hashmap[loc]
        if(head is None):
            return -1
        elif(head.key == key):
            return head.val
        else:
            head = self.getPrevious(key)
            if(head.next is not None):
                return head.next.val
            return -1

    def remove(self, key):
        """
        Removes the mapping of the specified value key if this map contains a mapping for the key
        :type key: int
        :rtype: None
        """
        loc = hash(key)%self.size
        head = self.hashmap[loc]
        if head is None:
            return
        elif(head.key == key):
            self.hashmap[loc] = self.hashmap[loc].next
        else:
            head = self.getPrevious(key)
            if(head.next is not None):
                head.next = head.next.next


# Your MyHashMap object will be instantiated and called as such:
# obj = MyHashMap()
# obj.put(key,value)
# param_2 = obj.get(key)
# obj.remove(key)