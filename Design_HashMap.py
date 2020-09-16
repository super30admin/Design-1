# All the 3 methods take O(1) time and O(1) space
class MyHashMap:
    def __init__(self):
        self.hash_map = {}   

    def put(self, key , value):
        self.hash_map[key] = value
        
    def get(self, key):
        return self.hash_map[key] if key in self.hash_map else -1

    def remove(self, key):
        if key in self.hash_map:
            del self.hash_map[key]