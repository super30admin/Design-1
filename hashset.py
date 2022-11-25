# // Time Complexity :O(1)
# // Space Complexity : O(n)
# // Did this code successfully run on Leetcode : Yes
# // Any problem you faced while coding this : No 



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
            ## here we initialize our secondaryStorage if we find that this index does not have one already 
            # for the 0th position we have the length as 1001 because we are including the 1000000th element whose %1000 would also be 0


            ## here we initialize our secondaryStorage if we find that this index does not have one already 
            # for the 0th position we have the length as 1001 because we are including the 1000000th element whose %1000 would also be 0

            if primaryBucket == 0:
                self.storage[primaryBucket] = [False]*1001
            
            else:
                self.storage[primaryBucket] = [False]*1000

        
        # we find the second hashing and then assign the value for the key
        # we find the second hashing and then assign the value for the key
        secondaryBucket = key//1000
        self.storage[primaryBucket][secondaryBucket] = True

    def remove(self, key):
        ## we initialize the first hash and the second hash and check if the first hash even contains a secondary storage,
        # if not we return -1
        ## else we make that key as False to indicate that there is no Key
        ## we use True/False for the secondary array as we dont need to really store the key.(storing boolean is better here for this usecase)
        primaryBucket = key%1000
        secondaryBucket = key//1000
        if self.storage[primaryBucket] == None:
            return -1
        self.storage[primaryBucket][secondaryBucket] = False

    def contains(self, key):
        ## we initialize the first hash and the second hash and check if the first hash even contains a secondary storage,
        # we again  check if the index even exists, if it does we return the value else return -1

        ## we initialize the first hash and the second hash and check if the first hash even contains a secondary storage,
        # we again  check if the index even exists, if it does we return the value else return -1
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



        



        
