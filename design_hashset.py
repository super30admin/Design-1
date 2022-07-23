#Time Complexity:: add() - O(1), remove - O(1), contains - O(1)
#Space Complexity:: O(n) where n is the maximum number of elements
#Did this code successfully run on Leetcode : Yes
#Any problem you faced while coding this : No


class MyHashSet:

    def __init__(self): 
        
        self.bucketlength = 1000        #bucketlength is given as input
        self.bucket = [None] * self.bucketlength #a bucket with values 'None' of bucketlength size is defined
    
    def hash1(self, key: int): 
        
        return key % self.bucketlength  #first hash function is done by modulo operation which hashes the horizontal bucket
    
    def hash2(self, key: int):  
        
        return key // self.bucketlength #second hash function is done by division operation which hashes the vertical bucket

    def add(self, key: int) -> None:   
        
        hash1 = self.hash1(key)  
        hash2 = self.hash2(key)
        if not self.bucket[hash1] and hash1 == 0: 
            self.bucket[hash1] = [False]* (self.bucketlength+1)  #if there is no values in both vertical and horizontal buckets, create a bucket with false values of length+1
            
        elif not self.bucket[hash1]:                             #if there is a horizontal bucket with value but no vertical bucket, create a vertical bucket for that bucket of bucketlength
            self.bucket[hash1] = [False]* (self.bucketlength) 
            
        self.bucket[hash1][hash2] = True   #now just make the particular bucket as True, which represents that the value has been added
        

    def remove(self, key: int) -> None: 
        hash1 = self.hash1(key) 
        hash2 = self.hash2(key)  
        
        if self.bucket[hash1]:
            self.bucket[hash1][hash2] = False     #if the bucket of hash1 value is found, make it as False which means it is removed
        
        

    def contains(self, key: int) -> bool:  
        
        hash1 = self.hash1(key) 
        hash2 = self.hash2(key) 
        
        if self.bucket[hash1]: 
            return self.bucket[hash1][hash2]  # #if the bucket of hash1 value is found, return it with corresponding to hash2 too