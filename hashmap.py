class MyHashMap(object):

    def __init__(self):
        self.map = {}

    def put(self, key, value):
        if self.get(key):
            self.map[key] = value
        else:
            self.map[key] = value

    def get(self, key):
        if key in self.map:
            return self.map[key]
        else:
            return -1

    def remove(self, key):
        if key in self.map:
            self.map.pop(key)
        return
