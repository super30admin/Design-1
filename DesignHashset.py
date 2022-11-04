class MyHashSet:

    def __init__(self):
        self.bucket_len=1000
        self.bucket=[None]*self.bucket_len
    def get_Hash(self,key):
        return key%self.bucket_len

    def get_double_Hash(self,key):
        return key//self.bucket_len

    def add(self, key: int) -> None:
        pri_index=self.get_Hash(key)
        sec_index=self.get_double_Hash(key)
        if self.bucket[pri_index]==None and pri_index==0:
            self.bucket[pri_index]=[False]*(self.bucket_len+1)
        elif self.bucket[pri_index]==None:
            self.bucket[pri_index]=[False]*(self.bucket_len)
        self.bucket[pri_index][sec_index]=True
        

    def remove(self, key: int) -> None:
        pri_index=self.get_Hash(key)
        sec_index=self.get_double_Hash(key)
        if self.bucket[pri_index]==None:
            return 
        self.bucket[pri_index][sec_index]=False

    def contains(self, key: int) -> bool:
        pri_index=self.get_Hash(key)
        sec_index=self.get_double_Hash(key)
        if self.bucket[pri_index]==None:
            return 
        return self.bucket[pri_index][sec_index]
        


# Your MyHashSet object will be instantiated and called as such:
# obj = MyHashSet()
# obj.add(key)
# obj.remove(key)
# param_3 = obj.contains(key)