# Time Complexity - O(1)
# Space Complexity - O(square root of lenght)
# Problems faced - the use of keyword self, in add fucntion did not checked if the 
#                   primary index is None and initialized it multiple times. And 
#                    general use of 2D array in python. 

class MyHashSet(object):

    def __init__(self):
        self.hor = 1000
        self.ver = 1000
        self.arrHor = [None] * self.hor
        self.key = 0

    def hashHor(self, key):
        return key%self.hor 

    def hashVer(self, key):
        return key//self.ver     

    def add(self, key):
        """
        :type key: int
        :rtype: None
        """
        horIndex = self.hashHor(key)
        verIndex = self.hashVer(key)
        if self.arrHor[horIndex] is None:
            if (horIndex == 0):
                self.arrHor[horIndex] = [False] * (self.ver + 1)
            else:
                self.arrHor[horIndex] = [False] * self.ver
        self.arrHor[horIndex][verIndex] = True 
        
    def remove(self, key):
        """
        :type key: int
        :rtype: None
        """
        horIndex = self.hashHor(key)
        verIndex = self.hashVer(key)
        if (self.arrHor[horIndex]):
            self.arrHor[horIndex][verIndex] = False
                
    def contains(self, key):
        """
        :type key: int
        :rtype: bool
        """
        horIndex = self.hashHor(key)
        verIndex = self.hashVer(key)
        if (self.arrHor[horIndex]):
            if (self.arrHor[horIndex][verIndex] == True):
                return True
        return False

# Your MyHashSet object will be instantiated and called as such:
# obj = MyHashSet()
# obj.add(key)
# obj.remove(key)
# param_3 = obj.contains(key)
