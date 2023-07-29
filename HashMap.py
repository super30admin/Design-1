#use find method to fing the prev node use it in put method if bucket has no node then define dummy node(-1,-1)
#to get value also use previous node and if prev node has next node return that value
#to remove value use prev node and make next node value none
class MyHashMap:

    class Node:
        def __init__(self,key:int,value:int):
            self.key=key
            self.value=value
            self.next=None
    def find(self,key:int,head:Node)->Node:
        prev=head
        curr=head.next
        while curr!=None and curr.key!=key:
            prev=curr
            curr=curr.next
        return prev

    def __init__(self):
        self.buckets=10000
        self.storage=[None]* self.buckets
    
    def getBucket(self, key:int)->int:
        return hash(key)%self.buckets

    def put(self, key: int, value: int) -> None:
        bucket=self.getBucket(key)
        if self.storage[bucket]==None:
            self.storage[bucket]=self.Node(-1,-1)
        
        prev=self.find(key,self.storage[bucket])
        if prev.next==None:
            prev.next=self.Node(key,value)
        else:
            prev.next.value=value

    def get(self, key: int) -> int:
        bucket=self.getBucket(key)
        if self.storage[bucket]==None:
            return -1
        prev=self.find(key,self.storage[bucket])
        if prev.next==None:
            return -1
        return prev.next.value

    def remove(self, key: int) -> None:
        bucket=self.getBucket(key)
        if self.storage[bucket]==None:
            return
        prev=self.find(key,self.storage[bucket])
        if prev.next==None:
            return
        prev.next=prev.next.next
