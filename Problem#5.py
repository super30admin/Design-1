'''
705. Design HashSet
'''

class MyHashSet: # humne MyHashSet class banayi hai jo ek hash set ko implement karegi (we design a MyHashSet class that will implement a hash set)

    def __init__(self): # constructor hai jo MyHashSet class ko initialize karega (this is the constructor that will initialize the MyHashSet class)
        '''Initialize your data structure here.'''
        self.size = 1000 # humne 1000 buckets banaye hain (we have created 1000 buckets)
        self.bucketArray = [Bucket() for i in range(self.size)] # humne har bucket ke liye ek Bucket object banaya hai (we have created a Bucket object for each bucket)

    def _hash(self, key):
        '''Hash function to get the index for the key.'''
        return key % self.size # ye function key ko hash karega aur index return karega (this function will hash the key and return the index) 

    def add(self, key: int) -> None:
        '''Add a key to the hash set.'''
        bucketIndex = self._hash(key) # key ka index nikalne ke liye _hash function call karega (call the _hash function to get the index for the key)
        self.bucketArray[bucketIndex].insert(key) # bucketArray ke corresponding bucket mein key ko insert karega (insert the key into the corresponding bucket in the bucketArray)
        

    def remove(self, key: int) -> None:
        '''Remove a key from the hash set.'''
        bucketIndex = self._hash(key) # key ka index nikalne ke liye _hash function call karega (call the _hash function to get the index for the key)
        self.bucketArray[bucketIndex].delete(key) # bucketArray ke corresponding bucket se key ko delete karega (delete the key from the corresponding bucket in the bucketArray)

    def contains(self, key: int) -> bool:
        '''Check if the key is in the hash set.'''
        bucketIndex = self._hash(key) # key ka index nikalne ke liye _hash function call karega (call the _hash function to get the index for the key)
        return self.bucketArray[bucketIndex].exists(key) # bucketArray ke corresponding bucket mein key exist karti hai ya nahi check karega (check if the key exists in the corresponding bucket in the bucketArray)


# Your MyHashSet object will be instantiated and called as such:
# obj = MyHashSet()
# obj.add(key)
# obj.remove(key)
# param_3 = obj.contains(key)

class Node: # humne Node class banaya hai jo linked list ke liye use hoga aur collision ko prevent karega (we design a Node class that will be used for linked list) 
    def __init__(self, value, nextNode=None): # Node class ka constructor hai jo value aur nextNode ko initialize karega (this is the constructor of Node class which will initialize value and nextNode)
        '''Initialize the node with a value and a pointer to the next node.'''
        self.value = value # value ko initialize karega (initialize the value)
        self.nextNode = nextNode # nextNode ko initialize karega (initialize the nextNode)

class Bucket: 
    def __init__(self):
        self.head = Node(0)

    def insert(self, newValue):
        # agar value exist nahi karti hai toh naya node insert karega (if the value does not exist, it will insert a new node)
        if not self.exists(newValue):
            newNode = Node(newValue, self.head.nextNode) # naya node banayega jo head ke nextNode ko point karega (create a new node that points to the head's nextNode)
            self.head.nextNode = newNode # head ke nextNode ko naya node se update karega (update the head's nextNode to the new node)

    def delete(self, value):
        prev = self.head # prev ko head se initialize karega (initialize prev to head)
        curr = self.head.nextNode # curr ko head ke nextNode se initialize karega (initialize curr to head's nextNode)
        while curr: # jab tak curr None nahi hai (while curr is not None)
            if curr.value == value: # agar curr ki value humaari argument waali value ke barabar hai (if curr's value is equal to the argument value)
                prev.nextNode = curr.nextNode # prev ke nextNode ko curr ke nextNode se update karega (update prev's nextNode to curr's nextNode)
                return # function se return karega (return from the function)
            prev = curr # prev ko curr se update karega (update prev to curr)
            curr = curr.nextNode # curr ko nextNode se update karega (update curr to its nextNode)

    def exists(self, value):
        curr = self.head.nextNode # curr ko head ke nextNode se initialize karega (initialize curr to head's nextNode)
        while curr: # jab tak curr None nahi hai (while curr is not None)
            if curr.value == value: # agar curr ki value humaari argument waali value ke barabar hai (if curr's value is equal to the argument value)
                return True # True return karega (return True)
            curr = curr.nextNode # curr ko nextNode se update karega (update curr to its nextNode)
        return False # agar value nahi mili toh False return karega (if the value is not found, return False)         