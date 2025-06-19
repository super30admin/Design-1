# // Time Complexity : O(1)
# // Space Complexity : O(n)
# // Did this code successfully run on Leetcode : yes
# // Any problem you faced while coding this : Understanding the primary and secondary memory took time and faced errors over there.

class MyHashSet(object):
    


    def __init__(self):
        self.primary_size = 1000
        self.secondary_size = 1001
        self.storage = [None] * self.primary_size
        

    def primary_key(self, key):
        # Hash function to get index in the primary array
        return key % self.primary_size

    def secondary_key(self, key):
        # Hash function to get index in the secondary array
        return key // self.primary_size

    def add(self, key):
        """
        :type key: int
        :rtype: None
        """
        primary = self.primary_key(key)
        secondary = self.secondary_key(key)
        # Create the secondary array only if it hasn't been created yet
        if self.storage[primary] is None:
            self.storage[primary] = [False] * self.secondary_size

        # Mark the key as present
        self.storage[primary][secondary] = True

        

    def remove(self, key):
        """
        :type key: int
        :rtype: None
        """
        primary = self.primary_key(key)
        secondary = self.secondary_key(key)

        # Remove the key only if the secondary array exists
        if self.storage[primary] is not None:
            self.storage[primary][secondary] = False
        

    def contains(self, key):
        """
        :type key: int
        :rtype: bool
        """
        primary = self.primary_key(key)
        secondary = self.secondary_key(key)

        # Return True only if the key exists and is marked True
        return self.storage[primary] is not None and self.storage[primary][secondary]

        


# Your MyHashSet object will be instantiated and called as such:
# obj = MyHashSet()
# obj.add(key)
# obj.remove(key)
# param_3 = obj.contains(key)