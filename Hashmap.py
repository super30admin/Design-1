class MyHashMap:
    def __init__(self):
        self.items = [-1]*1000001

    def put(self, key, value):
        key = key%1000000
        self.items[key] = value
        print("Adding key,value to hashmap")

    def get(self, key):
        key = key%1000000
        # Key not present
        if self.items[key]==-1:
            return -1
        else:
            # return value for corresponding key
            return self.items[key]

    def remove(self, key):
        key = key%1000000
        print('deleting')
        self.items[key] = -1

hash = MyHashMap()
hash.put(1,1)
hash.put(2,2)
hash.put(2,1)
hash.remove(1)
hash.get(1)
