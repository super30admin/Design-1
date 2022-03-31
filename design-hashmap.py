#-----------------------------------------------------
# Time Complexity : O(1)
# Space Complexity : O(N)  --- N is the number of elements
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this :No
#--------------------------------------------------------

class Node:
    def __init__(self,key=None,value=None,next=None):
        self.key=key
        self.val=value
        self.next=next

class MyHashMap:

    def __init__(self):
        self.bucketTimes=10000
        self.bucket=[None]*self.bucketTimes

    def find(self,head,key):
        prev=head
        curr=head.next

        while curr and curr.key!= key:
            prev=curr
            curr=curr.next

        return prev

    def getHash(self,key):
        return key % self.bucketTimes
    

    def put(self,key:int,value:int) ->None:
        index=self.getHash(key)
        if self.bucket[index] is None:
            self.bucket[index]=Node(-1,-1)
        
        prev=self.find(self.bucket[index],key)

        if prev.next is None:
            prev.next=Node(key,value)
        else:
            prev.next.val=value

           
    def get(self,key:int) ->None:
        index=self.getHash(key)
        if self.bucket[index] is None:
            return -1
        
        prev=self.find(self.bucket[index],key)

        if prev.next is None:
            return -1
        return prev.next.val

    def remove(self,key :int) -> None:
        index=self.getHash(key)
        if not self.bucket[index]:
            return
        
        prev=self.find(self.bucket[index],key)
        if not prev.next:
            return
        prev.next=prev.next.next


# Your MyHashSet object will be instantiated and called as such:
# obj = MyHashSet()
# obj.add(key)
# obj.remove(key)
# param_3 = obj.contains(key)