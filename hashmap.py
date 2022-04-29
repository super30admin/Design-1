class MyHashMap:

    def __init__(self):
        #create primary array of 1000 length
        self.buckets = [None]*1000
        
    def buckethash(self, key):
        return key%1000
    
    def bucketitemhash(self, key):
        return key//1000
        

    def put(self, key: int, value: int) -> None:
        #Find the bucket to place the value
        bucket = self.buckethash(key)
        
        #If array is not present at a bucket, create a new array of size 1000(1001 if bucket is 0)
        if(self.buckets[bucket] == None):
            if bucket == 0:
                self.buckets[bucket] = [-1]*1001
            else:
                self.buckets[bucket] = [-1]*1000
        
        #get the index where to place value 
        bitem = self.bucketitemhash(key)
        self.buckets[bucket][bitem] = value
            

    def get(self, key: int) -> int:
        
        #If bucket exists return value from array of bucketitems
        if self.buckets[self.buckethash(key)] != None:
            return self.buckets[self.buckethash(key)][self.bucketitemhash(key)]
        return -1
        

    def remove(self, key: int) -> None:
        
        #If bucket exists remove value from array of bucketitems
        if self.buckets[self.buckethash(key)] != None:
            self.buckets[self.buckethash(key)][self.bucketitemhash(key)] = -1
            return None
            
                
        


# Your MyHashMap object will be instantiated and called as such:
obj = MyHashMap()
obj.put(1001,3)
param_2 = obj.get(1001)
obj.remove(1001)
