""" Using double hashing """
# Time Complexity : O(1) all operations
# Space Complexity : O(N) for N is the max value of key (10^6)
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : No
class MyHashMap:

    def __init__(self):
        # using double hashing
        self.max = 1000
        self.hm = [None for _ in range(self.max)]
    
    
    def _getHashValues(self, key): # returns a tuple (hashval1, hashval2)
        return (key % self.max, int(key / self.max))
        

    def put(self, key: int, value: int) -> None:
        hv1, hv2 = self._getHashValues(key)  
        if self.hm[hv1] is None:
            self.hm[hv1] = [None for _ in range(self.max)] if hv1 != 0 else [None for _ in range(self.max+1)]
        self.hm[hv1][hv2] = value
        

    def get(self, key: int) -> int:
        hv1, hv2 = self._getHashValues(key)
        if self.hm[hv1] is None or self.hm[hv1][hv2] is None:
            return -1
        else:
            return self.hm[hv1][hv2]
        

    def remove(self, key: int) -> None:
        hv1, hv2 = self._getHashValues(key)
        if self.hm[hv1] is None:
            return
        self.hm[hv1][hv2] = None
            
        
# Your MyHashMap object will be instantiated and called as such:
# obj = MyHashMap()
# obj.put(key,value)
# param_2 = obj.get(key)
# obj.remove(key)


""" Using array + Linkedlist """
class Node:
        def __init__(self, key: int, val:int):
            self.key = key # (key, value)
            self.val = val
            self.next = None

# Time Complexity : O(N) all operations
# Space Complexity : O(N) for N is the number of keys inserted
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : using tuple (k, v) as data in Linked List Node was not a good idea, as we need to update the value.
# later on, changed to int key, int val.
class MyHashMap_UsingLinkedList:
    
    def __init__(self):
        # using Array + Linked List
        self.max = 10**4 # (this would restrict max len on LL to 100 as 10**6 k,v pairs is given by problem statement)
        self.hm = [None for _ in range(self.max)]
    
    
    def _getHashValue(self, key): # returns hashval
        return key % self.max
    
    
    def _search(self, head, key): # search LinkedList for a key
        prev = head # (-1, -1) pair dummy node
        current = head.next # first actial pair node
        while current is not None and current.key != key:
            prev = current
            current = current.next
        return prev
        

    def put(self, key: int, value: int) -> None:
        hv = self._getHashValue(key)
        if self.hm[hv] is None:
            head = Node(-1, -1) # pre-head
            head.next = Node(key, value)
            self.hm[hv] = head
        else:
            prev = self._search(self.hm[hv], key)
            if prev.next is None:
                prev.next = Node(key, value)
            else:
                prev.next.val = value
            
        
    def get(self, key: int) -> int:
        hv = self._getHashValue(key)
        if self.hm[hv] is None:
            return -1
        else:
            prev = self._search(self.hm[hv], key)
            if prev.next is None:
                return -1
            else:
                return prev.next.val
        

    def remove(self, key: int) -> None:
        hv = self._getHashValue(key)
        if self.hm[hv] is None:
            return
        prev = self._search(self.hm[hv], key)
        if prev.next is None:
            return
        else:
            prev.next = prev.next.next