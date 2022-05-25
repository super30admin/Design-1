class MyHashSet(object):

    def __init__(self):
        self.buckets=1000
        self.bucketItems=1000
        self.table=[None]*self.buckets
        
    def hash_function1(self,key):
        return key % self.buckets
    
    def hash_fucntion2(self,key):
        return key/self.bucketItems

    def add(self, key):
        """
        :type key: int
        :rtype: None
        """
        bucket_val=self.hash_function1(key)
        buckectItems_val=self.hash_fucntion2(key)
        if self.table[bucket_val] is not None:
            if self.contains(key)==False:
                self.table[bucket_val][buckectItems_val]=True
        else:
            if(bucket_val==0):
                self.table[bucket_val]=[False]*(self.bucketItems+1)
                self.table[bucket_val][buckectItems_val]=True
            else:
                self.table[bucket_val]=[False]*self.bucketItems
                self.table[bucket_val][buckectItems_val]=True
            
        

    def remove(self, key):
        """
        :type key: int
        :rtype: None
        """
        bucket_val=self.hash_function1(key)
        buckectItems_val=self.hash_fucntion2(key)
        if self.table[bucket_val] is not None:
            if self.table[bucket_val][buckectItems_val]==True:
                self.table[bucket_val][buckectItems_val]=False
        

    def contains(self, key):
        """
        :type key: int
        :rtype: bool
        """
        bucket_val=self.hash_function1(key)
        buckectItems_val=self.hash_fucntion2(key)
        if self.table[bucket_val] is None:
            return False
        else:
            return self.table[bucket_val][buckectItems_val]
        
        


# Your MyHashSet object will be instantiated and called as such:
# obj = MyHashSet()
# obj.add(key)
# obj.remove(key)
# param_3 = obj.contains(key)
