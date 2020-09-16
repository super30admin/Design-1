class ListNode:
    def __init__(self,key,value):
        self.pair=(key,value)
        self.next=None




class MyHashMap(object):

    def __init__(self):
        """
        Initialize your data structure here.
        """
        self.m = 91
        self.hash = [None]*self.m
        

    def put(self, key, value):
        """
        value will always be non-negative.
        :type key: int
        :type value: int
        :rtype: None
        """
        hash_index = key%self.m
        if self.hash[hash_index]==None:
            self.hash[hash_index] = ListNode(key,value)
        else:
            cur = self.hash[hash_index]
            while cur!=None:
                if cur.pair[0]==key:
                    cur.pair=(key,value)
                    return
                if cur.next==None:
                    break
                cur=cur.next
            cur.next = ListNode(key,value)
        

    def get(self, key):
        """
        Returns the value to which the specified key is mapped, or -1 if this map contains no mapping for the key
        :type key: int
        :rtype: int
        """
        hash_index = key%self.m
        if self.hash[hash_index]==None:
            return -1
        else:
            cur = self.hash[hash_index]
            while(cur!=None):
                if cur.pair[0]==key:
                    return cur.pair[1]
                cur=cur.next
            return -1
            
    
        

    def remove(self, key):
        """
        Removes the mapping of the specified value key if this map contains a mapping for the key
        :type key: int
        :rtype: None
        """
        hash_index = key%self.m
        if self.hash[hash_index]==None:
            return None
        else:
            prev = self.hash[hash_index] 
            cur = self.hash[hash_index]
            if cur.pair[0]==key:
                self.hash[hash_index] = cur.next
            else:
                cur=cur.next
                while(cur!=None):
                    if cur.pair[0]==key:
                        prev.next= cur.next
                        break
                    else:
                        cur=cur.next
                        prev=prev.next
                
