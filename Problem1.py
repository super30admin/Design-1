class MyHashSet(object):
    

    def __init__(self):
        self.bucket = [False] * 1000001

    def add(self, key):
        self.bucket[key] = True

    def remove(self, key):
        self.bucket[key] = False
        

    def contains(self, key):
        return self.bucket[key]
