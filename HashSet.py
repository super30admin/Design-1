class Bucket:
    def __init__(self):
        self.bucket=[]
    def update(self, key):
        found=False
        for i, k in enumerate(self.bucket):
            if key==k:
                self.bucket[i]=key
                found=True
                break
        if not found:
            self.bucket.append(key)

    def get(self, key):
        for k in self.bucket:
            if k==key:
                return True
        return False
    
    def remove(self, key):
        for i, k in enumerate(self.bucket):
            if k==key:
                del self.bucket[i]
                
    
class MyHashSet:

    def __init__(self):
        self.size=2096
        self.hash_table=[Bucket() for i in range(self.size)]
        
    def add(self, key: int) -> None:
        hash_key= key% self.size
        return self.hash_table[hash_key].update(key)

    def remove(self, key: int) -> None:
        hash_key=key%self.size
        return self.hash_table[hash_key].remove(key)

    def contains(self, key: int) -> bool:
        hash_key=key%self.size
        return self.hash_table[hash_key].get(key)
        
# Your MyHashSet object will be instantiated and called as such:
# obj = MyHashSet()
# obj.add(key)
# obj.remove(key)
# param_3 = obj.contains(key)