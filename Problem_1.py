class MyHashMap(object):

    def __init__(self):
        self.hashmap = [-1] * 1000001
        

    def put(self, key, value):
        self.hashmap[key] = value
        

    def get(self, key):
        return self.hashmap[key]
        

    def remove(self, key):
        self.hashmap[key] = -1


# Your MyHashMap object will be instantiated and called as such:
obj = MyHashMap()
obj.put(1,1)  
obj.put(2,2)
print(obj.get(1))
print(obj.get(3))
obj.put(2,1)
print(obj.get(2))
obj.remove(2)
print(obj.get(2))