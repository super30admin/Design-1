class hashMap:
    def __init__(self):
        self.size = 10000
        self.map = [None] * self.size

    def _hash(self,key):
        hash = 0

        for char in str(key):
            hash += ord(char)

        return hash % self.size
    
    def get(self, key):
        hash_index = self._hash(key)
        if self.map[hash_index]:
            print(self.map[hash_index])
            for lists in self.map[hash_index]:
                print(lists)
                if lists[0] == int(key):
                    return lists[1]
        return -1

    def put(self,key,value):
        hash_index = self._hash(key)
        if self.map[hash_index] is None:
            self.map[hash_index] = [[key,value]]
        else:
            for pair in self.map[hash_index]:
                if pair[0] == key:
                    pair[1] = value
                    return True
                else:
                    self.map[hash_index].append(list([hash_index]))
                    return True   

    def remove(self,key):
        key_hash = self._hash(key)

        if self.map[key_hash] is None:
            return False
        for i in range(0, len(self.map[key_hash])):
            if self.map[key_hash][i][0] == key:
                self.map[key_hash].pop(i)
                return True


if __name__ == "__main__":
    hashMap = hashMap()
    hashMap.put(1, 2)          
    hashMap.put(2, 3)      
    print(hashMap.get(1))         
    print(hashMap.get(3))           
    hashMap.put(2, 4)          
    print(hashMap.get(2))       
    hashMap.remove(2)         
    print(hashMap.get(2))           