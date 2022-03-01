

class Bucket:
    def __init__(self):
        self.bucket = []
        
    def insert(self,key,value):
        flag = False
        for i, key_value in enumerate(self.bucket):
            if key == key_value[0]:
                self.bucket[i] = (key, value)
                flag = True
                break
        if flag == False:
            self.bucket.append((key,value))
        
    def get(self,key):
        for (k, v) in self.bucket:
            if k == key:
                return v
        return -1
            
    def remove(self,key):
        for i , k in enumerate(self.bucket):
            if k[0] == key:
                del self.bucket[i]
                
        
        
class MyHashMap:
    def __init__(self):
        self.hash = 3699
        self.hashMap = [Bucket() for i in range(self.hash)]
        
    def put(self, key, value):
        hash_key = key % self.hash
        self.hashMap[hash_key].insert(key,value)
        
    def get(self,key):
        hash_key = key % self.hash
        return self.hashMap[hash_key].get(key)
    
    def remove(self,key):
        
        hash_key = key % self.hash
        self.hashMap[hash_key].remove(key)
