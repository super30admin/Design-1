# Time Complexity : O(1)
# Space Complexity : O(n)
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : I was initially working with arrays to create the hashmap. After the class I changed my approach to LinkedList which is more efficient


# Your code here along with comments explaining your approach 

class Node:
    def __init__(self, key, val):      #Create list for every array index to store the key,value with same hash index
        self.key = key
        self.val = val
        self.next = None

class MyHashMap(object):

    def __init__(self):
        """
        Initialize your data structure here.
        """
        self.size = 100
        self.hashmap = [None]*self.size
        
    def hashfunc(self, key):
        return key % self.size
    
    def findElem(self, index, key):
        if self.hashmap[index] == None:            #If the index is visited first time add a dummy node
            self.hashmap[index] = Node(-1,-1)
            return self.hashmap[index]
        else:
            curr = self.hashmap[index]              #Check for the element in the list if it's already created and return prev pointer

            while curr.next != None and curr.next.key != key:
                curr = curr.next
            return curr

    def put(self, key, value):
        """
        value will always be non-negative.
        :type key: int
        :type value: int
        :rtype: None
        """
        index = self.hashfunc(key)
        prev = self.findElem(index, key)

        if prev.next != None:                 #if next pointer to prev is present that means a value is present just update it or else add the new node
            prev.next.val = value
        else:
            prev.next = Node(key,value)
        

    def get(self, key):
        """
        Returns the value to which the specified key is mapped, or -1 if this map contains no mapping for the key
        :type key: int
        :rtype: int
        """
        index = self.hashfunc(key)
        prev = self.findElem(index, key)

        if prev.next != None:
            return prev.next.val
        else:
            return -1
        

    def remove(self, key):
        """
        Removes the mapping of the specified value key if this map contains a mapping for the key
        :type key: int
        :rtype: None
        """
        index = self.hashfunc(key)
        prev = self.findElem(index, key)

        if prev.next != None:
            prev.next = prev.next.next
        else:
            return -1

hm = MyHashMap()
hm.put(1,2)
hm.put(2,3)
hm.put(3,4)
print (hm.get(1))
print (hm.get(2))
hm.remove(1)
print (hm.get(1))
print (hm.hashmap[2].next.val)        