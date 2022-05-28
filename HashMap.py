#time complexity is O(100) which can be considered as constant
# space complexity is O(10000)+O(n) in worst case 
class MyHashMap(object):
    def __init__(self):
        self.arr=[None]*10000
    class MyNode(object):
        def __init__(self,key,val):
            self.key=key
            self.val=val
            self.next=None
    def find(self,head,key):
        prev=head
        curr=head.next
        while(curr!=None and curr.key!=key):
            prev=curr
            curr=curr.next
        return prev
    def put(self, key, value):
        n=self.MyNode(key,value)
        hash=key%10000
        if self.arr[hash]==None:
            self.arr[hash]=self.MyNode(-1,-1)
        prev=self.find(self.arr[hash],key)
        if prev.next==None:
            prev.next=n
        else:
            prev.next.val = value
    def get(self, key):
        hash=key%10000
        if self.arr[hash]==None:
            return -1
        prev=self.find(self.arr[hash],key)
        if prev.next==None:
            return -1
        else:
            return prev.next.val
    def remove(self, key):
        hash=key%10000
        if self.arr[hash]==None:
            return
        prev=self.find(self.arr[hash],key)
        if prev.next==None:
            return
        else:
            prev.next=prev.next.next