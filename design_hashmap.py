class Node1(object):
    #node object stores key and value both
    def __init__(self,key,val):
        #print("ssg")
		self.key = key
		self.val = val
		self.next=None         

class MyHashMap(object):
   
    def __init__(self):
        """
        Initialize your data structure here.
        """
        #define bucket of optimized size(trial) to store linklist
        self.bucket=[None]*10000

    def put(self, key, value):
        """
        value will always be non-negative.
        :type key: int
        :type value: int
        :rtype: None
        """
        #take modulo to get storage index of that node in bucket
        index=key%len(self.bucket)
        #if empty bucket, insert new key and return
        if self.bucket[index]==None:
            self.bucket[index]= Node1(key,value)
            return
        
        cur=self.bucket[index]
        prev=self.bucket[index]
        #update first key itself
        if cur.key==key:
            cur.val=value
            return
        #loop through and find key
        while cur.next!=None:
            #2nd key onwards, find and update
            if cur.next.key==key:
                cur.next.val=value
                return
            cur=cur.next
        #not found,add at last place
        cur.next=Node1(key,value)
        
        
    def get(self, key):
        """
        Returns the value to which the specified key is mapped, or -1 if this map contains no mapping for the key
        :type key: int
        :rtype: int
        """
        
        index=key%len(self.bucket)
        #empty bucket, return -1
        if self.bucket[index]==None:
            return -1
     
        cur=self.bucket[index]
        #loop through and find key
        while cur!=None:
            if cur.key==key:
                return cur.val
            cur=cur.next
        #not found return -1
        return -1
        

    def remove(self, key):
        """
        Removes the mapping of the specified value key if this map contains a mapping for the key
        :type key: int
        :rtype: None
        """
        index=key%len(self.bucket)
        prev=self.bucket[index]
        cur=self.bucket[index]
        #empty bucket, return nothing
        if self.bucket[index]==None:
            return
        #found key at first index, move your head pointer itself
        if cur.key==key:
            self.bucket[index]=self.bucket[index].next
            return
        #loop through  if found key then update the prev pointer to point to cur's next node (skipping cur node)
        while cur!=None:
            if cur.key==key:
                prev.next=cur.next
                return
            prev=cur
            cur=cur.next
        #not found key, just return nothing    
        return
            
        
obj = MyHashMap()
obj.put(12,13)
param_2 = obj.get(12)
print(param_2)
obj.remove(12)
print(obj.get(12))
#O(N)
#O(N)