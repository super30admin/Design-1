#// Did this code successfully run on Leetcode :Yes
#// Any problem you faced while coding this :None


#// Your code here along with comments explaining your approach
#we have implemented hash map using chaining mechanism.
#In the below getIndex() method implements hashing function,getElement method gives the index of the previous node of the key,put method #if the element is not present,we add it to the end of linked list and if present we update the value of the given index,get method gets #the value of the key if present ,if not present it returns -1.remove() method is implemented to remove a particular key,value pair if #present else return -1.


class Node:
    def __init__(self,key,value):
        self.key=key
        self.value=value
        self.next=None

class MyHashMap(object):

    def __init__(self):
        """
        Initialize your data structure here.
        """
        self.list1=[None]*10000
        
    #O(1) complexity
    def getIndex(self,key):
        return key%10000
    
    #O(1) best case and O(n) worst case
    def getElement(self,key):
        index=self.getIndex(key)
        if self.list1[index]==None:
            dummy=Node(-1,-1)
            self.list1[index]=dummy
            return dummy
        curr=self.list1[index]
        while curr.next!=None and curr.next.key!=key:
            curr=curr.next
        return curr

    #O(1) best case and O(n) worst case
    def put(self, key, value):
        """
        value will always be non-negative.
        :type key: int
        :type value: int
        :rtype: None
        """
        curr3=self.getElement(key)
        if curr3.next==None:
            curr3.next=Node(key,value)
        else:
            curr3.next.value=value
        
    #O(1) best case and O(n) worst case    
    def get(self, key):
        """
        Returns the value to which the specified key is mapped, or -1 if this map contains no mapping for the key
        :type key: int
        :rtype: int
        """
        curr1=self.getElement(key)
        if curr1.next==None:
            return -1
        return curr1.next.value
        
    #O(1) best case and O(n) worst case
    def remove(self, key):
        """
        Removes the mapping of the specified value key if this map contains a mapping for the key
        :type key: int
        :rtype: None
        """
        curr2=self.getElement(key)
        if curr2.next==None:
            return -1
        curr2.next=curr2.next.next
        


# Your MyHashMap object will be instantiated and called as such:
# obj = MyHashMap()
# obj.put(key,value)
# param_2 = obj.get(key)
# obj.remove(key)
