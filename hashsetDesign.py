'''
Time Complexity
add --> O(1)
remove --> O(1)
contains --> O(1)

space complexity 
storage space of 2d matrix of size 10**6 O(10**6)
'''




class MyHashSet:

    def __init__(self):
        self.max_limit = 10**3
        self.storage = [ [False]*1001 for i in range(1000)]  #initialize 2d array
        #print(self.storage)
        

    def add(self, key: int) -> None:
        bucket = key % self.max_limit         #primary array finding bucket 
        bucket_item = key // self.max_limit   #secondary array finding bucket iteem 
        # print("Add")
        # print(bucket,end=' ')
        # print(bucket_item)
        #print(self.storage[bucket][bucket_item])
        self.storage[bucket][bucket_item] = True   
        

    def remove(self, key: int) -> None:
        bucket = key % self.max_limit
        bucket_item = key // self.max_limit
        # print("Remove")
        # print(bucket,end =' ')
        # print(bucket)
        self.storage[bucket][bucket_item] = False
        
        

    def contains(self, key: int) -> bool:
        bucket = key % self.max_limit
        bucket_item = key // self.max_limit
        # print("Contains")
        # print(bucket,end =' ')
        # print(bucket_item)
        # print(self.storage[bucket][bucket_item])
        return self.storage[bucket][bucket_item]
            
        


# Your MyHashSet object will be instantiated and called as such:
# obj = MyHashSet()
# obj.add(key)
# obj.remove(key)
# param_3 = obj.contains(key)