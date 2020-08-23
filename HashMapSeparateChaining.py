"""
Time : O(1+alpha) = O(1) where alpha = load factor = num of keys/num of slots
Space : O(n)

Approach:
Separate Chaining HashMap using  linked list
"""


class ListNodeMap:
    def __init__(self,key,val):
    self.pair = (key,val)
    self.next = None

class HashMap:
    def __init__(self):
        self.size = 1000
        self.blocks = [None]*self.size

        def insert(self,key,value):
        index = key % self.size
        curr = self.blocks[index]
        if not curr: # Create a new node with key,value if curr is empty
              self.blocks[index] = ListNodeMap(key,value)
        else:
            while True:
            if curr.pair[0] == key: #if key already exists, return
                curr.pair = (key, value) #update
            return
            if not curr.next: break
            curr = curr.next
            curr.next = ListNodeMap(key,value)

    def get(self,key): #Returns the value for the key,-1 if the map doesn't contain key
        index = key%self.size
        curr = self.blocks[index]
        while curr:
            key_here,value = curr.pair
            if key_here == key:
                print(value)
                return value
            curr = curr.next
        return -1

    def delete(self,key):
        index = key%self.size
        curr = prev = self.blocks[index]
        if not curr: 
            return
        if curr.pair[0] == key:
            self.blocks[index] = curr.next
        else:
            curr = curr.next
            while curr:
                if curr.pair[0] == key:
                    prev.next = curr.next
                    break
                else:
                    curr, prev = curr.next, prev.next

    def printHashMap(self):
        for item in self.blocks:
            if item is not None:
              #node = item.head 
                print(item.pair,end = "->")
                item = item.next
                print("Null")
                
                
                
                
# Driver Code
bjHashMap = HashMap()
objHashMap.insert(1,"a")
objHashMap.insert(1,"b")
objHashMap.insert(2,"c")
objHashMap.insert(2,"ff")
objHashMap.insert(3,"d")
objHashMap.get(2)
objHashMap.delete(2)
objHashMap.get(2)

objHashMap.printHashMap()