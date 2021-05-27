class bucket:
    def __init__(self,key):
        self.pairs=[]
        self.hash=key
        self.size=1
    
class MyHashMap:

    def __init__(self):
        """
        Initialize your data structure here.
        
        """
       
        self.li=[]
        
    
        
    def put(self, key: int, value: int) -> None:
        """
        value will always be non-negative.
        """
        
        k=key%1000
        for i in self.li:
            if i.hash==k:
                i.pairs.append((key,value))
                i.size+=1
                print(i.size)
                return
            
        temp=bucket(k)
        temp.pairs.append((key,value))
        self.li.append(temp)

            

    def get(self, key: int) -> int:
        """
        Returns the value to which the specified key is mapped, or -1 if this map contains no mapping for the key
        """
        k=key%1000
        
        for i in self.li:
            
            if i.hash==k and i.size>0:
                
                
                return i.pairs[i.size-1][1]
        return -1
                
                
    
            
        

    def remove(self, key: int) -> None:
        """
        Removes the mapping of the specified value key if this map contains a mapping for the key
        """
        k=key%1000
        
         
        
        for i in self.li:
            if i.hash==k and i.size>0:
                i.pairs.pop(i.size-1)
                i.size-=1
                
        


# Your MyHashMap object will be instantiated and called as such:
# obj = MyHashMap()
# obj.put(key,value)
# param_2 = obj.get(key)
# obj.remove(key)