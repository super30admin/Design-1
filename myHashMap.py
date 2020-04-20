#Time Complexity : O(n)- Here n is 1000, as I have defined size as 1000
# Space Complexity :O(n)-size of the list defined
# Did this code successfully run on Leetcode :Yes
# Any problem you faced while coding this :In calculating space and time complexity


# Your code here along with comments explaining your approach 

class MyHashMap:

    def __init__(self):
        """
        Initialize your data structure here.
        """
        self.size=1000 #setting size of the array
        self.map=[-1]*self.size # construct a list of defined size 
        

    def put(self, key: int, value: int) -> None:
        """
        value will always be non-negative.
        """
        idx=key% self.size #calculate the index for the key
        # kv_pair=(key,value)
        
        if self.map[idx] ==-1:#check if the cell is empty
            self.map[idx]=[]#create new list
        #iterate through each pair in th emap and check if key is present
        for i, kv_pair in enumerate(self.map[idx]):
            #if the cell is non-empty we check if the key already exists or not
            if kv_pair[0]==key:
                #update the value for that particular location
                self.map[idx][i]=(key,value)
                return
        #if the key does not exist, we append the new  key value pair to taht index location  
        self.map[idx].append((key,value))
      

    def get(self, key: int) -> int:
        """
        Returns the value to which the specified key is mapped, or -1 if this map contains no mapping for the key
        """
        idx=key%self.size # get the index value 
        # kv_pair(key,value)
        
        if self.map[idx] ==-1:
            return -1u
        # if the cell is not None, we iterate through the list to find if key exists and if so we return its value.
        for kv_pair in self.map[idx]:
            if kv_pair[0]==key:
                return kv_pair[1]
        #if we do not find the key, we return None
        return -1

    def remove(self, key: int) -> None:
        """
        Removes the mapping of the specified value key if this map contains a mapping for the key
        """
        idx=key%self.size#locate the key
        # kv_pair(key,value) 
        idx_return=-1 # initiate the index of the key to be removed as -1
        #check if the cell is None, if so return -1
        if self.map[idx] ==-1:
            return
        #if the cell is non-empty, iteratethrough the list to find the key , set the index to be returned as the index of the key found
        else:
            for i, kv_pair in enumerate(self.map[idx]):
                if kv_pair[0]==key:
                    idx_return=i
                    break 
        #check if the index to be return is not -1, and delete the elemnet form that particular index.            
        if idx_return==-1:
            return 
        else:
            del self.map[idx][idx_return]
                    
        


# Your MyHashMap object will be instantiated and called as such:
# obj = MyHashMap()
# obj.put(key,value)
# param_2 = obj.get(key)
# obj.remove(key)
