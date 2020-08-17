# Time Complexity : O(N/k) k=fixed size of hashmap. N=no. of unique keys stored in hashmap
# Space Complexity : O(k+2N) k=fixed size of hashmap. N=no. of unique keys stored in hashmap 
#                             2N to store key value pair
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : Nothing specific


# Your code here along with comments explaining your approach


class MyHashMap:

    def __init__(self):
        """
        Initialize your data structure here.
        """
        
        self.k=101      #array size
        #Initialise array of size k. Storing the hask key, value pairs in array. 
        self.arr=[[]for _ in range(self.k)]     
        
    def getHashValue(self,key):
        '''
        Returns the hash value of the key
        '''
        
        return key%self.k

    def put(self, key: int, value: int) -> None:
        """
        value will always be non-negative.
        """
        
        hashValue=self.getHashValue(key)
        isPresent=False
        
        for index,element in enumerate(self.arr[hashValue]):
            
            if element[0]==key:   #check key already present
                #update the new value 
                self.arr[hashValue][index][1]=value  
                isPresent=True
                break
                
        if isPresent is False:
            self.arr[hashValue].append([key,value])
                

    def get(self, key: int) -> int:
        """
        Returns the value to which the specified key is mapped, or -1 if this map contains no mapping for the key
        """
        
        hashValue=self.getHashValue(key)
        
        for hkey,hvalue in self.arr[hashValue]:
            if hkey==key:
                return hvalue
        
        return -1

    def remove(self, key: int) -> None:
        """
        Removes the mapping of the specified value key if this map contains a mapping for the key
        """
        
        hashValue=self.getHashValue(key)
        
        for index,element in enumerate(self.arr[hashValue]):
            if element[0]==key:  #check key
                self.arr[hashValue].pop(index)
                break
        
        


# Your MyHashMap object will be instantiated and called as such:
# obj = MyHashMap()
# obj.put(key,value)
# param_2 = obj.get(key)
# obj.remove(key)