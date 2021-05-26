# Time Complexity :
# Search operation O(1)
# Space Complexity :
# O(B+n) #Size of Buckets + N Keys
# Did this code successfully run on Leetcode :
# Any problem you faced while coding this :
#
#
# Your code here along with comments explaining your approach

class MyHashMap(object):

    def __init__(self):
        """
        Initialize your data structure here.
        """
        # setting a higher prime number
        self.size = 2341
        self.hash_table = self.create_buckets()

    def create_buckets(self):
        return [[] for _ in range(self.size)]

    def put(self, key, value):
        """
        value will always be non-negative.
        :type key: int
        :type value: int
        :rtype: None
        """
        #Hash the key using has function to get its unique index
        hashed_key = hash(key) % self.size

        # Match bucket to hash key
        bucket = self.hash_table[hashed_key]

        found_key = False
        for index, record in enumerate(bucket):
            record_key, record_val = record

            #Look for the key in the bucket and break if found

            if record_key == key:
                found_key = True
                break

        #if corresponding key is found then update existing key->value
        #if not found then append/add new key->value pair
        if found_key:
            bucket[index] = (key, value)
        else:
            bucket.append((key, value))

    def get(self, key):
        """
        Returns the value to which the specified key is mapped, or -1 if this map contains no mapping for the key
        :type key: int
        :rtype: int
        """
        #Hash the key using has function to get its unique index
        hashed_key = hash(key) % self.size

        # Match bucket to hash key
        bucket = self.hash_table[hashed_key]

        found_key = False
        for index, record in enumerate(bucket):
            record_key, record_val = record

            #Look for the key in the bucket and break if found
            if record_key == key:
                found_key = True
                break

        # return key if found or return -1 no corresponding key
        if found_key:
            return record_val
        else:
            return -1


    def remove(self, key):
        """
        Removes the mapping of the specified value key if this map contains a mapping for the key
        :type key: int
        :rtype: None
        """
        hashed_key = hash(key) % self.size

        # Match bucket to hash key
        bucket = self.hash_table[hashed_key]

        found_key = False
        for index, record in enumerate(bucket):
            record_key, record_val = record

            #Look for the key in the bucket and break if found
            if record_key == key:
                found_key = True
                break
        if found_key:
            bucket.pop(index)
        return

# Your MyHashMap object will be instantiated and called as such:
# obj = MyHashMap()
# obj.put(key,value)
# param_2 = obj.get(key)
# obj.remove(key)