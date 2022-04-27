'''
Leet Code Link: https://leetcode.com/problems/design-hashmap/submissions/
'''
class MyHashMap:

    def __init__(self):
        
        # 0 <= key, value <= 106
        self.list = [None]*1000
        self.innerList = None
    
    def hashList(self,key):
        return key%1000
    
    def hashInnerList(self,key):
        return key//1000
    
    def put(self, key: int, value: int) -> None:
        
        # 1. Coumpute hashList
        indexList = self.hashList(key)
        
        # 2. Perform check if list[indexList] == None
        if self.list[indexList]== None:
            
            # Boundary case, insert 1,000,000 i.e. 10^6            
            if indexList == 0:
                self.innerList = [None] * (1000+1)
            else:    
                # 2.1 Allocate innerList inside the list[index]
                self.innerList = [None] * 1000
            
            self.list[indexList] =  self.innerList
            
        # 3 Compute the hashInnerList for the key
        indexInnerList = self.hashInnerList(key)
            
        # 2.3 Set list[indexList][indexInnerList] == value if it's None
        if self.list[indexList][indexInnerList] == None:
            self.list[indexList][indexInnerList] = [key,value]
        
        elif self.list[indexList][indexInnerList][0] == key:
            # If we have 'key'; we need to update the 'value' only
            self.list[indexList][indexInnerList][1] = value
        
        return self.list[indexList][indexInnerList]

    def get(self, key: int) -> int:
        # 1. Coumpute hashList
        indexList = self.hashList(key)
        
        if self.list[indexList] == None:
            return -1
        
        # 2. Compute the hashInnerList for the key
        indexInnerList = self.hashInnerList(key)
        
        if self.list[indexList][indexInnerList] != None:
            # Return the value
            return self.list[indexList][indexInnerList][1]
        
        else:
            return -1

    def remove(self, key: int) -> None:
        
        # 1. Coumpute hashList
        indexList = self.hashList(key)
        
        if self.list[indexList] != None:
            # 2. Compute the hashInnerList for the key
            indexInnerList = self.hashInnerList(key)
            
            if self.list[indexList][indexInnerList] != None:
                self.list[indexList][indexInnerList] = None


# Your MyHashMap object will be instantiated and called as such:
# obj = MyHashMap()
# obj.put(key,value)
# param_2 = obj.get(key)
# obj.remove(key)

myHashMap = MyHashMap();
myHashMap.put(1, 1); # The map is now [[1,1]]
print(myHashMap.list)