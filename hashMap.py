# Crude implementation of (int, int) hashMap

class hashMap:
    def __init__(self):
        self.size = 6
        self.map = [None] * self.size
    
    def hashF(self, key):
        return (key%self.size)
    
    def insert(self, key, value):
        hash_key = self.hashF(key)
        paired_data = [key, [value]]
        
        if self.map[hash_key] is None:
            self.map[hash_key] = paired_data
            print(self.map)
        else:
            if self.map[hash_key][0] == key and value in self.map[hash_key][1]:
                print(self.map)
            elif self.map[hash_key][0] == key and value not in self.map[hash_key][1]:
                self.map[hash_key][1].append(value)
                print(self.map)
    
    def getMap(self):
        print(self.map)
    
    def getValues(self, key):
        hash_key = self.hashF(key)
        
        if self.map[hash_key] is not None:
            print("Values at key " + str(key) + " are: ")
            for i in self.map[hash_key][1]:
                print("(" + str(key) + ", " + str(i) + ")")
        else:
            print("No values available for key number " + str(key))
    
    def delete(self, key):
        hash_key = self.hashF(key)
        
        if self.map[hash_key] is None:
            print("Index " + str(key) + " is empty.")
        
        self.map[hash_key][1].pop()
        
        if len(self.map[hash_key][1])==0:
            self.map[hash_key] = None
        
            
a = hashMap()
a.insert(1,3)
a.insert(1, 5)
a.getValues(1)
a.delete(1)
a.getMap()
a.delete(1)
a.getMap()