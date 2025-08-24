# // Time Complexity : add - O(1), remove - O(1), contains - O(1)
# // Space Complexity : add - O(n) , no extra space for remove or contains
# // Did this code successfully run on Leetcode : Yes
# // Any problem you faced while coding this : not much , once revised the video 

class MyHashSet(object):
    # conditions 
    # input we get 2 lists, 1 with operations, 1 with the value for the operation
    # it's a set, so duplicate elements should not be in the list 
    # output of each operation

    def __init__(self):
        # to design the hash set we have to decide which primitive data stureture to use which can be efficient
        # lets think of array - O(1) to add, but we need tosearch if the element exist or not and then add it 
        # which is O(n) linear search to check if the value ecists, so using array is slow and not efficient 
        # linked list, even linked list to check if the element exist have to iterate the whole list again same issue
        # here is where we use hashing, as hashing main benift is it's searhc complexity is O(1)
        # so using hashing to create the hashset 
        # primitive data structure is buckets array and each slot of this bucket is a pointer referencing a dynamic list
        # using double hashing to avoid collisions
        # col is the col index where the hahs values will be stored
        # row index is in that col , the row index to store the value of the input
        # example 234, its is stored in 1234%1000 , so 234th col index is the col we store but in that which row we store ?
        # 1234/1000 is 1, so col 234 and 1st row we mark it as tru statung the value exists. easier to check the contins method next time
        # easier to add etc 

        self.col = 1000
        self.row = 1000
        self.hashset = [None]*self.col

    def col_hash(self,key):
        return key%self.col

    def row_hash(self,key):
        return key//self.row


    def add(self, key):
        # if key does not exist in the set then add the key in the set if already exists then skip the key
        col_index = self.col_hash(key)
        row_index = self.row_hash(key)

        if self.hashset[col_index] is None :# the col index is not intialized 
            # on demand add the row buckets ( this is the best way to optimize the memory)
            if col_index == 0:
                self.hashset[col_index] = [False]*(self.row + 1) # this +1 because, the first [0,0] is used for col intializatin which reduces 1 less for the row in the 0th so +1
            else:
                self.hashset[col_index] = [False]*self.row

        # on demand created the row of that col 

        self.hashset[col_index][row_index] = True # made that index true 

    def remove(self, key):
        """
        :type key: int
        :rtype: None
        """
        # just notify that index as false, and the value never exists in the hashset

        col_index = self.col_hash(key)
        row_index = self.row_hash(key)

        if self.hashset[col_index] is not None: 
            self.hashset[col_index][row_index] = False
        

    def contains(self, key):
        """
        :type key: int
        :rtype: bool
        """
        # if the key in the set return true or false

        col_index = self.col_hash(key)
        row_index = self.row_hash(key)

        if self.hashset[col_index] is None:
            return False
        
        return self.hashset[col_index][row_index]



# Your MyHashSet object will be instantiated and called as such:
# obj = MyHashSet()
# obj.add(key)
# obj.remove(key)
# param_3 = obj.contains(key)