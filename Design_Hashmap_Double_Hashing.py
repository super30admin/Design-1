# Created by Aashish Adhikari at 12:50 PM 12/23/2020

class MyHashMap(object):

    def __init__(self):
        """
        Initialize your data structure here.
        """
        # Use sqrt(max of the range of the key) for hash functions
        self.first_level = [False for idx in range(1000)]




    def put(self, key, value):
        """
        value will always be non-negative.
        :type key: int
        :type value: int
        :rtype: None
        """

        first_level_idx = key % 1000
        second_level_idx = key / 1000

        # Create second level if not present
        if self.first_level[first_level_idx] is False:
            self.first_level[first_level_idx] = [False for idx in range(1000)]

        self.first_level[first_level_idx][second_level_idx] = value

    def get(self, key):
        """
        Returns the value to which the specified key is mapped, or -1 if this map contains no mapping for the key
        :type key: int
        :rtype: int
        """
        first_level_idx = key % 1000
        second_level_idx = key / 1000
        if self.first_level[first_level_idx] is not False:
            if self.first_level[first_level_idx][second_level_idx] is not False:
                return self.first_level[first_level_idx][second_level_idx]
            else:
                return -1
        return -1






    def remove(self, key):
        """
        Removes the mapping of the specified value key if this map contains a mapping for the key
        :type key: int
        :rtype: None
        """
        first_level_idx = key % 1000
        second_level_idx = key / 1000

        if self.first_level[first_level_idx] is not False:
            if self.first_level[first_level_idx][second_level_idx] is not False:
                self.first_level[first_level_idx][second_level_idx] = False





# Your MyHashMap object will be instantiated and called as such:
# obj = MyHashMap()
# obj.put(key,value)
# param_2 = obj.get(key)
# obj.remove(key)