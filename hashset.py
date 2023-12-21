""" Similar to the hashmap implementation, the hashset implementation takes place for a list of size 10**6 and +1 for the last index
    For the hashset, however, I assign the boolean value to the key using the add method, removing using the remove method, and checking
    existence using the contains method.
    Time Complexcity: O(1) for all 3 methods
    Space Complexcity: O(1) for all 3 methods
"""


class MyHashSet(object):
    
    def __init__(self):
        hashset_size = 10**6 + 1
        self.hashset = [False]*hashset_size

    def add(self, key):
        """
        :type key: int
        :rtype: None
        """
        self.hashset[key] = True
        

    def remove(self, key):
        """
        :type key: int
        :rtype: None
        """
        self.hashset[key] = False
        

    def contains(self, key):
        """
        :type key: int
        :rtype: bool
        """
        if self.hashset is not None:
            return self.hashset[key]
        else:
            return
        


# Your MyHashSet object will be instantiated and called as such:
# obj = MyHashSet()
# obj.add(key)
# obj.remove(key)
# param_3 = obj.contains(key)