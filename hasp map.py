#I am finding it very difficult to calculate the time and space compexity for the problems. I need to work on it.
#yes my program ran on leetcode

# ListNode class using the linked list chaining method
class ListNode:
# initialising it using key,value
    def __init__(self,key,value):
        self.pair=(key,value)
        self.next=None

# creating Myhashmap class
class MyHashMap(object):

    def __init__(self):
        """
        Initialize your data structure here.
        """
        self.size=1000 #initalizing the size as 1000
        self.nodes=[None]*self.size 

    def put(self, key, value):
        """
        value will always be non-negative.
        :type key: int
        :type value: int
        :rtype: None
        """
        index= key%(self.size) # calculating the index
        if self.nodes[index]==None: #checking that particular index is present if not then inserting it
            self.nodes[index]=ListNode(key,value)
        else:
            cur=self.nodes[index] # if that index exists we are updating it
            while True:
                if cur.pair[0]==key:
                    cur.pair=(key,value) #updating
                    return
                if cur.next==None:break
                cur=cur.next           # if the next value is none then inserting it at that posistion
            cur.next=ListNode(key,value)

    def get(self, key):
        """
        Returns the value to which the specified key is mapped, or -1 if this map contains no mapping for the key
        :type key: int
        :rtype: int
        """
        index=key%(self.size)
        cur=self.nodes[index]
        while cur:
            if cur.pair[0]==key: # if that index is equal to the key then returning the value
                return cur.pair[1]
            else:
                cur=cur.next # else returning the next value
        return -1 # if that particular key didn't exist then returning -1

    def remove(self, key):
        """
        Removes the mapping of the specified value key if this map contains a mapping for the key
        :type key: int
        :rtype: None
        """
        index=key%(self.size)
        cur=prev=self.nodes[index] # using linkedlist methodology to remove the particular key's value
        if not cur: return
        if cur.pair[0]==key:
            self.nodes[index]=cur.next
        else:
            cur=cur.next
            while cur:
                if cur.pair[0]==key:
                    prev.next=cur.next
                    break
                else:
                    cur,prev=cur.next,prev.next
        
        