class MyHashMap:

    def __init__(self):
        self.hashmap = []
        
    def put(self, key: int, value: int) -> None:
        key_value = []
        key_value.append(key)
        key_value.append(value)

        for element in self.hashmap:
            if element[0] == key:
                element[1] = value
                return self
        return self.hashmap.append(key_value)

    def get(self, key : int) -> int :
        for element in self.hashmap:
            if element[0] == key:
                value = element[1]
                return value
        return -1

    def remove(self, key : int)-> None:
        for i in range (len(self.hashmap)):
            if self.hashmap[i][0] == key:
                self.hashmap.pop(i)


obj = MyHashMap()
obj.put(0,10)
param_2 = obj.get(0)
obj.remove(0)