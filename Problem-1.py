# Time Complexity : O(1) for all operations
# Space Complexity : O(1)
# Did this code successfully run on Leetcode : yes
# Any problem you faced while coding this : No


#Your code here along with comments explaining your approach



class MyHashMap:
    
    class Node:
        def __init__(self,key,val):
            self.key=key
            self.val=val
            self.next=None

    def __init__(self):
        self.hashlist=[None]*(10**4)
    
    def findNode(self,key):
        index=hash(key)%len(self.hashlist)
        if self.hashlist[index]==None:
            self.hashlist[index]=self.Node(-99,-99)
            return self.hashlist[index]
        else:
            prev=self.hashlist[index]
            while prev.next and prev.next.key!=key:
                prev=prev.next
            return prev

    def put(self, key: int, value: int) -> None:
        prev=self.findNode(key)
        if prev.next:
            prev.next.val=value
        else:
            new=self.Node(key,value)
            prev.next=new

    def get(self, key: int) -> int:
        prev=self.findNode(key)
        if prev.next:
            return prev.next.val
        else:
            return -1
            
    def remove(self, key: int) -> None:
        prev=self.findNode(key)
        if prev.next:
            prev.next=prev.next.next
        else:
            return


# Your MyHashMap object will be instantiated and called as such:
# obj = MyHashMap()
# obj.put(key,value)
# param_2 = obj.get(key)
# obj.remove(key)