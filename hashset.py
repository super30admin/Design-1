"""
similar approach to what was taught in class, but instead of considering a special additional 1 bucket for 0, I added 10000 as the size (in my earlier lc attempt)
if feel this approach would look good in interviews as it talks about handling cases in innovative ways
idea is to create buckets as and when needed (for primary storage) and then follow the same instructions with different approaches for push pop and check operations
since we just check the boolean value through mathematcal hash funtions, the tc for this is O(1) and space will be O(1) for initialization and o(n) once we start building

"""


class MyHashSet(object):

    def __init__(self):
        self.primarystorage = 1000
        self.secondarystorage = 1000
        self.storage = [None] * self.primarystorage #buckets created only when needed

    def firsthashfunction(self, key):
        return key % self.primarystorage #first hash to get primary index

    def secondhashfunction(self, key): 
        return key // self.secondarystorage #second hash to get secondary index

    def add(self, key):
        """
        :type key: int
        :rtype: None
        """
        primaryidx = self.firsthashfunction(key)
        if self.storage[primaryidx] is None:
            if primaryidx == 0:
                self.storage[primaryidx] = [False] * (self.secondarystorage + 1) #the special case of 0
            else:
                self.storage[primaryidx] = [False] * (self.secondarystorage)
        secondaryidx = self.secondhashfunction(key)
        self.storage[primaryidx][secondaryidx] = True #make it true as element exists here

        

    def remove(self, key):
        """
        :type key: int
        :rtype: None
        """
        primaryidx = self.firsthashfunction(key)
        if self.storage[primaryidx] is None:
            return
        secondaryidx = self.secondhashfunction(key)
        self.storage[primaryidx][secondaryidx] = False #change to false if element exists


    def contains(self, key):
        """
        :type key: int
        :rtype: bool
        """
        primaryidx = self.firsthashfunction(key)
        if self.storage[primaryidx] is None:
            return False #element doesnt exisit
        secondaryidx = self.secondhashfunction(key)
        return self.storage[primaryidx][secondaryidx] #retun the boolean if it exists or not (wrt to secondary index)
        


# Your MyHashSet object will be instantiated and called as such:
# obj = MyHashSet()
# obj.add(key)
# obj.remove(key)
# param_3 = obj.contains(key)