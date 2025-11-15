# We create a 1D array with the length = sq root of the max val. 
# During the add, we perform mod operation on the key -hash1 and 
# check if the hash1 index has an array assigned, if it doesnt, we
#  assign an array of length sqrt of max value. We then assign then 
#  perform hash2 - key/sqrt of lenght.  The key is then stored to 
#  array[hash1][hash2]. To delele, we again perform hash1 and hash2 
#  and then nullify array[hash1][hash2]. The same logic is applied to
#   search as well.

# Time complexity : O(1)
# Space complexity: O(n)




class MyHashSet(object):

    def __init__(self):
        self.bucket = 1001
        self.bucketItems = 1001
        self.storage = [None for i in range(self.bucket)]



    def hash1(self, key):
        return key%self.bucket


    def hash2(self, key):
        return key//self.bucketItems



    def add(self, key):
        """
        :type key: int
        :rtype: None
        """
        map1 = self.hash1(key)
        map2 = self.hash2(key)
        if self.storage[map1]:
            self.storage[map1][map2]=key
        else:
            if map1 == 0:
                self.storage[map1]=[None for i in range(self.bucketItems+1)]
            else:
                self.storage[map1]=[None for i in range(self.bucketItems)]
            self.storage[map1][map2]= key
        

    def remove(self, key):
        """
        :type key: int
        :rtype: None
        """
        map1 = self.hash1(key)
        map2 = self.hash2(key)
        if self.storage[map1]:
            if self.storage[map1][map2]==key:
                self.storage[map1][map2]=None
    
        
        

    def contains(self, key):
        """
        :type key: int
        :rtype: bool
        """
        map1 = self.hash1(key)
        map2 = self.hash2(key)
        if self.storage[map1]:
            if self.storage[map1][map2]==key:
                return True
        return False
               


# Your MyHashSet object will be instantiated and called as such:
# obj = MyHashSet()
# obj.add(key)
# obj.remove(key)
# param_3 = obj.contains(key)