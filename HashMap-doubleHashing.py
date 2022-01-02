# Methodology --> 
#Primary hash table is an array. All initialized to None initially, once visited, each one is then initialized to a bucket (an array). We traverse the bucket to get, update, remove the value

#Time Complexity - O(N) n-number of keys in a bucket
#Space Complexity - O(K) k-number of keys 

class Bucket:
    def __init__(self):
        self.bucket = []
        
    def putValInBucket(self, key:int,val: int):
        i = 0
        #found = False
        for i,key_val in enumerate(self.bucket):
            if key_val[0] == key:
                self.bucket[i]= (key,val)
                return
            
        #if not found:
        self.bucket.append((key,val))

    def getValue(self, key:int):
        for i,key_val in enumerate(self.bucket):
            if key_val[0] == key:
                return key_val[1] 
        return -1
    
    def removeValue(self, key:int):
        for i,key_val in enumerate(self.bucket):
            if key_val[0] == key:
                del self.bucket[i]
    
    
class MyHashMap:
    # we need to balance between hashkey and bucket size
    
    def __init__(self):
        self.bucket_size = 10000
        self.hashTable = [[None] for i in range(self.bucket_size)]
        #print(self.hashTable)

    def get_Hash_table_index(self, key:int):
        return key%self.bucket_size
    
    def put(self, key: int, value: int) -> None:
        
        #finding bucket
        hash_index = self.get_Hash_table_index(key)
        
        if self.hashTable[hash_index] == [None]: #Not Visited
            self.hashTable[hash_index] = Bucket() #Make it visited
       
        self.hashTable[hash_index].putValInBucket(key,value)
        
        
    def get(self, key: int) -> int:
        #finding bucket
        hash_index = self.get_Hash_table_index(key)
        
        if self.hashTable[hash_index] == [None]: #Not Visited
            return -1
        return self.hashTable[hash_index].getValue(key)

    def remove(self, key: int) -> None:
        hash_index = self.get_Hash_table_index(key)
        
        if self.hashTable[hash_index] == [None]: #Not Visited
            return
        return self.hashTable[hash_index].removeValue(key)
        


# Your MyHashMap object will be instantiated and called as such:
# obj = MyHashMap()
# obj.put(key,value)
# param_2 = obj.get(key)
# obj.remove(key)