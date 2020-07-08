class MyHashMap:
    def __init__(self):
        self.hashmap = []
    def put(self, key, value):
        found=False
        for i,kv in enumerate(self.hashmap):
            if key==kv[0]:
                self.hashmap[i]=(key,value)
                found=True
                break
        if not found:
            self.hashmap.append((key,value))
    def get(self, key):
        
        for (k,v) in self.hashmap:
            if k==key:
                return v
        return -1
    def remove(self, key):
        for i,kv in enumerate(self.hashmap):
            if key==kv[0]:
                del self.hashmap[i]
