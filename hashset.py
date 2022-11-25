# // Time Complexity :
# // Space Complexity :
# // Did this code successfully run on Leetcode :
# // Any problem you faced while coding this :


# // Your code here along with comments explaining your approach


class HashSet:
    def __init__(self):
        # We are taking the length of primsry storage as 1000 because we want to build a balanced array
        # for an input of 1000000
        self.storage = [None]*1000

    def add(self, key):
        #we are taking the hashing function to find the index as "%1000"
        primaryBucket = key%1000

        if self.storage[primaryBucket] == None:
            if primaryBucket == 0:
                self.storage[primaryBucket] = [False]*1001
            
            else:
                self.storage[primaryBucket] = [False]*1000
            
        secondaryBucket = key//1000
        self.storage[primaryBucket][secondaryBucket] = True

    def remove(self, key):
        primaryBucket = key%1000
        secondaryBucket = key//1000
        if self.storage[primaryBucket] == None:
            return -1
        self.storage[primaryBucket][secondaryBucket] = False

    def contains(self, key):
        primaryBucket = key%1000
        secondaryBucket = key//1000
        if self.storage[primaryBucket] == None:
            return -1
        
        return self.storage[primaryBucket][secondaryBucket]


## Testing the Design

hashSetInstance = HashSet()

print(hashSetInstance.add(4))
print(hashSetInstance.add(20))
print(hashSetInstance.add(10004))
print(hashSetInstance.add(0))
print(hashSetInstance.contains(10004))
print(hashSetInstance.contains(1))
print(hashSetInstance.contains(0))
print(hashSetInstance.remove(0))
print(hashSetInstance.contains(0))
print(hashSetInstance.remove(10004))
print(hashSetInstance.contains(10004))



        



        
