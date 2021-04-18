'''

Time Complexity : O(N), since there is one for loop  while putting the elements in HM
Space Complexity : O(N), grows linearly with the number of elements being added
Did this code successfully run on Leetcode : Yes
Any problem you faced while coding this : Yes, I eas returning None in the get method if the key was absent a
whereas I had to return -1, should have read the question properly.

'''





class MyHashMap:

    def __init__(self):
        """
        Initialize your data structure here.
        """
        # array of tuples containing (key, value) , initially, its (None, None)
        self.hm = []

    def put(self, key: int, value: int) -> None:
        """
        value will always be non-negative.
        TC = O(N) as we are searching linearly first
        """
        '''
        flag = 0
        # case - 1 the key already exists in the hash map, update the value (my approach is to remove the existing KV pair and add the new (key, value) )
        for k, v in self.hm:
            if k == key:
                flag = 1
                self.hm.remove((k, v))
                self.hm.append((key, value))

        # case 2 - key does not exist, create a new tuple and add it to the array
        if flag == 0:
            self.hm.append((key, value))


        '''
        # While the above code works fine, Instead of using flag, do an early return from  the             function
        for k, v in self.hm:
            if k == key:
                self.hm.remove((k, v))
                self.hm.append((key, value))
                return

                # case 2 - key does not exist, create a new tuple and add it to the array

        self.hm.append((key, value))

    def get(self, key: int) -> int:
        """
        Returns the value to which the specified key is mapped, or -1 if this map contains no mapping for the key
        Time complexity - O(N)
        """

        # case 1 - key is found, return its correponding value
        for k, v in self.hm:
            if k == key:
                return v
        # case 2 - key is not present, return -1
        return -1

    def remove(self, key: int) -> None:
        """
        Removes the mapping of the specified value key if this map contains a mapping for the key
        TC - O(N)
        """
        # case 1 - key is present, remove
        for k, v in self.hm:
            if k == key:
                self.hm.remove((k, v))
                return

                # case2 - key is absent, do nothing
        return None

# Your MyHashMap object will be instantiated and called as such:
# obj = MyHashMap()
# obj.put(key,value)
# param_2 = obj.get(key)
# obj.remove(key)