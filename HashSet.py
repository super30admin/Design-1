#  Time Complexity : - o(1) for each method
#  Space Complexity : o(n1*n2) - in worst base both primary and secondary buckets might be full 
#  Did this code successfully run on Leetcode : yes
#  Any problem you faced while coding this : 
    #  I initially implemented using list in python without hashing , but was able to do it with hashing after learning different methods in lecture
    #  Faced some issue declaring 2d array in python for implementation


# // Your code here along with comments explaining your approach
#  1) idea is to have o(1) for search using arrays and double hashing 
#  2) decisions made were - choose prim and second buck size then hash1 and has2 functions to ensure 0 collision in nesting and uniform distributions
#  3) implement methods using the datastructure we created for hashing considering edge case for keys mapping to 0 in buckets
#       since there will be one extra buckeetItem for that

class MyHashSet:

    def __init__(self):
        self.bucketItems = 1000
        self.buckets = 1000
        self.storage = [[] for _ in range(self.buckets)]

    def hashFunc1(self,key):
        return key%self.buckets

    def hashFunc2(self,key):
        return key//self.bucketItems

    def add(self, key: int) -> None:
        idx1 = self.hashFunc1(key)
        idx2 = self.hashFunc2(key)
        if not self.storage[idx1]:
            if idx1 == 0:
                self.storage[idx1] = [False]*(self.bucketItems +1)
            else:
                self.storage[idx1] = [False]*(self.bucketItems)
        self.storage[idx1][idx2] = True

    def remove(self, key: int) -> None:
        idx1 = self.hashFunc1(key)
        idx2 = self.hashFunc2(key)
        if not self.storage[idx1]:
            return None
        self.storage[idx1][idx2] = False
        

    def contains(self, key: int) -> bool:
        idx1 = self.hashFunc1(key)
        idx2 = self.hashFunc2(key)
        if not self.storage[idx1] or not self.storage[idx1][idx2]:
            return False
        return True

# Your MyHashSet object will be instantiated and called as such:
obj = MyHashSet()
obj.add(1)
obj.add(2)
print(obj.contains(1))
print(obj.contains(3))
obj.add(2)
print(obj.contains(2))
obj.remove(2)
print(obj.contains(2))
