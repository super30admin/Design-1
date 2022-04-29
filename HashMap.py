class MyHashMap:

    def __init__(self):
        self.data=[None]*1000
    #Time Complexity: O(1)
    #Space complexity:O(1)
    def put(self, key: int, value: int) -> None:
        firstHash=key%1000
        secondHash=key//1000
        if self.data[firstHash]==None:
            if firstHash==0:
                self.data[firstHash]=[-1]*1001
            else:
                self.data[firstHash]=[-1]*1000
        self.data[firstHash][secondHash]=value
    #Time Complexity: O(1)
    #Space complexity:O(1)
    def get(self, key: int) -> int:
        firstHash=key%1000
        secondHash=key//1000
        if self.data[firstHash]==None or self.data[firstHash][secondHash]==-1:
            return -1
        return self.data[firstHash][secondHash]
     #Time Complexity: O(1)
    #Space complexity:O(1)       

    def remove(self, key: int) -> None:
        firstHash=key%1000
        secondHash=key//1000
        if self.data[firstHash]==None or self.data[firstHash][secondHash]==-1:
            return
        self.data[firstHash][secondHash]=-1
        
        


# Your MyHashMap object will be instantiated and called as such:
# obj = MyHashMap()
# obj.put(key,value)
# param_2 = obj.get(key)
# obj.remove(key)