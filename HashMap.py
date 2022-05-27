class MyHashMap:
    class Node:
        def __init__(self, key,val):
            self.key=key
            self.val=val
            self.next=None

    def __init__(self):
        self.buckets=1000
        self.storage=[None for i in range(self.buckets)]
    def find(self,head,key):
        prev=head
        curr=head.next
        while curr!=None and curr.key!=key:
            prev=curr
            curr=curr.next
        return prev
    
    def put(self, key: int, value: int) -> None:
        bucket=key % self.buckets
        if self.storage[bucket] is None:
            self.storage[bucket]= self.Node(-1,-1)
        idx=self.find(self.storage[bucket],key)
        if idx.next==None:
            idx.next= self.Node(key,value)
        else:
            idx.next.val=value

    def get(self, key: int) -> int:
        bucket=key % self.buckets
        if self.storage[bucket] is None:
            return -1
        idx=self.find(self.storage[bucket],key)
        if idx.next==None:
            return -1
        return idx.next.val
        
    def remove(self, key: int) -> None:
        bucket=key % self.buckets
        if self.storage[bucket] is None:
            return
        idx=self.find(self.storage[bucket],key)
        if idx.next==None:
            return
        else:
            idx.next=idx.next.next
        


# Your MyHashMap object will be instantiated and called as such:
# obj = MyHashMap()
# obj.put(key,value)
# param_2 = obj.get(key)
# obj.remove(key)