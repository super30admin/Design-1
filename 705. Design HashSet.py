class MyHashSet(object):

    # Trying to make a 2D matrix so when we have 10^6 elements we make the primary arr of size 1000 which is the square root of 10^6
    # Then we define 2 funtions one which gives the % and the other for // so that we optimise on space which is called lazy allocation. First just initialise the arr of length 1000 and then assign the secondary array as we need.
    # Use boolean for less space and perform the operations accordingly

    # Time complexity : O(1) for every operation
    # Space complexity: O(n)
    def __init__(self):
        self.primary_arr = [None] * 1001

    def hash1(self, num):
        return num % 1000
    def hash2(self, num):
        return num // 1000
        

    def add(self, key):
        """
        :type key: int
        :rtype: None
        """
        primary_num = self.hash1(key)
        secondary_num = self.hash2(key)

        if self.primary_arr[primary_num] == None:
            self.primary_arr[primary_num] = [None] * 1001
        self.primary_arr[primary_num][secondary_num] = True
        

    def remove(self, key):
        """
        :type key: int
        :rtype: None
        """
        primary_num = self.hash1(key)
        secondary_num = self.hash2(key)
        if self.primary_arr[primary_num] == None:
            return
        self.primary_arr[primary_num][secondary_num] = False
        
        

    def contains(self, key):
        """
        :type key: int
        :rtype: bool
        """
        primary_num = self.hash1(key)
        secondary_num = self.hash2(key)
        if self.primary_arr[primary_num] == None:
            return False
        elif self.primary_arr[primary_num][secondary_num] == True:
            return True
        return False
        


# Your MyHashSet object will be instantiated and called as such:
# obj = MyHashSet()
# obj.add(key)
# obj.remove(key)
# param_3 = obj.contains(key)
