# // Time Complexity :O(1)
# // Space Complexity :O(n)
# // Did this code successfully run on Leetcode : yes
# // Any problem you faced while coding this :no

class MyHashMap:
    

    def __init__(self):
        numBucket=1000001
        #create bucket of size 10^6+1 as the given constraints on key and value
        self.bucket=[-1]*numBucket
        
        
    def put(self, key: int, value: int) -> None:
        #add key value pair
        self.bucket[key]=value
          
    def get(self, key: int) -> int:
        #get value at key
        return self.bucket[key]
        
    def remove(self, key: int) -> None:
        #remove value at key
        self.bucket[key]=-1

# Your MyHashMap object will be instantiated and called as such:
obj = MyHashMap()
obj.put(1,2)
obj.put(3,4)
param_2 = obj.get(1)
print(param_2)
obj.remove(1)
