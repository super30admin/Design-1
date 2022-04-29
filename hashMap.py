'''
time complexity: O(n)
space complexity: O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No
'''
class Node:
    def __init__(self,key,value):
        self.key = key
        self.value = value
        self.next = None
class MyHashMap:

    def __init__(self):
        self.bucket = 1000
        self.storage = [None] * self.bucket 
        
    def bucketHash(self,key: int) -> int:
        return key % self.bucket
    
    
    def find(self,head,key):

        prev = None
        curr = head
        while(curr!=None and curr.key!=key):
            prev = curr
            curr = curr.next
        return prev
        
    def put(self, key: int, value: int) -> None:
        hashValue = self.bucketHash(key)
        if(self.storage[hashValue]==None):
            self.storage[hashValue] = Node(-1,-1)
        prev = self.find(self.storage[hashValue],key)
        if(prev.next==None):
            prev.next = Node(key,value)
        else:
            prev.next.value = value

    def get(self, key: int) -> int:
        hashValue = self.bucketHash(key)
        if(self.storage[hashValue]==None): return -1
        prev = self.find(self.storage[hashValue],key)
        if(prev.next==None): return -1
        return prev.next.value
        

    def remove(self, key: int) -> None:
        hashValue = self.bucketHash(key)
        if(self.storage[hashValue]==None): return
        prev = self.find(self.storage[hashValue],key)
        if(prev.next==None): return 
        prev.next = prev.next.next


# Your MyHashMap object will be instantiated and called as such:
# obj = MyHashMap()
# obj.put(key,value)
# param_2 = obj.get(key)
# obj.remove(key)