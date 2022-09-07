# Time Complexity :- contains O(N/K) where N is number of values and K is the number of buckets 
# Space Complexity : - O(K+U) where K is the range of bucket and U is the Number of unique values
# Did this code successfully run on Leetcode : Yes 
# Any problem you faced while coding this : While writing this code as discussed in yesterday lecture was trying to figure out which mwethod would be efficeint Binary Tree or LinkedList 


class MyHashSet(object):

    def __init__(self):
        self.bucketRange = 101
        self.bucketArray = []
        for i in range(self.bucketRange):
            self.bucketArray.append(Bucket())
        

    def getHashValue(self, key):
        return key % self.bucketRange

    def add(self, key):
        indexValue = self.getHashValue(key)
        self.bucketArray[indexValue].insert(key)

    def remove(self, key):
        indexValue = self.getHashValue(key)
        self.bucketArray[indexValue].removeData(key)

    def contains(self, key):
        indexValue = self.getHashValue(key)
        return self.bucketArray[indexValue].isPresent(key)


class Node:
    def __init__(self, value, next=None):
        self.value = value
        self.next = next

class Bucket:
    def __init__(self):
        self.head = Node(0)

    def insert(self, newValue):
        if not self.isPresent(newValue):
            newNode = Node(newValue, self.head.next)
            self.head.next = newNode

    def removeData(self, value):
        previous = self.head
        current = self.head.next
        while current:
            if current.value == value:
                previous.next = current.next
                return
            previous = current
            current = current.next

    def isPresent(self, value):
        current = self.head.next
        while current:
            if current.value == value:
                return True
            current = current.next
        return False

