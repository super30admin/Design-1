# Design-1

## Problem 1:(https://leetcode.com/problems/design-hashset/)

# Time Complexity : In design problems we consider time complexity for each function. It is perfect O(1) for add(), remove() and contains() methods
# Space Complexity : O(N) -- In worst case when all the buckets are filled
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : No

# Your code here along with comments explaining your approach
# we are using double hashing here as it gives perfect O(1) for add(), remove() and contains() methods
# We have divided our primary and secondary array into size of 10^3 each ie underoot(10^6) to make more balanced
# Our primary array stores the pointers to the secondary array. We initialize the secondary array only when we get the corresponding 
# hash1 value for that array
# As we do not need to return the value in any of the functions, so we store the secondary array as a boolean array
class MyHashSet(object):

    def __init__(self):
        self.primaryBuckets = 1000
        self.secondaryBuckets = 1000
        self.hashSetPrimaryArray = [None] * self.primaryBuckets
        
    def __hash1(self, key):
        return (key % self.primaryBuckets)

    def __hash2(self, key):
        return (key // self.secondaryBuckets)

    def add(self, key):
        """
        :type key: int
        :rtype: None
        """
        # for key = 10^6
        # hash1 = 0 (10^6 % 1000)
        # hash2 = 1000 (10^6 // 1000) -- would give out of bound
        # so for hash1 = 0, we need one extra space
        bucket = self.__hash1(key)
        bucketItem = self.__hash2(key)
        if(not self.hashSetPrimaryArray[bucket]):
            if(bucket == 0):
                self.hashSetPrimaryArray[bucket] = [False] * (self.secondaryBuckets + 1)
            else:
                self.hashSetPrimaryArray[bucket] = [False] * (self.secondaryBuckets)
        
        self.hashSetPrimaryArray[bucket][bucketItem] = True
        

    def remove(self, key):
        """
        :type key: int
        :rtype: None
        """
        bucket = self.__hash1(key)
        bucketItem = self.__hash2(key)
        if(self.hashSetPrimaryArray[bucket]):
            self.hashSetPrimaryArray[bucket][bucketItem] = False
        

    def contains(self, key):
        """
        :type key: int
        :rtype: bool
        """
        bucket = self.__hash1(key)
        bucketItem = self.__hash2(key)
        if(not self.hashSetPrimaryArray[bucket]):
            return False
        
        return self.hashSetPrimaryArray[bucket][bucketItem]

        

print("Method-1: Double Hashing")
myHashSet = MyHashSet()
myHashSet.add(1)
myHashSet.add(2)
print(myHashSet.contains(1))
print(myHashSet.contains(3))
myHashSet.add(2)
print(myHashSet.contains(2))
myHashSet.remove(2)
print(myHashSet.contains(2))
myHashSet2 = MyHashSet()
myHashSet2.add(11)
myHashSet2.add(21)
myHashSet2.add(22)
myHashSet2.add(20)
print(myHashSet2.contains(16))
myHashSet2.add(16)
print(myHashSet2.contains(1))
print(myHashSet2.contains(3))
print(myHashSet2.contains(11))
print(myHashSet2.contains(21))
print(myHashSet2.contains(22))
print(myHashSet2.contains(20))
print(myHashSet2.contains(16))
myHashSet2.remove(16)
print(myHashSet2.contains(16))




# Method-2
# Using Linear Chaining

# Time Complexity : In design problems we consider time complexity for each function. It is amortized O(1) for add(), remove() and contains() methods
# Space Complexity : O(N) -- In worst case when all the buckets and linkedlist are occupied
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : No

# Your code here along with comments explaining your approach
# we are using linear chaining here. It gives amortized O(1) for add(), remove() and contains() methods
# We have taken our primary array of size 10^4. This helps to reduce the number of collisions to 100. Thus our linkedlist size
# reduces to 100. 
# Our primary array stores the pointers to the dummy node of linkedlist. We initialize the secondary array only when we get the corresponding 
# hash1 value for that array
# We store the key in our linkedlist

class Node(object):
    def __init__(self, val = 0):
        self.data = val
        self.next = None

class MyHashSetLinearChain(object):

    def __init__(self):
        self.primaryBuckets = 10000
        # self.secondaryBuckets = 1000
        self.hashSetPrimaryArray = [None] * self.primaryBuckets

        
    def __hash1(self, key):
        return (key % self.primaryBuckets)
    
    def __getPrevNode(self, head, key):
        prev = head
        curr = head.next
        while(curr):
            if(curr.data == key):
                return prev
            prev = curr
            curr = curr.next

        return prev

    def add(self, key):
        """
        :type key: int
        :rtype: None
        """
        # for key = 10^6
        # hash1 = 0 (10^6 % 1000)
        # hash2 = 1000 (10^6 // 1000) -- would give out of bound
        # so for hash1 = 0, we need one extra space
        bucket = self.__hash1(key)
        if(not self.hashSetPrimaryArray[bucket]):
            self.hashSetPrimaryArray[bucket] = Node(-1)
            # if(self.__hash1(key) == 0):
            #     self.hashSetPrimaryArray[self.__hash1(key)] = [False] * (self.secondaryBuckets + 1)
            # else:
            #     self.hashSetPrimaryArray[self.__hash1(key)] = [False] * (self.secondaryBuckets)
        prev = self.__getPrevNode(self.hashSetPrimaryArray[bucket], key)
        if(not prev.next):
            newNode = Node(key)
            prev.next = newNode
        # self.hashSetPrimaryArray[self.__hash1(key)][self.__hash2(key)] = True
        

    def remove(self, key):
        """
        :type key: int
        :rtype: None
        """
        bucket = self.__hash1(key)
        if(self.hashSetPrimaryArray[bucket]):
            prev = self.__getPrevNode(self.hashSetPrimaryArray[bucket], key)
            if(prev.next):
                curr = prev.next
                prev.next = curr.next
                curr.next = None
        

    def contains(self, key):
        """
        :type key: int
        :rtype: bool
        """
        bucket = self.__hash1(key)
        if(self.hashSetPrimaryArray[bucket]):
            prev = self.__getPrevNode(self.hashSetPrimaryArray[bucket], key)
            if(prev.next):
                return True

        return False
    
print("Method-2: Linear Chaining")
myHashSet = MyHashSet()
myHashSet.add(1)
myHashSet.add(2)
print(myHashSet.contains(1))
print(myHashSet.contains(3))
myHashSet.add(2)
print(myHashSet.contains(2))
myHashSet.remove(2)
print(myHashSet.contains(2))
myHashSet2 = MyHashSet()
myHashSet2.add(11)
myHashSet2.add(21)
myHashSet2.add(22)
myHashSet2.add(20)
print(myHashSet2.contains(16))
myHashSet2.add(16)
print(myHashSet2.contains(1))
print(myHashSet2.contains(3))
print(myHashSet2.contains(11))
print(myHashSet2.contains(21))
print(myHashSet2.contains(22))
print(myHashSet2.contains(20))
print(myHashSet2.contains(16))
myHashSet2.remove(16)
print(myHashSet2.contains(16))