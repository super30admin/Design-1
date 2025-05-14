# Time Complexity: O(1) for all methods
# Space Complexity: O(n), n is number of elements in the input
# Did this code successfully run on Leetcode: Yes


# Your code here along with comments explaining your approach

# maintain a 2D list of 1000 * 1000
# Primary list contains reference to secondary list
# secondary lists stores true of false depending on the value is present or not

class MyHashSet(object):

    def __init__(self):
        self.buckets = 1000
        self.hash_set = [0] * self.buckets
    
    def hash_function_1(self, key):
        return key % self.buckets
    
    def hash_function_2(self, key):
        return key // self.buckets

    def add(self, key):
        """
        :type key: int
        :rtype: None
        """
        hash_value_1 = self.hash_function_1(key)

        if not self.hash_set[hash_value_1]:
            if hash_value_1 == 0:
                self.hash_set[hash_value_1] = [False] * (self.buckets + 1)
            else:
                self.hash_set[hash_value_1] = [False] * self.buckets

        hash_value_2 = self.hash_function_2(key)
        self.hash_set[hash_value_1][hash_value_2] = True
        

    def remove(self, key):
        """
        :type key: int
        :rtype: None
        """
        hash_value_1 = self.hash_function_1(key)
        if not self.hash_set[hash_value_1]:
            return
        hash_value_2 = self.hash_function_2(key)
        self.hash_set[hash_value_1][hash_value_2] = False

        

    def contains(self, key):
        """
        :type key: int
        :rtype: bool
        """
        hash_value_1 = self.hash_function_1(key)
        if not self.hash_set[hash_value_1]:
            return False

        hash_value_2 = self.hash_function_2(key)
        return self.hash_set[hash_value_1][hash_value_2]


# Your MyHashSet object will be instantiated and called as such:
# obj = MyHashSet()
# obj.add(key)
# obj.remove(key)
# param_3 = obj.contains(key)