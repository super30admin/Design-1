# Time Complexity O(1) for each operation
# Space Complexity O(1000000)
# Successfully ran on leetcode
# I was trying to make bucket[index] an empty list and then appending [False]*1000 which resulted in 3-D array and was difficult for accessing. Later realized the mistake and changed it.


class MyHashSet:

    def __init__(self):
        # initializing primary array

        self.buckets = [None]*1000
        
    def add(self, key: int) -> None:
        # if bucket[index] is None, then we append a list with False of size 1001 when first hash function returns 0 else False with size 1000

        if self.buckets[self.hash1(key)] == None:
            if self.hash1(key) == 0:
                self.buckets[self.hash1(key)]=[]
                for i in range(1001):
                    self.buckets[self.hash1(key)].append(False)
            else:
                self.buckets[self.hash1(key)]=[]
                for i in range(1000):
                    self.buckets[self.hash1(key)].append(False)
            # Mark as True while adding
            self.buckets[self.hash1(key)][self.hash2(key)] = True
        else:
            self.buckets[self.hash1(key)][self.hash2(key)] = True
                
    def remove(self, key: int) -> None:
        # bucket[index] is not None i.e, bucket[index] has elements and bucket[index][index] is True, we mark it False else do nothing

        if self.buckets[self.hash1(key)] is not None:
            if self.buckets[self.hash1(key)][self.hash2(key)] == True:
                self.buckets[self.hash1(key)][self.hash2(key)] = False

    def contains(self, key: int) -> bool:
        # bucket[index] is not None i.e, bucket[index] has elements and bucket[index][index] is True, we return True else False

        if self.buckets[self.hash1(key)] is not None:
            if self.buckets[self.hash1(key)][self.hash2(key)] == True:
                return True
            else:
                return False
            
    def hash1(self,key:int) -> int:
        # First hash function

        return key % 1000
    
    def hash2(self,key:int) -> int:
        # Second hash function
        
        return key//1000

# Your MyHashSet object will be instantiated and called as such:
# obj = MyHashSet()
# obj.add(key)
# obj.remove(key)
# param_3 = obj.contains(key)