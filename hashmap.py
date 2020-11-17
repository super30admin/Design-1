# Time Complexity :  O(N/K) for all N= number of keys k= number of predefined buckets
# Space Complexity : O(K + M) 
# Did this code successfully run on Leetcode : yes
# Any problem you faced while coding this : No



class MyHashMap(object):

    def __init__(self):
        """
        Initialize your data structure here.
        """
        self.list = []
        

    def put(self, key, value):
        """
        value will always be non-negative.
        :type key: int
        :type value: int
        :rtype: None
        """
        for i in range(len(self.list)):
            if self.list[i][0] == key:
                self.list[i] = (key,value)
                return 
        self.list.append((key,value))
        
        

    def get(self, key):
        """
        Returns the value to which the specified key is mapped, or -1 if this map contains no mapping for the key
        :type key: int
        :rtype: int
        """
        for l in self.list:
            if l[0] == key:
                return l[1]
        return -1
    
    
    def remove(self, key):
        """
        Removes the mapping of the specified value key if this map contains a mapping for the key
        :type key: int
        :rtype: None
        """
        for i in range(len(self.list)):
            if key == self.list[i][0]:
                del self.list[i]
                return 


"""
Approch : 

list with predefined number of bucket for fast accessing //as there is more number of keys it will stored in the list according to their hash value
get: will iterate through hashmap
remove: will iterate through hashmap
put: will first check if that key exist or not and if key exists it will change the value otherwise it will add the key-value pair in hashmap

"""
