# S30 approach

class Node:
    def __init__(self, key, val):
        self.key = key
        self.val = val
        self.next = None

class MyHashMap:
    def __init__(self):
        self.hashmap = [None]*10000 
    
    def index(self, key):
        return key%len(self.hashmap)
    
    def getPrev(self, index, key):
        if(self.hashmap[index] is None):
            self.hashmap[index] = Node(-1, -1)
        
        prev = self.hashmap[index] 
        
        while((prev.next is not None) and (prev.next.key != key)):
            prev = prev.next
        
        return prev
    
    def put(self, key, value):
        index = self.index(key)
        prev = self.getPrev(index, key)
        
        # if exists, then change the value, else add new node
        
        if(prev.next is None): 
            prev.next = Node(key, value)
        else:
            prev.next.val = value
    
    def get(self, key):
        index = self.index(key)
        prev = self.getPrev(index, key)
        
        # return the value if key is there, else return -1
        
        return (-1 if prev.next is None else prev.next.val)
    
    def remove(self, key):
        index = self.index(key)
        prev = self.getPrev(index, key)
        
        if prev.next is not None: # checking so that prev.next.next does not throw null pointer exception
            prev.next = prev.next.next
           
        
# Space complexity: O(M+K) where M is the size of array and K is the size of LinkedList
# Since size of array is fixed, Space complexity is just O(K)

# Let size of array be M and you have N (k, v pairs). Then, time complexity would be O(N/M)
