# Time Complexity : O(1) in best case and O(n) in worst case Time Complexity
# Space Complexity : O(1) in best case and O(n) in worst case Space Complexity
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : No

# Can be further optimised by sorting the linkedlist possibly using a previous pointer
class Node(object):
    def __init__(self,key,value):
        self.key = key
        self.value = value
        self.next = None
        
class MyHashMap:

    def __init__(self):
        self.array = [None for i in range(1000)] 
    
    def getIndex(self,key):
        index = key % 1000
        return index
    
    def getElement(self,key):
        index = self.getIndex(key)
        if self.array[index] == None:
            dummyNode = Node(-1,-1)
            self.array[index] = dummyNode
            return dummyNode
        
        currentNode = self.array[index]
        while currentNode.next != None:
            if currentNode.next.key == key:
                return currentNode
            currentNode = currentNode.next
        return currentNode

    def put(self, key, value):
        
        currentNode = self.getElement(key)
        
        if currentNode.next == None:
            currentNode.next = Node(key,value)
        else:
            currentNode.next.value = value
        
    def get(self, key):
        
        currentNode = self.getElement(key)
        
        if currentNode.next == None:
            return -1
        else:
            return currentNode.next.value
        

    def remove(self, key):
        currentNode = self.getElement(key)
        
        if currentNode.next != None:
            currentNode.next = currentNode.next.next
        return
            
    
# Your MyHashMap object will be instantiated and called as such:
# obj = MyHashMap()
# obj.put(key,value)
# param_2 = obj.get(key)
# obj.remove(key)