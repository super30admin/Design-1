#Time Complexity: O(1) for removal
#Space Complexity: O(n)
#Did this code successfully run on leetcode: yes
#Any problem you faced while coding thing:


class MyHashMap:

    def __init__(self):

        self.buckets=1001 # hash map size
        self.bucketitems=1000 #double hashing
        self.data=[None]*self.buckets


    def put(self, key: int, value: int) -> None:
        index_1=key%self.buckets #first hash function
        index_2=int(key/self.bucketitems) #second hash function
        if self.data[index_1] is None: #only create a second array if we use one case
            self.data[index_1]=[None]*self.bucketitems
        self.data[index_1][index_2]=value


    def get(self, key: int) -> int:
        # we have to break it in steps, or else we would have index errors if they don't exist
        if self.data[key%self.buckets] is not None:
            if self.data[key%self.buckets][int(key/self.bucketitems)] is not None:
                return self.data[key%self.buckets][int(key/self.bucketitems)]
        return -1

    def remove(self, key: int) -> None:
        #check first if the bucket is not null
        #we cannot put directly the two indices because the second one might not exist
        if self.data[key%self.buckets] is not None:
            self.data[key%self.buckets][int(key/self.bucketitems)]=None
