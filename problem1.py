class Bucket:
    def __init__(self):
        self.map = list()
    def remove(self, key):
        for i, kv in enumerate(self.map):
            if key == kv[0]:
                del self.map[i]
    def get(self, key):
        for ky, val in self.map:
            if ky == key:
                return val
        return -1

    def update(self, key, value):
        found = False
        for i, kv in enumerate(self.map):
            if key == kv[0]:
                self.map[i] = (key, value)
                found = True
                break

        if not found:
            self.map.append((key, value))

class MyHashMap(object):

    def __init__(self):        
        self.b1 = 1000
        self.hash_table = [Bucket() for i in range(self.b1)]
    
    def getHashf1(self,key):
        return key % self.b1
        
    
    def getHashf2(self,key):
        return  key // self.b1
        

    def put(self, key, value):
        hash_key = self.getHashf1(key)
        self.hash_table[hash_key].update(key, value)


    def get(self, key):        
        hash_key = self.getHashf1(key)
        return self.hash_table[hash_key].get(key)


    def remove(self, key):
        hash_key = self.getHashf1(key)
        self.hash_table[hash_key].remove(key)

# Your MyHashMap object will be instantiated and called as such:
# obj = MyHashMap()
# obj.put(key,value)
# param_2 = obj.get(key)
# obj.remove(key)
