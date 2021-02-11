#Time Complexity :O(1)
#Space Complexity :O(1)
#Did this code successfully run on Leetcode :yes
#Any problem you faced while coding this :no
class MyHashMap(object):
    def insertArray(self):
        return [None]*5000

    def __init__(self):
        """
        Initialize your data structure here.
        """
        self.hmap=[None]*5000
        

    def put(self, key, value):
        """
        value will always be non-negative.
        :type key: int
        :type value: int
        :rtype: None
        """
        outindex=key%5000
        inindex=key/5000
        if(self.hmap[outindex]!=None):
            self.hmap[outindex][inindex]=value
        else:
            self.hmap[outindex]=self.insertArray()
            self.hmap[outindex][inindex]=value
        

    def get(self, key):
        """
        Returns the value to which the specified key is mapped, or -1 if this map contains no mapping for the key
        :type key: int
        :rtype: int
        """
        outindex=key%5000
        inindex=key/5000
        if(self.hmap[outindex]!=None):
            if(self.hmap[outindex][inindex]==None):
                return -1
            else:
                return self.hmap[outindex][inindex]
            
        return -1
    def remove(self, key):
        """
        Removes the mapping of the specified value key if this map contains a mapping for the key
        :type key: int
        :rtype: None
        """
        outindex=key%5000
        inindex=key/5000
        if(self.hmap[outindex]!=None):
            if(self.hmap[outindex][inindex]!=None):
                self.hmap[outindex][inindex]=None
                
          
            
# Your MyHashMap object will be instantiated and called as such:
# obj = MyHashMap()
# obj.put(key,value)
# param_2 = obj.get(key)
# obj.remove(key)