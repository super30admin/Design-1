# Design Hashmap
''' Time Complexity : O(hashmapsize/bucketsize) for put, get remove functions
// Space Complexity : O(hashmapsize+Bucketsize) 
// Did this code successfully run on Leetcode : YES
// Any problem you faced while coding this : Took some time to understand the concept and key hashing'''

class Node:# linked list to create buckets
    def __init__(self,data):
        self.data = data # data contains both key and value
        self. next = None
        
class MyHashMap:
    ''' 1. find hash key _hash function -  criteria should be min numbe rof collision.           h(k) = k mod m. let m be size = 10.
    2. Create a fixed size hash map 
    3. put - insertion - find the block using hash key and then insert the value          under hashed key as a linked list node
    4. get - find the block using hash key and find the element from linked list
    5. remove - find the block using hash key and remove the element fro linked list''' 

    def __init__(self):
        """
        Initialize your data structure here.
        """
        #hashmap of fixed size - array
        self.hashmap = [None]*1000
        
    def _hash(self,data):
        return data%10

    def put(self, key: int, value: int) -> None:
        """
        value will always be non-negative.
        """
        bucket = self._hash(key) # identify the bucket
        if self.hashmap[bucket] is None:
            self.hashmap[bucket] = Node((key, value))
        else: 
            cur = self.hashmap[bucket]
            while cur: # check if key already present then update the value of key. 
                k,v = cur.data
                if k == key:
                    cur.data = (key,value)
                    return
                if cur.next is None: # reached end of linked list
                    break
                else:
                    cur = cur.next
            cur.next = Node((key, value))
           
        
          
        

    def get(self, key: int) -> int:
        """
        Returns the value to which the specified key is mapped, or -1 if this map contains no mapping for the key
        """
        bucket = self._hash(key) # identify the bucket
        if self.hashmap[bucket] is None:
            return -1
        
        cur = self.hashmap[bucket]
        while cur: # check if key already present then update the value of key. 
            k,v = cur.data
            if k == key:
                return v
            cur = cur.next
        return -1
        
        

    def remove(self, key: int) -> None:
        """
        Removes the mapping of the specified value key if this map contains a mapping for the key
        """
        bucket = self._hash(key) # identify the bucket
        if self.hashmap[bucket] is None:
            return
        cur = self.hashmap[bucket]
        dummyNode = Node(0)
        dummyNode.next = cur
        
        cur = dummyNode
        while cur and cur.next:
            k, v = cur.next.data
            if k == key:
                cur.next = cur.next.next
            cur = cur.next
        
        self.hashmap[bucket] = dummyNode.next
        
        
        
        
        


# Your MyHashMap object will be instantiated and called as such:
# obj = MyHashMap()
# obj.put(key,value)
# param_2 = obj.get(key)
# obj.remove(key)
