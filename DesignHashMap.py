class MyHashMap:
    def __init__(self):
        self.keys = []
        self.values = []
        #self.cur_idx = 0

    def put(self, key: int, value: int) -> None:
        for i in range(len(self.keys)):
            if self.keys[i] == key:
                self.values[i] = value
                return    
        self.keys.append(key)
        self.values.append(value)

    def get(self, key: int) -> int:
        for i in range(len(self.keys)):
            if self.keys[i] == key:
                return self.values[i]
        return -1

    def remove(self, key: int) -> None:
        for i in range(len(self.keys)):
            if self.keys[i] == key:
                self.keys[i] = None
                self.values[i] = None


# Your MyHashMap object will be instantiated and called as such:
# obj = MyHashMap()
# obj.put(key,value)
# param_2 = obj.get(key)
# obj.remove(key)