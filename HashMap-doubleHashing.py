# -*- coding: utf-8 -*-

class MyHashMap:

    def __init__(self):
        """
        Initialize your data structure here.
        """
        self.primary_array_size=1000 ## this is the length of the primary array
        self.bucket_size=1000 ##these are the number of items in each array
        
        self.primary_array=[[None] for _ in range (self.primary_array_size)]

    def primary_array_f(self, key):
        return key % self.primary_array_size
    
    def bucketitem(self, key: int) -> int:
       # print(key%self.bucket_size,key,self.bucket_size)
        return key%self.bucket_size
    
    
    def put(self, key: int, value: int) -> None:
        """
        value will always be non-negative.
        """
       # print("put-->",value)
        
        primary_array_index = self.primary_array_f(key)
        #print(primary_array_index)
        
        bucket_index = self.bucketitem(key)
        #print(bucket_index)
            
        if(self.primary_array[primary_array_index]==[None]):
            if(primary_array_index == 0):
                self.primary_array[primary_array_index] = [[None] for i in range (self.bucket_size+1)]
            else:
                self.primary_array[primary_array_index] = [[None] for i in range (self.bucket_size)]

        self.primary_array[primary_array_index][bucket_index] = value
     #   print(primary_array_index,bucket_index)
        
    def get(self, key: int) -> int:
        """
        Returns the value to which the specified key is mapped, or -1 if this map contains no mapping for the key
        """
        primary_array_index = self.primary_array_f(key)
        bucket_index = self.bucketitem(key)
      #  print("get -->",key)
     #   print(primary_array_index,bucket_index)
        if(self.primary_array[primary_array_index]==[None]):
   #         print("if1")
            return -1
        elif self.primary_array[primary_array_index][bucket_index] == False:
    #        print("if2")
            return -1
        else:
            return self.primary_array[primary_array_index][bucket_index]

    def remove(self, key: int) -> None:
        """
        Removes the mapping of the specified value key if this map contains a mapping for the key
        """
        primary_array_index = self.primary_array_f(key)
        bucket_index = self.bucketitem(key)
        if(self.primary_array[primary_array_index]!=[None]) and (self.primary_array[primary_array_index][bucket_index] == True):
            self.primary_array[primary_array_index][bucket_index] = False


# Your MyHashMap object will be instantiated and called as such:
# obj = MyHashMap()
# obj.put(key,value)
# param_2 = obj.get(key)
# obj.remove(key)