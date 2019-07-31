class MyHashMap:
    # Initialize your data structure here
    def __init__(self):
        self.keys = []
        self.values = []

    # value will always be non-negative
    def put(self, key, value):
        if key in self.keys:
            self.values[self.keys.index(key)] = value
        else:
            self.keys.append(key)
            self.values.append(value)

    # Returns the value to which the specified key is mapped, or -1 if this map contains no mapping for the key
    def get(self, key):
        if key in self.keys:
            return self.values[self.keys.index(key)]
        else:
            return -1

    # Removes the mapping of the specified value key if this map contains a mapping for the key
    def remove(self, key):
        if key in self.keys:
            key_index = self.keys.index(key)
            del self.keys[key_index]
            del self.values[key_index]

if __name__ == "__main__":
    hashMap = MyHashMap()
    hashMap.put(1, 1)
    hashMap.put(2, 2)
    print(hashMap.get(1))
    print(hashMap.get(3))
    hashMap.put(2, 1)
    print(hashMap.get(2))
    hashMap.remove(2)
    print(hashMap.get(2))