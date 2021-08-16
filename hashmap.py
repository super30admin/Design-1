# // Time Complexity :O(1)
# // Space Complexity :O(1)
# // Did this code successfully run on Leetcode : Yes,the output got accepted but only 5 test cases passed
# // Any problem you faced while coding this : Not completely correct

class MyHashMap:

    def __init__(self):
        """
        Initialize your data structure here.
        
        """
        self.hasht=[]
        
        

    def put(self, key: int, value: int) -> None:
        """
        value will always be non-negative.
        """
        
        
        if len(self.hasht)==0:
            
            self.hasht.append([key,value])
            
        else:
            
            flag=False
            for i,x in enumerate(self.hasht):
                
                
                if x[0]==key:
                    
                    flag=True
            if flag==True:
                self.hasht[i]=[key,value]


            else:
                    
                self.hasht.append([key,value])
            print(self.hasht)

        

    def get(self, key: int) -> int:
        """
        Returns the value to which the specified key is mapped, or -1 if this map contains no mapping for the key
        """
        flag=True
        
        a=0
        for i,x in enumerate(self.hasht):
            val=x[1]
            if(x[0]==key):
                return x[1]
            
        
        return -1

    def remove(self, key: int) -> None:
        """
        Removes the mapping of the specified value key if this map contains a mapping for the key
        """
        for i,x in enumerate(self.hasht):
            if(x[0]==key):
                self.hasht.pop(i)
        


# Your MyHashMap object will be instantiated and called as such:
# obj = MyHashMap()
# obj.put(key,value)
# param_2 = obj.get(key)
# obj.remove(key)
