#Time Complexity : O(1)
#Space Complexity: O(1)
#The code ran successfully on leetcode
# I faced no problem while coding this

class MyHashSet(object):
    #Constructor
    def __init__(self):
        #initializing all the required variables and the list
        self.buckets=1000
        self.bucketItems=1000
        self.hash_set=[None]*self.buckets
    
    def intialhash(self, key):
        #Calculaitng the index for initial hash
        return key%self.buckets

    def secondaryHash(self,key):
        #calculating the index for internal hash
        return key//self.bucketItems 

    def add(self, key):
        """
        :type key: int
        :rtype: None
        """
        #calculating th corresponding hash values using the initialhash and secondaryhash functions
        self.bucket=self.intialhash(key)
        self.bucketItem=self.secondaryHash(key)
        #checking whther internal list has been created for primary list
        if(self.hash_set[self.bucket]==None):
            #if the index is 0, we will be creating list of size 1001 to handle the extreme test case 
            if(self.bucket==0):
                self.hash_set[self.bucket]=list(bytearray(self.bucketItems+1))
            else:
                self.hash_set[self.bucket]=list(bytearray(self.bucketItems))
        #we will update the value 0 to 1 if we are inserting the value into the array
        self.hash_set[self.bucket][self.bucketItem]=1        

    def remove(self, key):
        """
        :type key: int
        :rtype: None
        """
        #calculating th corresponding hash values using the initialhash and secondaryhash functions
        self.bucket=self.intialhash(key)
        self.bucketItem=self.secondaryHash(key)
        #If the primary array bucket value is none we will return nothing
        if(self.hash_set[self.bucket]==None):
            return
        #If the value is present we will be updating to 0
        self.hash_set[self.bucket][self.bucketItem]=0

    def contains(self, key):
        """
        :type key: int
        :rtype: bool
        """
        #calculating th corresponding hash values using the initialhash and secondaryhash functions
        self.bucket=self.intialhash(key)
        self.bucketItem=self.secondaryHash(key)
        #If the value is not present we will return False else we will return 1
        if(self.hash_set[self.bucket]==None):
            return False
        return self.hash_set[self.bucket][self.bucketItem]

# Your MyHashSet object will be instantiated and called as such:
# obj = MyHashSet()
# obj.add(key)
# obj.remove(key)
# param_3 = obj.contains(key)