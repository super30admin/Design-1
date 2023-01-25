# Passed all Test cases in leetcode

class MyHashSet:

    def __init__(self):
        self.capacity = 1000
        self.primaryList = [None] * self.capacity


    def primaryHashFunction(self, key):
        return key % self.capacity


    def secondaryHashFunction(self, key):
        return int(key / self.capacity)


    # time complexity - O(1)
    # space complexity - depends on how many elements added
    # Here we use list of list to store the element.
    # At the beginning only a single list of capacity is  created, once hash function
    # returns index we create a new  boolean list within this list and using the second
    # hash function we get the secondary index. The item at primary index, secondary index
    # is made True
    def add(self, key: int) -> None:
        hf1 = self.primaryHashFunction(key)
        hf2 = self.secondaryHashFunction(key)
        if not self.primaryList[hf1]:
            if hf1 == 0:
                self.primaryList[hf1] = [False for i in range(self.capacity + 1)]
            else:
                self.primaryList[hf1] = [False for i in range(self.capacity)]
        self.primaryList[hf1][hf2] = True


    # time complexity - O(1)
    # space complexity - depends on how many elements added
    # Here we firstly check using first hash function if new boolean list within it is initialised.
    # If yes then we check the index at [primary index][secondary index] in list of list.
    # If its true then we make it False and return.
    def remove(self, key: int) -> None:
        hf1 = self.primaryHashFunction(key)
        hf2 = self.secondaryHashFunction(key)
        if not self.primaryList[hf1]:
            return
        self.primaryList[hf1][hf2] = False


    # time complexity - O(1)
    # space complexity - depends on how many elements added, 
    # Here we firstly check using first hash function if new boolean list within it is initialised.
    # If yes then we check the index at [primary index][secondary index] in list of list.
    # We then return the value at this index. If not initialised then we return False.
    def contains(self, key: int) -> bool:
        hf1 = self.primaryHashFunction(key)
        hf2 = self.secondaryHashFunction(key)
        if not self.primaryList[hf1]:
            return False
        return self.primaryList[hf1][hf2]



s = MyHashSet()
s.add(67000)
s.add(209800)
s.add(1000000)
s.remove(1)
print(s.primaryList[0])
print(s.contains(20000))
print(s.contains(67000))
