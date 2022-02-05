// Time Complexity : O(1) 
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Time limit exceeded
// Any problem you faced while coding this : No


class MyHashMap:

    def __init__(self):
        self.size=1000000
        self.keys =[None]*self.size
        self.values=[None]*self.size
        

    def hash_generator(self,newKey):
        return newKey%self.size
    
    
    def put(self,newKey,newValue):
        
        hash_value=self.hash_generator(newKey)
        if newKey in self.keys:
            self.values[hash_value]=newValue
        else:
            self.keys[hash_value]=newKey
            self.values[hash_value]=newValue
#         print(self.keys,self.values)
    
    
    def get(self,newKey):
        if newKey in self.keys:
            return self.values[self.hash_generator(newKey)]
        else:
            return -1
            
        
    def remove(self,newKey):
        if newKey in self.keys:
            hash_value=self.hash_generator(newKey)
            self.keys[hash_value]=None
            self.values[hash_value]=None
        
