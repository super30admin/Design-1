# Time Complexity : O(1)
# Space Complexity : O(N)
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this :No

class Node:
    def __init__(self,key=None,val=None):
        self.key = key
        self.val = val
        self.next = None
        
class MyHashMap:

    def __init__(self):
        self.bucketSize = 10000
        self.bucket = [None] * self.bucketSize
        
    def find(self, head, key):
        prev = head
        curr = head.next
        
        while curr is not None and curr.key != key:
            prev = curr
            curr = curr.next
            
        return prev
        
    def getHash(self,key):
        return key % self.bucketSize
        
    def put(self, key: int, value: int) -> None:
        index = self.getHash(key)
        if self.bucket[index] is None:
            self.bucket[index] = Node(-1,-1)
        
        prev = self.find(self.bucket[index],key)
        
        if prev.next is None:
            prev.next = Node(key,value)
        else:
            prev.next.val = value
        
        
    def get(self, key: int) -> int:
        index = self.getHash(key)
        if self.bucket[index] is None:
            return -1
        
        prev = self.find(self.bucket[index],key)
        
        if prev.next is None:
            return -1
        return prev.next.val   

    def remove(self, key: int) -> None:
        index = self.getHash(key)
        if self.bucket[index] is None:
            return
        
        prev = self.find(self.bucket[index],key)
        
        if prev.next is None:
            return 
        prev.next = prev.next.next
        
        