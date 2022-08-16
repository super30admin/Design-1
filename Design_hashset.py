class ListNode():
    def __init__(self,data,flag):
        self.data = data
        self.next = None
        self.flag = flag
        
class MyHashSet(object):

    def __init__(self):
        self.size = 1000
        self.s = [None]*self.size

    def add(self, key):
        """
        :type key: int
        :rtype: None
        """
        index = key%self.size
        curr = ListNode(key,True)
        if(self.s[index]==None): 
            self.s[index]=curr
        else:
            head = self.s[index]
            self.s[index] = curr
            curr.next = head
        

    def remove(self, key):
        """
        :type key: int
        :rtype: None
        """
        index = key%self.size
        curr = self.s[index]
        while curr:
            if(curr.data==key and curr.flag==True):
                curr.flag = False
            curr = curr.next          
        
        
    def contains(self, key):
        """
        :type key: int
        :rtype: bool
        """
        index = key%self.size
        curr = self.s[index]
        
        while curr:
            if(curr.data==key and curr.flag==True):
                return True
            curr = curr.next
        return False


# Your MyHashSet object will be instantiated and called as such:
# obj = MyHashSet()
# obj.add(key)
# obj.remove(key)
# param_3 = obj.contains(key)