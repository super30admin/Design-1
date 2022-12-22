class MyHashSet(object):

    def __init__(self):
        self.buckets = 1001
        self.bucketItems = 1001
        self.storage = [None for _ in range(self.buckets)]
        
    def __buckets(self,key):
        return int(key%self.buckets)
    def __bucketItems(self,key):
        return int(key/self.bucketItems)
    

    def add(self, key):
        hashedItem = self.__buckets(key)
        hashedAgain = self.__bucketItems(key)
        
        if self.storage[hashedItem] is None:
            self.storage[hashedItem] = [None for _ in range(self.bucketItems)]
            
        self.storage[hashedItem][hashedAgain] = True
        

    def remove(self, key):
        hashedItem = self.__buckets(key)
        hashedAgain = self.__bucketItems(key)

        if self.storage[hashedItem] is not None:
            self.storage[hashedItem][hashedAgain] = False
            
    def contains(self, key):
        hashedItem = self.__buckets(key)
        hashedAgain = self.__bucketItems(key)

        if self.storage[hashedItem] is not None:
            return self.storage[hashedItem][hashedAgain] 
        return False