# // Time Complexity :O(1)
# // Space Complexity :O(1000)
# // Did this code successfully run on Leetcode :yes
# // Any problem you faced while coding this :no, but you can still check

# // Your code here along with comments explaining your approach


class MyHashSet:

    def __init__(self):
        """
        Initialize your data structure here.
        """
        self.hashs=[[]]*1000
        self.bucket=1000
        self.bucketItems=1000
        

    def add(self, key: int) -> None:
        hashed_key=key%self.bucket
       
        d_hashed_key=key//self.bucketItems
        
        if(self.hashs[hashed_key]==[]):
            if hashed_key==0:
                
                self.hashs[hashed_key]=[False]*1001
            else:
                self.hashs[hashed_key]=[False]*1000
        self.hashs[hashed_key][d_hashed_key]=True
        print(self.hashs[hashed_key][d_hashed_key])

    def remove(self, key: int) -> None:
        hashed_key=key%self.bucket
        
        d_hashed_key=key//self.bucketItems 
        if self.hashs[hashed_key]==[]:
            return
        self.hashs[hashed_key][d_hashed_key]=False
        
    def contains(self, key: int) -> bool:
        hashed_key=key%self.bucket
        
        d_hashed_key=key//self.bucketItems
        if(self.hashs[hashed_key]==[]):
            return False
        
        return self.hashs[hashed_key][d_hashed_key]        
        """
        Returns true if this set contains the specified element
        """
        
    # Your MyHashSet object will be instantiated and called as such:
    # obj = MyHashSet()
    # obj.add(key)
    # obj.remove(key)
    # param_3 = obj.contains(key)


