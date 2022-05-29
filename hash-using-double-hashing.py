class MyHashMap:
    def __init__(self):
        self.arr_size=int(math.sqrt(1000000))+1
        self.arr=[None]*self.arr_size
        
    def hashfunction1(self,key:int)->int:
        ans=key%1000
        return ans
    
    def hashfucntion2(self,key:int)->int:
        ans1=key//1000
        return ans1
    
    def put(self, key: int, value: int) -> None: 
        hashkey=self.hashfunction1(key)
        hashkey2=self.hashfucntion2(key)
        if self.arr[hashkey]==None:
            # not ([[] for i in range(self.arr_size)]) beasuse it create a list of lists further at nested index.
            self.arr[hashkey]= [None for i in range(self.arr_size)] 
            self.arr[hashkey][hashkey2]=value
        else:
             self.arr[hashkey][hashkey2]=value
        
    def get(self, key: int) -> int:
        hashkey=self.hashfunction1(key)
        hashkey2=self.hashfucntion2(key)
        if self.arr[hashkey] !=None:
            if self.arr[hashkey][hashkey2] != None:
                return self.arr[hashkey][hashkey2]
        return -1
        
    def remove(self, key: int) -> None:
        hashkey=self.hashfunction1(key)
        hashkey2=self.hashfucntion2(key)
        if self.arr[hashkey]!=None:
            for i in range(len(self.arr[hashkey])):
                if self.arr[hashkey][hashkey2]:
                    self.arr[hashkey][hashkey2]=-1
        return


# Your MyHashMap object will be instantiated and called as such:
# obj = MyHashMap()
# obj.put(key,value)
# param_2 = obj.get(key)
# obj.remove(key)

# Your MyHashMap object will be instantiated and called as such:
# obj = MyHashMap()
# obj.put(key,value)
# param_2 = obj.get(key)
# obj.remove(key)