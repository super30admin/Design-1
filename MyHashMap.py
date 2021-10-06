class MyHashMap:

    def __init__(self):
        self.hashmap = {}
        

    def put(self, key: int, value: int) -> None:
        self.hashmap[key] = value
        
    def get(self, key: int) -> int:
        if key in self.hashmap:
            return self.hashmap[key]
        return

    def remove(self, key: int) -> None:
        if key in self.hashmap:
            del self.hashmap[key]


# Your MyHashMap object will be instantiated and called as such:
obj = MyHashMap()
obj.put(1,1)
print(obj.hashmap)
param_2 = obj.get(1)
if not param_2:
    print("Key doesnt exist")
else:
    print(param_2)
obj.remove(2)
print(obj.hashmap)