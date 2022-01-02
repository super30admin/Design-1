# // Time Complexity :O(1)
# // Space Complexity :O(n)
class LList:
    def __init__(self,val):
        self.val=val
        self.next=None
class MyHashSet:

    def __init__(self):
        self.hset=[None for i in range(1000)]#initially size is 1000
    def find(self,val,head):
        prev=head
        curr=head.next
        while curr:
            if curr.val==val:
                return prev
            prev=curr
            curr=curr.next
        return prev
                
        
        

    def add(self, key: int) -> None:
        hash1=key%1000
        if self.hset[hash1]==None:
            self.hset[hash1]=LList(-1)
        prev=self.find(key,self.hset[hash1])
        if not prev.next:
            prev.next=LList(key)
            
            
            
            
            
        
        

    def remove(self, key: int) -> None:
        print(key,"y")
        hash1=key%1000
        if self.hset[hash1]==None:
            return
        prev=self.find(key,self.hset[hash1])
        print(prev.val)
        if not prev.next:
            return
        else:
            prev.next=prev.next.next
            
        
        
        
        

    def contains(self, key: int) -> bool:
        print(key,"z")
        hash1=key%1000
        if self.hset[hash1]==None:
            return False
        prev=self.find(key,self.hset[hash1])
        if not prev.next:
            print("a")
            return False
        else:
            return True
        
        
        


# Your MyHashSet object will be instantiated and called as such:
# obj = MyHashSet()
# obj.add(key)
# obj.remove(key)
# param_3 = obj.contains(key)