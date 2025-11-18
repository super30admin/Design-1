"""
QUESTION
https://leetcode.com/problems/design-hashset/description/

"""

#Time Complexity:
# add: O(1)
# remove: O(1)
# contains: O(1)
                 
#Space Complexity: O(n)

class MyHashSet(object):

    def __init__(self):
        """
        Initialize the size and the hash table equal to the size 
        """
        self.size = 10000
        self.table = [None] * self.size
        
    def calculate_hash_value(self, key):
        """
        Function to calculate hash function using %
        """
        return key % self.size

    def add(self, key):
        """
        If the hash table is empty them we add the key into the table
        if there is a bucket we just need to append the key to the table
        :type key: int
        :rtype: None
        """
        hash = self.calculate_hash_value(key)
        if self.table[hash] is None:
            self.table[hash] = [key]
        elif key not in self.table[hash]:
            self.table[hash].append(key)
        

    def remove(self, key):
        """
        If the table is not empty and the key is in the hash table then remove the key from the table
        :type key: int
        :rtype: None
        """
        hash = self.calculate_hash_value(key)
        if self.table[hash] is not None and key in self.table[hash]:
            self.table[hash].remove(key)

    def contains(self, key):
        """
        Returns true if the value exists in the hashset
        :type key: int
        :rtype: bool
        """
        hash = self.calculate_hash_value(key)
        if self.table[hash] is not None:
            return key in self.table[hash]
        #if key does not exist or table empty then false
        return False

        

myHashSet = MyHashSet()
myHashSet.add(1)       # set = [1]
myHashSet.add(2)       # set = [1, 2]
print(myHashSet.contains(1))  # True
print(myHashSet.contains(3))  # False
myHashSet.add(2)       # still [1, 2]
print(myHashSet.contains(2))  # True
myHashSet.remove(2)    # set = [1]
print(myHashSet.contains(2))  # False