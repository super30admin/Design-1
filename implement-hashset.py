'''
1) add()
Time complexity: O(1)
Space complexity: O(N)

2) remove()
Time complexity: O(1)
Space complexity: O(1)

3) contains()
Time complexity: O(1)
Space complexity: O(1)
'''

class MyHashSet:

    def __init__(self):
        self.hashSet = [None]*1000
    '''
    First hash function that returns the index of the bucket
    '''
    def getBucketIndex(self, key) -> int:
        return key % 1000
    '''
    Second hash function that returns the index of the bucket item
    '''
    def getBucketItemIndex(self, key ) -> int:
        return key // 1000
    '''
    Add a key into the hashset
    '''
    def add(self, key: int) -> None:
        bucketIndex = self.getBucketIndex(key)
        bucketItemIndex = self.getBucketItemIndex(key)

        if self.hashSet[bucketIndex] is None:
            if bucketIndex == 0:
                self.hashSet[bucketIndex] = [False] * 1001
            else:
                self.hashSet[bucketIndex] = [False] * 1000
            self.hashSet[bucketIndex][bucketItemIndex] = True
        else:
            self.hashSet[bucketIndex][bucketItemIndex] = True
            
    '''
    Remove a key from the hashset
    '''
    def remove(self, key: int) -> None:
        bucketIndex = self.getBucketIndex(key)
        bucketItemIndex = self.getBucketItemIndex(key)
        if self.hashSet[bucketIndex] is not None:
            self.hashSet[bucketIndex][bucketItemIndex] = False
    
    '''
    Check if the key exists in the hashset
    '''              
    def contains(self, key: int) -> bool:
        bucketIndex = self.getBucketIndex(key)
        bucketItemIndex = self.getBucketItemIndex(key)
        if self.hashSet[bucketIndex] is None:
            return False
        if self.hashSet[bucketIndex][bucketItemIndex] == True:
            return True
        return False
        
        


# Your MyHashSet object will be instantiated and called as such:
# obj = MyHashSet()
# obj.add(key)
# obj.remove(key)
# param_3 = obj.contains(key)