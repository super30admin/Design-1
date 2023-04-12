class MyHashSet(object):
    def getBucket(self,key):
        return key%self.bucket

    def getBucketItem(self,key):
        return key//self.bucketItem

    def __init__(self):
        self.bucket=1000
        self.bucketItem=1000
        self.hashTable=[[None for i in range(self.bucket+1)] for i in range(self.bucketItem)]
        
    def add(self, key):
        """
        :type key: int
        :rtype: None
        """
        self.hashTable[self.getBucket(key)][self.getBucketItem(key)]=key
        

    def remove(self, key):
        """
        :type key: int
        :rtype: None
        """
        self.hashTable[self.getBucket(key)][self.getBucketItem(key)]=None
        

    def contains(self, key):
        """
        :type key: int
        :rtype: bool
        """
        if self.hashTable[self.getBucket(key)][self.getBucketItem(key)]==None:
            return None
        else:
            return True

# Your MyHashSet object will be instantiated and called as such:
# obj = MyHashSet()
# obj.add(key)
# obj.remove(key)
# param_3 = obj.contains(key)