# Time Complexity : O(n)
#  Space Complexity : O(n)
#  Did this code successfully run on Leetcode : Yes, after modifying the size to 100000. It passes all the tests for size 100000 and 1000000. Fails with TLE for rest
# Any problem you faced while coding this : Yes, it gave time limit exceeded when size is lesser than the specified limit.
# So the idea is to have a hash of a range of particular size and have a linked list for the range of index. But its only running successfully for size values 100000 and 1000000(max range value mentioned in leetcode question)

# Your code here along with comments explaining your approach

# Linked list node to store key, value pair for each hash index
class Node:
    def __init__(self,key,value):
        self.key = key
        self.value = value
        self.next = None

class MyHashMap:
    def __init__(self):
        self.size = 100000 # this size needs to be tweaked to make the code efficient
        self.hash_map = [None] * self.size
    
    # function to return the hash index for a range
    def getHash(self,key):
        return key % self.size

    def put(self,key,value):
        index = self.getHash(key)
        # if index isn't present in hashmap then create a new node and return
        if not self.hash_map[index]:
            self.hash_map[index] = Node(key,value)
            return
        # else get the first node for the index
        currentNode = self.hash_map[index]

        # traverse through the linked list for the index hash
        while currentNode:
            # if key is found update the value for the node
            if currentNode.key == key:
                currentNode.value = value
                return
            # else go to the next node
            if currentNode.next:
                currentNode = currentNode.next
        # if key isn't found create new node at the end of linked list
        currentNode.next = Node(key,value)

    def get(self,key):
        # get the index hash for range
        index = self.getHash(key)
        node = self.hash_map[index]
        # traverse through the linked list of the index
        while node:
            # if key exists return the value
            if node.key == key:
                return node.value
            node = node.next
        # else return -1
        return -1

    def remove(self,key):
        index = self.getHash(key)
        # if nothing to be removed return
        if not self.hash_map[index]:
            return
        # else get the first node for the index hash range list
        current = previous = self.hash_map[index]
        # if first node then make the next node as first, if there is no next node hash range node will be None
        if current.key == key:
            self.hash_map[index] = current.next
            return
        current = current.next
        while current:
            # if key found then make the next variable of previous node point to next of current node
            if current.key == key:
                previous.next = current.next
                return
            # increment both pointers
            previous = previous.next
            current = current.next

hashMap = MyHashMap()
hashMap.put(1, 1)        
hashMap.put(2, 2)         
print(hashMap.get(1))

