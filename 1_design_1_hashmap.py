#Time Complexity : O(N/K) where N is the number of all possible leys and K is the number of all buckets
#Space Complexity : O(N+K) where N is the number of all possible keys and K is the number of bucets
#Did this code successfully run on Leetcode : Yes
#Any problem you faced while coding this : I faced problem to understand how the pair could be stored in a bucket. Is pair a different data structure? 


#Your code here along with comments explaining your approach




class Bucket:    #Predefined structure which could be there alogside with each haskey and could store key,value pair 
    def __init__(self):
        self.bucket=[]     #
        
    def get(self,key):
        for(k,v) in self.bucket: #getiing a value if we give the key 
            if k==key:
                return v
        return -1 
    
    def update(self,key,value):   
        found=False
        for i,kv in enumerate(self.bucket): #just iterate from first to last in a bucket, stop iterating immediately if found
            if key==kv[0]:       #kv[0] means the key, not the value 
                self.bucket[i]=(key,value)
                found=True
                break
        if not found: 
            self.bucket.append((key,value))
    
    def remove(self,key):
        for i, kv in enumerate(self.bucket):  #iterate throgh a bucket, if found delete
            if key==kv[0]:
                del self.bucket[i]
                


class MyHashMap(object):

    def __init__(self):
        """
        Initialize your data structure here.
        """
        
        self.key_space=2069
        self.hash_table=[Bucket() for i in range(self.key_space)]

    def put(self, key, value):
        """
        value will always be non-negative.
        :type key: int
        :type value: int
        :rtype: None
        """
        hash_key=key%self.key_space
        self.hash_table[hash_key].update(key,value)

    def get(self, key):
        """
        Returns the value to which the specified key is mapped, or -1 if this map contains no mapping for the key
        :type key: int
        :rtype: int
        """
        hash_key=key%self.key_space
        return self.hash_table[hash_key].get(key)

    def remove(self, key):
        """
        Removes the mapping of the specified value key if this map contains a mapping for the key
        :type key: int
        :rtype: None
        """
        hash_key=key%self.key_space
        self.hash_table[hash_key].remove(key)


# Your MyHashMap object will be instantiated and called as such:
# obj = MyHashMap()
# obj.put(key,value)
# param_2 = obj.get(key)
# obj.remove(key)
