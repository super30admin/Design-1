class MyHashMap:

    def __init__(self):
        self.new = [-1]*1000 
        

    def put(self, key: int, value: int) -> None:
        if self.new[int(key/1000)] == -1:
            self.new[int(key/1000)] = [-1]*1000
        if self.new[-1] != -1:
            self.new[int(key/1000)].append(-1)
        
        self.new[int(key/1000)][key%1000] = value
        

    def get(self, key: int) -> int:
        if self.new[int(key/1000)] == -1:
            return -1
        
        return self.new[int(key/1000)][key%1000]
        

    def remove(self, key: int) -> None:
        if self.new[int(key/1000)] != -1:
            self.new[int(key/1000)][key%1000] = -1
        self.new = [-1]*1000