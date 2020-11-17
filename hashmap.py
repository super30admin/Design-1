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




# Time Complexity : 
#  possible N = 100000 // number of keys
#  Hashmap size = 100 // number of buckets
# average time complexity is 100000/100 = 100
# time complexity is O(N/K) for all N= number of keys k= number of predefined buckets
# Space Complexity : O(K + N) Number of Bucketss + number of keys
# Did this code successfully run on Leetcode : yes
# Any problem you faced while coding this : No

# approch 2 explained in class
class Node():
    def __init__(self,data):
        self.data =data
        self.next = None
        

class MyHashMap2(object):

    def __init__(self):
        """
        Initialize your data structure here.
        """
        self.list = []
        self.hashing_value = 10 #you can modify according to your data size
        for i in range(self.hashing_value):
            self.list.append(-1)

    def put(self, key, value):
        """
        value will always be non-negative.
        :type key: int
        :type value: int
        :rtype: None
        """
        h = key/self.hashing_value
        if self.list[h] == -1:
            self.list[h] = Node((key,value))
            return 

        ptr = self.list[h]
        while ptr.next:
            if ptr.data[0] == key:
                ptr.data[1] = value
                return 
        if ptr.data[0] == key:
            ptr.data[1] = value
            return 
        ptr.next = Node((key,value))
        
        

    def get(self, key):
        """
        Returns the value to which the specified key is mapped, or -1 if this map contains no mapping for the key
        :type key: int
        :rtype: int
        """
        h = key/self.hashing_value
        ptr = self.list[h]
        while ptr:
            if ptr.data[0] == key:
                return ptr.data[1]
        return -1

    
    def remove(self, key):
        """
        Removes the mapping of the specified value key if this map contains a mapping for the key
        :type key: int
        :rtype: None
        """
        h = key/self.hashing_value
        if self.list[h].data[0] == key:
            self.list[h] = self.list[h].next
            return 

        ptr1 = self.list[h].next
        ptr2 = self.list[h]
        while ptr1:
            if ptr1.data[0] == key: 
                ptr2.next = ptr1.next 
                return 


"""
Approch 1: 

list with predefined number of bucket for fast accessing //as there is more number of keys it will stored in the list according to their hash value
get: will iterate through hashmap
remove: will iterate through hashmap
put: will first check if that key exist or not and if key exists it will change the value otherwise it will add the key-value pair in hashmap


Approch 2:

Added hashing and seperate chaining to avoid linear search of whole are and avoid collision
hashing directly gives corresonding bucket in O(1) time
So time complexity only include iteration through the linked list for all operation 
"""
