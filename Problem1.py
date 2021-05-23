'''
====== Submission Details =======
Student Name: Pavan Kumar K. N.
Email       : pavan1011@gmail.com
S30 SlackID : RN32MAY2021
=================================
'''

'''
706. Design HashMap

Design a HashMap without using any built-in hash table libraries.

Implement the MyHashMap class:

  -  MyHashMap() initializes the object with an empty map.
  
  -  void put(int key, int value) inserts a (key, value) pair into the HashMap. 
     If the key already exists in the map, update the corresponding value.

  -  int get(int key) returns the value to which the specified key is mapped, 
     or -1 if this map contains no mapping for the key.

  -  void remove(key) removes the key and its corresponding value if the map 
    contains the mapping for the key.
'''

'''
Example 1:

Input
["MyHashMap", "put", "put", "get", "get", "put", "get", "remove", "get"]
[[], [1, 1], [2, 2], [1], [3], [2, 1], [2], [2], [2]]

Output
[null, null, null, 1, -1, null, 1, null, -1]

Explanation
MyHashMap myHashMap = new MyHashMap();

myHashMap.put(1, 1); // The map is now [[1,1]]

myHashMap.put(2, 2); // The map is now [[1,1], [2,2]]

myHashMap.get(1);    // return 1, The map is now [[1,1], [2,2]]

myHashMap.get(3);    // return -1 (i.e., not found), The map is now 
                        [[1,1], [2,2]]

myHashMap.put(2, 1); // The map is now [[1,1], [2,1]] (i.e., update 
                        the existing value)

myHashMap.get(2);    // return 1, The map is now [[1,1], [2,1]]

myHashMap.remove(2); // remove the mapping for 2, The map is now [[1,1]]

myHashMap.get(2);    // return -1 (i.e., not found), The map is now [[1,1]]
 

Constraints:
0 <= key, value <= 10^6
At most 10^4 calls will be made to put, get, and remove.
'''



#-------------  
# Explanation:
#-------------
# Use array to implement hashtable
# Use bucketing to avoid using array of size[max_itemsize]
# Can't use too many buckets or else it will be the same as using an array
# Find a balance between max_keysize and max_itemsize

#-----------------
# Time Complexity: 
#-----------------
# put(), get(), and remove() all follow O(N/K)

# N: no. of input items, K: max_keysize
# N elements (max = 10^6) are divided into K arrays or "buckets"
# Every operation within that bucket takes linear time
# Every bucket has approx. N/K items

#------------------
# Space Complexity: 
#------------------
# O(K+M)

# Fixed cost of creating K buckets = K
# Variable cost of adding M unique keys = M
# Total = O(K + M)

#-----------------------
# Leet Code Performance: 
#-----------------------
# Ran Successfully?: Yes
# Time             : 252 ms  (65 %ile)
# Space            : 17.7 MB (39 %ile)

class MyHashMap(object):

    def __init__(self):
        """
        Initialize your data structure here.
        """

        # Prime is good to avoid collisions
        self.max_keysize = 4999
        
        # Create buckets to handle collisions
        self.hash_table = [[] for i in range(self.max_keysize)]

        
    # hashfunction is rudimentary. Can be more sophisticated in practice
    def hashFunction(self, hash_input):
        return hash_input % self.max_keysize

    def put(self, key, value):
        """
        value will always be non-negative.
        :type key: int
        :type value: int
        :rtype: None
        """
        hashed_key = self.hashFunction(key)

        # If we had no buckets and just an array of maxsize + 1, 
        # then arr[hashed_key] would hold the value. But now, 
        # one bucket can have multiple (key, value) pairs/tuple
        bucket = self.hash_table[hashed_key]

        for index, record in enumerate(bucket):
            #record is a (key, value) tuple. 
            record_key, record_value = record
            
            # Check if key already exists
            if record_key == key:
                bucket[index] = (key, value)
                return            
        
        # If code reaches here, key not found
        bucket.append((key, value))

        

    def get(self, key):
        """
        Returns the value to which the specified key is mapped, or -1 if this map contains no mapping for the key
        :type key: int
        :rtype: int
        """
        # First step is to find the hashed key and, 
        hashed_key = self.hashFunction(key)

        # to identify the bucket
        bucket = self.hash_table[hashed_key]

        # In this bucket, search for the particular key
        for index, record in enumerate(bucket):
            record_key, record_value = record
            # Key found, return value
            if record_key == key:
                return record_value

        # Key not found return -1
        return -1

    
    def remove(self, key):
        """
        Removes the mapping of the specified value key if this map contains a mapping for the key
        :type key: int
        :rtype: None
        """
        # First step is to find the hashed key and to identify the bucket
        hashed_key = self.hashFunction(key)

        
        for index, record in enumerate(self.hash_table[hashed_key]):
            record_key, record_value = record
            if record_key == key:
                # Using self.hash_table[hashed_key] to call del by reference
                # to correct object 
                del self.hash_table[hashed_key][index]
        


# Your MyHashMap object will be instantiated and called as such:
# obj = MyHashMap()
# obj.put(key,value)
# param_2 = obj.get(key)
# obj.remove(key)