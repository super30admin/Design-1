class MyHashSet:
    buckets=1000
    bucket_items=1000
    def __init__(self):
        self.pri_hash=[None for i in range(self.buckets)]

        
    def hash_pri(self, key):
        return key%1000

    def hash_sec(self, key):
        return key//1000

    def add(self, key: int) -> None:
        which_bucket= self.hash_pri(key)
        where_in_bucket= self.hash_sec(key)
        if(self.pri_hash[which_bucket]==None):
            if(which_bucket==0):
                self.pri_hash[which_bucket]=[False for i in range(self.bucket_items+1)]
            else:
                self.pri_hash[which_bucket]=[False for i in range(self.bucket_items)]
            self.pri_hash[which_bucket][where_in_bucket]=True
        self.pri_hash[which_bucket][where_in_bucket]=True

    def remove(self, key: int) -> None:
        which_bucket=self.hash_pri(key)
        where_in_bucket=self.hash_sec(key)
        if(self.pri_hash[which_bucket]!=None):
            self.pri_hash[which_bucket][where_in_bucket]=False
            

    def contains(self, key: int) -> bool:
        which_bucket=self.hash_pri(key)
        where_in_bucket=self.hash_sec(key)
        if(self.pri_hash[which_bucket]!=None):
            return self.pri_hash[which_bucket][where_in_bucket]
        return False    


# Your MyHashSet object will be instantiated and called as such:
# obj = MyHashSet()
# obj.add(key)
# obj.remove(key)
# param_3 = obj.contains(key)