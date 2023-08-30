#Time Complexity : O(1)
# Space Complexity :  O(n) n=No of keys 
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this :


# Your code here along with comments explaining your approach
class MyHashSet:

    def __init__(self):
        self.bucket=1000
        self.bucketlist=1000
        self.hashset=[None]*self.bucket

    def hashbucket(self,key):
            return int(key%self.bucket) 

    def hashbucketlist(self,key):
            return int(key/self.bucketlist)
        

    def add(self, key: int) -> None:
        hashbucket_val = self.hashbucket(key)
        hashbucketlist_val=self.hashbucketlist(key)
        # print("test", hashbucket_val , hashbucketlist_val)
        if( self.hashset[hashbucket_val] is None):
            if(hashbucket_val == 0):
                self.hashset[hashbucket_val]=[None]*(self.bucketlist+1)
            else:
                self.hashset[hashbucket_val]=[None]*self.bucketlist  
            # print("inside: ", self.hashset)
        self.hashset[hashbucket_val][hashbucketlist_val]=key 
        # print("set: ", self.hashset)
        

    def remove(self, key: int) -> None:
        hashbucket_val=self.hashbucket(key)
        hashbucketlist_val=self.hashbucketlist(key) 
        if(self.hashset[hashbucket_val] is None):
            return
        else:

            self.hashset[hashbucket_val][hashbucketlist_val] = None
    
        

    def contains(self, key: int) -> bool:
        hashbucket_val=self.hashbucket(key)
        hashbucketlist_val=self.hashbucketlist(key)
        
        
        if( self.hashset[hashbucket_val] is None):
            return False
        
        elif(self.hashset[hashbucket_val][hashbucketlist_val] is not None):            
            return True
        else:
            # print("Printing value")
            self.hashset[hashbucket_val]
            # print(self.hashset[hashbucket_val][hashbucketlist_val])
            # print(self.hashset)
            # print(hashbucket_val, hashbucketlist_val)
            # print("printed value")
            # print(key)
            # print("False-- last")
            
            return False
        


# Your MyHashSet object will be instantiated and called as such:
# obj = MyHashSet()
# obj.add(key)
# obj.remove(key)
# param_3 = obj.contains(key)`