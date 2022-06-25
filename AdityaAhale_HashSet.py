# Time Complexity : 226
#  Space Complexity : 26.4
#  Did this code successfully run on Leetcode : Yes
#  Any problem you faced while coding this : For one case I had wrong output as the else condition was not handled correctly


#  Your code here along with comments explaining your approach
class MyHashSet:
    # initailized the length and bucket here by using array[array] to avoid any collision
    def __init__(self):
        self.bucketListLength = 1000
        self.bucket = [None] * self.bucketListLength

    #To avoid index collision performed normal and modulo division, modulo will give the index of oute array and the division will give index of nested array
    def getbucket(self,key):
        return key % self.bucketListLength
    
    def getbucketitems(self,key):
        return key // self.bucketListLength
    
    #Here it is just checking it the position is valid or not and based on that it will add
    def add(self, key: int) -> None:
        index = self.getbucket(key)
        indexItem = self.getbucketitems(key)
        
        if not self.bucket[index]  and index == 0:
            self.bucket[index] = [False] * (self.bucketListLength + 1)
            
        elif not self.bucket[index]:
            self.bucket[index] = [False] * self.bucketListLength 
        self.bucket[index][indexItem] = True
    
    #Here the exact position is found then that position is assigned False 
    def remove(self, key: int) -> None:
        index = self.getbucket(key)
        indexItem = self.getbucketitems(key)
        
        if self.bucket[index]:
            self.bucket[index][indexItem] = False

    #This returns the index of outer and nested array where the key is located
    def contains(self, key: int) -> bool:
        index = self.getbucket(key)
        indexItem = self.getbucketitems(key)
        
        if self.bucket[index]:
            return self.bucket[index][indexItem]


# Your MyHashSet object will be instantiated and called as such:
# obj = MyHashSet()
# obj.add(key)
# obj.remove(key)
# param_3 = obj.contains(key)