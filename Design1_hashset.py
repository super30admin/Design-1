'''
# Time Complexity : 
    O(1) for add, remove, contains
# Space Complexity :
    O(N) ~ N = 100001
# Did this code successfully run on Leetcode :
    - yes
# Any problem you faced while coding this :
    - Edge Case: 100001 Out of index
'''
class MyHashSet:

    def __init__(self):
        self.mySet = [None]*1001  # 10e6 max calls, each element will have 1000 more except the last one

    def getHashKey(self,key:int):
        '''
        Input: 
            Key: int 
        Return:
            col , row idx 
        '''
        return key//1000, key%1000 # 999 ~ 0, 999 | 1000000 ~ 1000, 0 

    def add(self, key: int) -> None:
        c, r = self.getHashKey(key)
        if c==1000:
            self.mySet[c] = True 
        else:
            if self.mySet[c] is None:
                self.mySet[c] = [None]*1000    
            self.mySet[c][r] = True

    def remove(self, key: int) -> None:
        if self.contains(key):
            c, r = self.getHashKey(key)
            if c==1000:
                self.mySet[c] =None
            else:
                self.mySet[c][r] = None

    def contains(self, key: int) -> bool:
        c, r = self.getHashKey(key)
        
        if c==1000:
            if self.mySet[c]:
                return True
            else:
                return False
        if self.mySet[c] is None:
            return False
        if self.mySet[c][r]:
            return True
        return False
        
        


# Your MyHashSet object will be instantiated and called as such:
# obj = MyHashSet()
# obj.add(key)
# obj.remove(key)
# param_3 = obj.contains(key)