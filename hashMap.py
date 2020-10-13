#Chain is the chained list to each hask key
class Chain:
    def __init__(self):
        self.chain=[]

    def update(self,key,value):
        found=False
        for k,v in enumerate(self.chain):
            if key == v[0]:
                found = True
                self.chain[k] = (key,value) #update key value tuple
                break

        if not found:
            self.chain.append((key,value))

    def get(self,key):
        for (k, v) in self.chain:
            if key ==k:
                return v
        return -1

    def remove(self,key):
        for k, v in enumerate(self.chain):
            if key==v[0]:
                del self.chain[k]


class MyHashMap:

    def __init__(self):
        """
        Initialize your data structure here.
        """
        self.hashSize = 1033
        self.hashMap = [Chain() for i in range(self.hashSize)]

    def put(self, key: int, value: int) -> None:
        #use modulo toget hashkey
        hashKey = key%self.hashSize
        self.hashMap[hashKey].update(key,value)


    def get(self, key: int) -> int:
        """
        Returns the value to which the specified key is mapped, or -1 if this map contains no mapping for the key
        """
        hashKey = key%self.hashSize #find the hashkey to index hashmap
        return self.hashMap[hashKey].get(key)

    def remove(self, key: int) -> None:
        """
        Removes the mapping of the specified value key if this map contains a mapping for the key
        """
        hashKey = key%self.hashSize
        self.hashMap[hashKey].remove(key)




obj = MyHashMap()
obj.put(1,2)
obj.put(2,4)
param_2 = obj.get(2)
print(param_2)
obj.remove(1)
