class MyHashMap:

    def __init__(self):
        """
        Initialize your data structure here.
        """
        self.arr=[]
        

    def put(self, key: int, value: int) -> None:
        """
        value will always be non-negative.
        """
        flag=0
        for i in self.arr:
            #update
            if i[0]==key:
                flag=1
                i[1]=value
        if flag==0:
            self.arr.append([key,value])
                
        
        

    def get(self, key: int) -> int:
        """
        Returns the value to which the specified key is mapped, or -1 if this map contains no mapping for the key
        """
        flag=0
        for i in self.arr:
            if i[0]==key:
                flag=1
                return i[1]
        if flag==0:
            return -1
        
        

    def remove(self, key: int) -> None:
        """
        Removes the mapping of the specified value key if this map contains a mapping for the key
        """
        indexkey=-1
        for i in range(len(self.arr)):
            if self.arr[i][0]==key:
                indexkey=i
        if indexkey!=-1:
            del self.arr[indexkey]

        
# Your MyHashMap object will be instantiated and called as such:
obj = MyHashMap()
obj.put(1,1)
obj.put(2,2)
print(obj.get(1))
print(obj.get(3))
obj.put(2,1)
obj.remove(2)
print(obj.arr)
