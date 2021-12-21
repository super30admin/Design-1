# Time Complexity : Ammortizes to O(1) for add. O(1) for contains and remove.
# Space Complexity : O(1) because it does not asymptotically depend on the input BUT worst case space is proportional to the range of data.
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : This question is really open ended.
# In the interview, it will be heavily dependent on the interviewer.

class MyHashSet:
    '''
    Uses two Hash Functions and Array as Buckets Strategy
    '''

    def __init__(self):
        '''
        Set the constant as the square root of the upper data range.
        '''
        self.k = (10 ** 3) 
        self.hashSet = [None] * self.k

    def add(self, key: int) -> None:
        key1 = key % self.k
        key2 = key // self.k
        
        if self.hashSet[key1] == None:
            self.hashSet[key1] = [None] * (self.k + 1) #If key is 10 ^ 6, key2 = 10 ^ 3. Hence, we need indexes from 0 to 10 ^ 3

        self.hashSet[key1][key2] = key
        

    def remove(self, key: int) -> None:
        key1 = key % self.k
        key2 = key // self.k
        if self.hashSet[key1] != None:
            if self.hashSet[key1][key2] == key:
                self.hashSet[key1][key2] = -1
                
    def contains(self, key: int) -> bool:
        key1 = key % self.k
        key2 = key // self.k
        if self.hashSet[key1] != None:
            return self.hashSet[key1][key2] == key

            
        


# Your MyHashSet object will be instantiated and called as such:
# obj = MyHashSet()
# obj.add(key)
# obj.remove(key)
# param_3 = obj.contains(key)