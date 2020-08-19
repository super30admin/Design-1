# // Time Complexity : O(1)
# // Space Complexity : O(n)
# // Did this code successfully run on Leetcode : Yes 
# // Any problem you faced while coding this : No


class Node:
    def __init__(self, key , value):
        self.key = key
        self.value = value
        self.next = None

class MyHashMap:

    def __init__(self):
        """
        Initialize your data structure here.
        """
        self.capacity = 100
        self.hashmap = [None]*self.capacity
        

    def hashfunc(self, key: int):
        return key%self.capacity
        
    def findElem(self, index: int, key: int):
        # if linked list isn't initialised
        if self.hashmap[index] == None:
            # add dummy head
            self.hashmap[index] = Node(-1, -1)
            return self.hashmap[index]
        # if key is present in the index, then
        else:
            # initialize the current node with hash index
            current = self.hashmap[index]

            # while there is current node and the current key is not equal to the key, set current to current.next
            while(current.next != None and current.next.key != key):
                current = current.next
            
            return current


    def put(self, key: int, value: int) -> None:
        """
        value will always be non-negative.
        """
        index = self.hashfunc(key)
        prev = self.findElem(index, key)

        if (prev.next == None):
            prev.next = Node(key, value)
        else:
            prev.next.value = value

    def get(self, key: int) -> int:
        """
        Returns the value to which the specified key is mapped, or -1 if this map contains no mapping for the key
        """
        index = self.hashfunc(key)
        prev = self.findElem(index, key)

        if (prev.next == None):
            return -1
        else:
            return prev.next.value 
        

    def remove(self, key: int) -> None:
        """
        Removes the mapping of the specified value key if this map contains a mapping for the key
        """
        index = self.hashfunc(key)
        prev = self.findElem(index, key)

        if (prev.next == None):
            return 
        else:
            prev.next = prev.next.next
        

# Test code

hashMap =  MyHashMap();
hashMap.put(1, 1);          
hashMap.put(2, 2);         
print(hashMap.get(1))            #returns 1
print(hashMap.get(3))          #returns -1 (not found)
hashMap.put(2, 1)         #update the existing value
print(hashMap.get(2))          #returns 1 
hashMap.remove(2)          #remove the mapping for 2
print(hashMap.get(2))          #returns -1 (not found) 